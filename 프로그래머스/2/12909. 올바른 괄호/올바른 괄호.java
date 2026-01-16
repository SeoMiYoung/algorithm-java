/*
* 스택 구조

사실 이 문제는 괄호 종류가 () 하나뿐이라서, 굳이 무거운 스택(메모리)을 안 써도 됩니다. 
숫자 카운팅(int)만으로 풀면 속도가 훨씬 빠릅니다. (고수들은 이렇게 풉니다)
- 스택 push 대신 +1
- 스택 pop 대신 -1
*/                         

import java.util.*;
import java.io.*;
                                  
class Solution {
    boolean solution(String s) {
        boolean answer = true; // 일단 정답은 true로 설정
        
        Deque<Character> dq = new ArrayDeque<>(); // 스택 (문자 담는)
        
        char[] sCharArr = s.toCharArray();  // [')', '(', ')', '(']
        for (char c : sCharArr) {
            if (c == '(') {
                // 스택에 넣는다.
                dq.offerFirst(c);
            }
            else {  // ')'
                // 스택이 비어있다? = '('가 하나도 없다. (어짜피 스택에는 '('만 넣으니깐!)
                if (dq.isEmpty()) {
                    // 문제 발생
                    answer = false;
                    break;
                }
                else {
                    // 스택이 비어있지 않다면? --> '('가 하나라도 있다.
                    dq.pollFirst(); // 하나 꺼내기 
                }
            }
        }
        
        // 모든 과정이 끝났을 때 스택이 텅 비어있어야 성공!
        // 남아 있다면 여는 괄호 '('가 너무 많은 것임 (예: "((()")
        if (!dq.isEmpty()) {
            return false;
        }
        
        return answer;
    }
}