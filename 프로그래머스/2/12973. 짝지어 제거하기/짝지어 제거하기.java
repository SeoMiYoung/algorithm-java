import java.util.*;
// 스택아님?
// - 하나씩 문자를 넣는다.
//     - 이전의 문자와 이번에 넣는 문자 비교해서 같으면 둘다 없앰. 

class Solution
{
    public int solution(String s)
    {
        Deque<Character> dq = new ArrayDeque<>(); 
        
        for (char c : s.toCharArray()) {
            if (dq.isEmpty()) {  // deque가 비어있다면
                dq.offerFirst(c); 
            }
            else {  // 비어있지 않다면
                char getTop = dq.peekFirst();  // 가장 최근 char값을 얻기
                if (getTop == c) {
                    dq.pollFirst();
                }
                else {
                    dq.offerFirst(c);
                }
            }
        }
        
        // 만약 deque가 비어있다면 모두 제거 성공 
        return dq.isEmpty() ? 1 : 0;
    }
}