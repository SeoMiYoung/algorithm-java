import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) throws Exception {
        // split은 인자 기준으로 나눠서, String 배열을 반환
        String[] sArr = s.split(" "); // ["1", "2", "3", "4"] 
        
        // System.out.println(Arrays.deepToString(sArr));  // [1, 2, 3, 4]
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String getS : sArr) {
            int num = Integer.parseInt(getS);  // 문자열 --> 숫자 
            
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        
        // 출력 
        return String.format("%d %d", min, max);
    }
}