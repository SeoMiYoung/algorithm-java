import java.util.*;
import java.io.*;


class Solution {
    public int solution(int n) {  // 15
        // ⭐ n의 약수를 다 찾아서, 그 중 홀수인 것만 세면 끝임 ⭐
        // 약수는, 1과 자기 자신(n)도 포함해서, 나눠지는 수
        
        int answer = 0;
        
        for (int i=1; i<=n; i++) {
            if ((n%i==0) && (i%2!=0)) {
                answer++;
            }
        }
        
        return answer;
    }
}