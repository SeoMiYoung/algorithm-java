/*
[50, 70, 80]
- 알고리즘 흐름
   - left=0 (가장 가벼운 사람)
   - right=n-1 (가장 무거운 사람)
   - while (left <= right)
      - 둘이 합이 limit 이하 -> 같이 태움 (left++, right--)
      - 초과 -> 무거운 사람 혼자 태움 (right--)
   - 보트 개수++
*/   

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 먼저 정렬
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people)); -- 	[50, 50, 70, 80]
        
        int left = 0;
        int right = people.length - 1; 
        int boat = 0;
        
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                // 몸무게 더 나가는 사람 한명 먼저 보낸다. 
                boat++;
                right--;
            }
            else {
                // 가능이다
                boat++;
                left++;
                right--;
            }
        }
        
        return boat;
    }
}