import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // A 배열은 오름차순 정렬
        // B 배열은 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
            answer += (A[i] * B[A.length-i-1]);
        }

        return answer;
    }
}