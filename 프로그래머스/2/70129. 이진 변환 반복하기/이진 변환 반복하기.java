class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int countChange = 0;
        
        while(true) {
            if (s.equals("1")) {
                break;  // 목표 달성
            }    
            
            // 1. 이진 변환 시작
            // 1-1. x의 모든 0을 제거 --> 그냥 0과 1의 개수를 세면 됨.
            int countOne = 0;
            for (int i=0; i<s.length(); i++) { // 문자열은 length()
                if (s.charAt(i) == '0') { // char은 기본형 타입이라서, ==로 값 비교하는 게 정석임 
                    countZero++;
                }
                else {
                    countOne++;
                }
            }
            
            // 1-2. countOne을 이진수로 변환하면 됨
            s = Integer.toBinaryString(countOne); 
            
            // 변환 횟수 추가
            countChange++; 
            
        }
        
        int[] answer = new int[2];
        answer[0] = countChange;
        answer[1] = countZero;
        
        return answer;
    }
}