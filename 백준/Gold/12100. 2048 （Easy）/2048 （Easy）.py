
# <입력 처리>
N = int(input());
board = [list(map(int, input().split())) for _ in range(N)];
# print(board);

# <무조건 왼쪽으로 merge하는 함수>
def merge(line): # [2,0,2,8]
    # 0 제거
    no_zero_line = [i for i in line if i!=0]; # [2,2,8]

    num_arr = []; # 합쳐진 숫자 모을 곳
    skip = False;
    for i in range(0, len(no_zero_line)): # 0,1,2
        if skip == True:
            skip = False;
            continue;

        if i == len(no_zero_line)-1:
            num_arr.append(no_zero_line[i]);
            break;

        if no_zero_line[i] == no_zero_line[i+1]:
            num_arr.append(2*no_zero_line[i]);
            skip = True;
        else:
            num_arr.append(no_zero_line[i]);
    # 0 채우기
    while len(num_arr) < len(line):
        num_arr.append(0);

    return num_arr;



# <한번의 움직임을 처리하는 move함수>
def move(board, dir):
    # 조작할 깊은 복사 board 만들기
    ## copy.deepcopy()는 왜 피하라고 하는걸까? --> 느리다, 무겁다, 시간 초과 각
    copy_board = [b[:] for b in board]; # 2차원 리스트를 깊이 복사하는 방법

    if dir==0: # 상으로 합치기
        for index in range(len(copy_board)):
            column = [copy_board[x][index] for x in range(len(copy_board))]; # 열: [2, 0, 2, 8]
            merged = merge(column);  # [4, 8, 0, 0]

            for index2 in range(len(copy_board)):
                copy_board[index2][index] = merged[index2];

    if dir==1: # 하
        for index in range(len(copy_board)):
            column = [copy_board[x][index] for x in range(len(copy_board))]; # 열: [2, 0, 2, 8]
            merged = merge(column[::-1])[::-1];  # [4, 8, 0, 0]

            for index2 in range(len(copy_board)):
                copy_board[index2][index] = merged[index2];

    if dir==2: # 좌
        for index, value in enumerate(copy_board):
            copy_board[index] = merge(value);
    if dir==3: # 우
        for index, value in enumerate(copy_board):
            copy_board[index] = merge(value[::-1])[::-1]; # ✅ 슬라이싱으로 전체를 역순으로 만든다!


    return copy_board;

# <DFS>
answer = -1;
def DFS(board, depth):
    global answer;

    if depth == 5:
        get_max = max(map(max, board));
        if get_max > answer:
            answer = get_max;
        return;

    for dir in range(4): # 0=상, 1=하, 2=좌, 3=우
        next_board = move(board, dir); # 한 번 움직였을 때 다음 보드 상태를 넘겨준다.
        DFS(next_board, depth+1);

DFS(board, 0);
print(answer);