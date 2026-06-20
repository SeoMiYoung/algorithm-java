import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String[] numStringList = s.split(" "); // ["1", "2", "3", "4"]
        
        // 일단 최소값, 최대값 초기화하기
        int maxNum = Integer.parseInt(numStringList[0]);
        int minNum = Integer.parseInt(numStringList[0]);
        
        for (String getString : numStringList) {
            maxNum = Math.max(maxNum, Integer.parseInt(getString));
            minNum = Math.min(minNum, Integer.parseInt(getString));
        }
        
        return String.format("%d %d", minNum, maxNum);
    }
}