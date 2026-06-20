import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // A 오름차순 (원본이 바뀜) -----------
        Arrays.sort(A); // [1, 2, 4]
        
        // B 내림차순 (원본이 바뀜) -----------
        // 먼저 오름차순
        Arrays.sort(B); 
        // 뒤집기
        for (int idx=0; idx<B.length/2; idx++) {
            int temp = B[idx];
            B[idx] = B[B.length-idx-1];
            B[B.length-idx-1] = temp;
        }
        
        // 곱의 합 만들기
        int answer = 0;
        for (int idx=0; idx<A.length; idx++) {
            answer += A[idx]*B[idx];
        }


        return answer;
    }
}