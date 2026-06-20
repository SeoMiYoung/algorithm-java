import java.util.*;
import java.io.*;

// 음 결국에, 그냥 각 단어 앞에만 대문자로 바꾸라는 거 아닌가?
// 나머지는 소문자고?
// s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.

class Solution {
    public String solution(String s) {
        String lowerS = s.toLowerCase(); // 모두 소문자화
        String[] wordArr = lowerS.split(" ", -1); // ["3people", "unfollowed", "me"], -1로 뒤에 공백 보존 --> 즉, 마지막이 ""가 될수도 있음! 
        
        for (int idx=0; idx<wordArr.length; idx++) { // "3people", "unfollowed", "me" 이렇게 한 단어씩 getWord로 들어옴
            if (!wordArr[idx].isEmpty()) { // 만약에 ""이라면, charAt에서 에러날 수 있음 
                // 가장 맨 앞글자만 대문자로 바꿔야함
                wordArr[idx] = Character.toUpperCase(wordArr[idx].charAt(0)) + wordArr[idx].substring(1);
            }
        }
        
        String answer = String.join(" ", wordArr);
        return answer;
    }
}