import java.util.*;
import java.io.*;

// [주의] 공백문자가 연속해서 나올 수 있습니다.
//    split은 '연속된 공백'이나 '문자열 끝의 공백'처리가 까다로움 --> split 사용은 피해야함
//    그래서 문자열을 직접 쪼개는 방식보다는 문자 하나씩 순회하며 직전 문자가 공백이었는지 확인하는 flag 방식을 써야함 


class Solution {
    static StringBuilder sb;
    
    public String solution(String s) {
        sb = new StringBuilder();
        
        s = s.toLowerCase(); // 모두 소문자로 변환 후 시작
        boolean flag = true; // 단어의 첫 시작인가?
        String answer = "";
        
        char[] words = s.toCharArray(); // [3, p, e, o, p, l, e,  , u, n, f, o, l, l, o, w, e, d,  , m, e]
        for (char c : words) {
            if (c == ' ') { // 공백 나오면 그대로 넣어줌
                sb.append(c);
                flag = true; // 유지
            }
            else {
                if (flag) {  // 첫 글자
                    sb.append(Character.toUpperCase(c)); // 대문자로 넣는다. (숫자여도 toUpperCase는 에러안남)
                    flag = false;
                }
                else {  // 첫 글자가 아님
                    sb.append(c);
                }
            }
            
        }
        return sb.toString();
    }
}