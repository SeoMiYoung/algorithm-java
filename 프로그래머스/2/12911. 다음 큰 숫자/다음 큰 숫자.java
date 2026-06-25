import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        // 1. n의 다음 큰 숫자는 n보다 큰 자연수입니다.
        // 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 대 1의 갯수가 같습니다.
        // 3. n의 다음 큰 숫자는 조건 1,2를 만족하는 수 중 가장 작은 수 입니다.
        
        int answer = 0;
        int nBinary = Integer.bitCount(n); // n의 1의 갯수
        
        
        while (true) {
            int nextNBinary = Integer.bitCount(n+1); // 다음 큰 수의 1의 개수 확인
            
            if (nBinary == nextNBinary) {
                answer = n+1;
                break;
            }
            n++;
        }
        
        return answer;
    }
}