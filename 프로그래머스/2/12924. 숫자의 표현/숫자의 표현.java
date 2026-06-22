// 연속된 구간 --> 투포인터 or 슬라이딩 윈도우
// 그런데, 이 문제는 윈도우 크기가 고정된 건 아니여서 --> 투 포인터

// 일단 1부터 n까지 합이 n(n+1)/2임
// 그러면 a부터 b까지 합은 
// b(b+1)/2 - a(a+1)/2 + a

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {  // 15
        int answer = 0;
        
        int start = 1;
        int end = 1; 
        
        while (start <= end) {
            int twoPointSum = (end*(end+1)/2 - start*(start+1)/2 + start);
            
            if (twoPointSum == n) {
                answer++;
                end++;
            }
            else if (twoPointSum < n) {
                //  목표보다 작으면, 당연히 우측을 더 포함해야해.
                end++;
            }
            else {
                // 목표보다 크면, 줄여야 하니깐 좌측 이동
                start++;
            }
        }
        
        return answer;
    }
}