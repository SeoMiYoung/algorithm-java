import java.util.*;
import java.io.*;

// 보자마자 느낀 건, 무조건 스택이다!
class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>(); // 문자형 넣는 스택
        boolean isOk = true; // 문제 없음
        
        char[] charArr = s.toCharArray(); // ['(', ')', '(', ')']
        for (char c : charArr) {
            if (c=='(') {
                dq.offerFirst(c); // 일단 넣는다
            }
            else { // ')'가 왔을때
                if (dq.isEmpty()) {
                    // 애초에 잘못된거임
                    isOk = false;
                    break;
                }
                // 그게 아니라면,
                char getTop = dq.peek(); // 가장 위에꺼 먼저 본다
                if (getTop == ')') {
                    isOk = false;
                    break;
                }
                // 문제가 없다.
                dq.poll();
            }
        }
        
        if (!dq.isEmpty()) {
            isOk = false;
        }
        
        return isOk;

    }
}