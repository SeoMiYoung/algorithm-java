/*
개선 point 1.
'start <= end' ---> 'start <= n'

핵심은 "end는 위로 한계가 없다"는 점
- end는 이론상 계속 늘어날 수 있다. end가 늘어나는 로직을 넣으면, end 자체에는 자연스러운 상한이 없음
- 반면, start는 "n을 넘는 순간 더 볼 필요 없다"는 명확한 상한(n)이 있음
--> 그래서 end를 기준으로 종료 조건을 잡으면 위험함

"아 그니깐 이건가, 음 end쪽도 점점 늘어가게 되는 경우는 end먼저 늘어나면 끝도 없으니깐, 사실 start <= n로 하는게 좀 더 정석적이다?"
*/

/*
개선 point 2.
매번 sum을 다시 구하고 있었음
투포인터의 원래 핵심은 "누적값 재활용"이에요!
- end를 늘릴 때: sum += end (새로 추가되는 값만 더하기)
- start를 늘릴 때: sum -= start (빠지는 값만 빼기)
- 매번 처음부터 계산 안 하고, 이전 결과를 그대로 재활용
*/


import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {  // 15
        int answer = 0;
        
        int start = 1;
        int end = 1; 
        int getSum = 1; // 우선 당연히 처음은 1에서 시작!
        
        while (start <= n) {
            if (getSum == n) {
                answer++;
                end++;
                getSum = getSum + end; // 기존 sum에 새 값만 더함
            }
            else if (getSum < n) {
                //  목표보다 작으면, 당연히 우측을 더 포함해야해.
                end++;
                getSum = getSum + end;
            }
            else {
                // 목표보다 크면, 줄여야 하니깐 좌측 이동
                getSum = getSum - start; // 기존 sum에서 빠지는 값만 뺌
                start++;
            }
        }
        return answer;
    }
}