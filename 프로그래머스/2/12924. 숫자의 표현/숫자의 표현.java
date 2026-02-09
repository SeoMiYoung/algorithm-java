// 이거 그거잖아! 투 포인터!
// 두 포인터의 간격을 유동적으로 조절하면서 풀어야 함

// 1 2 3 4 5
class Solution {
    public int solution(int n) {
        int result = 0;
        
        // start <= x < end   (start:3, end:5 -> 3,4)
        int start = 1; 
        int end = 1;
        
        while (start <= n) {
            // 일단 출력해봄
            // System.out.print(String.format("%d <= x < %d", start, end));
            
            // 1. start부터 end-1까지 더해본다.  (3부터 4까지)
            // 1-1. 1 <= x <= end-1 (1부터 4까지)  
            int sum1 = ((end-1)*(end))/2;
            // 1-2. 1 <= x <= start-1 (1부터 2까지)
            int sum2 = ((start-1)*(start))/2;
            // 계산
            int getSum = sum1 - sum2;
            
            if (getSum == n) { // 목표치
                end++;
                result++;
            }
            else if (getSum < n) {
                end++;
            }
            else if (getSum > n) {
                start++;
            }
        }
        
      
        return result;
    }
}

