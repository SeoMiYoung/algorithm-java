class Solution {
    public int solution(int n) {
        int answer;
        int n_count_one = Integer.bitCount(n);  // n을 2진수로 변환 시, 1의 개수
        
        while (true) {
            int next_count_one = Integer.bitCount(n+1);  // n+1을 2진수로 변환 시, 1의 개수
            
            if (n_count_one == next_count_one) {
                answer = n + 1; 
                break;
            }
            
            n++;
        }    
        
        return answer;
    }
}