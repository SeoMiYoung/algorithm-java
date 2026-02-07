import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br;
	static int height, width;
	static int[][] board;
	static int maxSafeArea = 0;
	
	static List<Position> blankList;  // 빈 공간의 위치 정보 저장
	                                  //    - 문제에서 새로운 벽 3개를 세워야 하는데, 벽은 빈 공간에만 세울 수 있습니다.
	                                  //    - 따라서 빈 공간의 좌표를 모두 모아놓고, 이 리스트에서 3개의 위치를 고르는 모든 조합을 탐색하기 위해 필요합니다. 
	static List<Position> virusList;  // 바이러스 위치 정보 저장
	                                  //    - 벽을 3개 세우고 나면, 이제 바이러스가 퍼지는 상황을 시뮬레이션해야 합니다.
	                                  //    - 바이러스 전파는 BFS(너비 우선 탐색)를 사용하여 구현하는데, BFS는 시작 지점(들)에서부터 탐색을 시작합니다. 
	
	// 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	static class Position {           // 좌표 저장 class
		int y;
		int x;
		
		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void calculateSafeArea(int[][] arr) {
		int countSafe = 0;
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (arr[i][j] == 0) {
					countSafe++;
				}
			}
		}
		
		maxSafeArea = Math.max(maxSafeArea, countSafe);
	}
	
	public static void spreadVirus() {  // bfs
		// 현재 배열 상태를 복사해서 확인함(원본 훼손을 안하기 위해)
		int[][] copyBoard = new int[height][width];
		
		for (int y=0; y<height; y++) {
			copyBoard[y] = board[y].clone();  // 1차원 배열에 대해 복사본을 만드는 clone()
		}	
			
		Deque<Position> queue = new ArrayDeque<>();
		// 초기 바이러스 위치를 큐에 모두 넣음
		//    - 일반적인 BFS는 시작점이 하나지만, 
		// 이 문제에서는 바이러스가 여러 곳에서 동시에 존재하기 때문에 모든 바이러스의 위치를 큐에 한꺼번에 넣고 BFS를 시작하는 겁니다. 
		for (Position virusPos : virusList) {
			queue.offerLast(virusPos);
		}
			
			
		while (queue.isEmpty() == false) {
			Position getPos = queue.pollFirst();
				
			for (int i=0; i<4; i++) {  // 상,하,좌,우로 바이러스 전파
				int newY = getPos.y + dy[i];
				int newX = getPos.x + dx[i];
					
				// 맵 경계 내에 있고, 빈 공간(0)이라면
				if (newY >= 0 && newX >= 0 && newY < height && newX < width) {
					if (copyBoard[newY][newX] == 0) {
						copyBoard[newY][newX] = 2;  // 바이러스 감염
						queue.offerLast(new Position(newY, newX));
					}
				}
			}
		}
		
		// 바이러스 전파 후 안전 영역 크기 계산
		calculateSafeArea(copyBoard);
		
	}
	
	public static void selectThree(int start, int selectedNum) {  // dfs
		// 벽 3개를 모두 세웠다면, 바이러스 전파 시뮬레이션 시작 
		if (selectedNum == 3) {
			spreadVirus();
			return;
		}
		
		// 재귀 호출을 통해 조합 생성
		for (int i=start; i<blankList.size(); i++) {
			Position getP = blankList.get(i);  // i 번째 위치 빈공간 위치 가져오기
			
			board[getP.y][getP.x] = 1;  // 벽 세우기
			selectThree(i+1, selectedNum+1);
			board[getP.y][getP.x] = 0;  // 다시 빈 공간으로 만들기 (백트래킹) 
			/*
			 * Q. 배열 복사가 필요 없나요?
			 * A. 네
			 *    - dfs에서는 되돌리기 과정 때문에 배열을 복사하지 않아도 다음 탐색 경로가 원래의 깨끗한 상태에서 시작될 수 이씃ㅂ니다. 
			 *    - 배열 복사가 필요한 경우는 백트래킹이 아닌 다른 함수(ex. bfs)를 호출할 때입니다. 
			 */
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		board = new int[height][width];
		blankList = new ArrayList<>();
		virusList = new ArrayList<>();
		
		for (int y=0; y<height; y++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int x=0; x<width; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
				
				if (board[y][x] == 0) {  // 만약에 빈 공간
					blankList.add(new Position(y, x));
				}
				else if (board[y][x] == 2) {
					virusList.add(new Position(y, x));
				}
			}
		}
		
		// dfs로 3개의 벽을 세우는 조합을 구한다.
		//   - 조합은 파라미터/기저조건 2개
		//   - start(조합을 위한 시작 인덱스 정보), selectedNum(몇 개 선택)
		selectThree(0, 0);
		
		// 출력
		System.out.println(maxSafeArea);
	}

}
