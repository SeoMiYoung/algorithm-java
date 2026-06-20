import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) { // "110010101001"
        int[] answer = {0,0}; // 회차, 제거한 0의 개수
        
        while (!s.equals("1")) {
            answer[0]++;
            
            // step1. s의 모든 0을 제거합니다.
            String removeZeroS = s.replace("0", ""); // "111111"
            answer[1] += (s.length() - removeZeroS.length()); // 12-6
            String nextS = Integer.toBinaryString(removeZeroS.length());
            
            
            // 다음으로 넘어가기 전에 s업데이트
            s = nextS;
        }
        
        
        return answer;
    }
}