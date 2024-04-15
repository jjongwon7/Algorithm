import java.io.*;
import java.util.*;

class Solution {
    
    static int size;
    static String[] strs;
    static boolean[] visited;

    public String solution(int[] numbers) {
        // a, b
        size = numbers.length;
        strs = new String[size];
        visited = new boolean[size];

        // 숫자를 문자열로 저장
        for(int i=0; i<size; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1s2 = Integer.parseInt(s1 + s2);
                int s2s1 = Integer.parseInt(s2 + s1);

                return s2s1 - s1s2;
            }
        });

        String answer = "";

        for(int i=0; i<size; i++) {
            answer += strs[i];
        }

        while (answer.length() > 1) {
            if (Character.getNumericValue(answer.charAt(0)) == 0) {
                answer = answer.substring(1, answer.length());
            } else {
                break;
            }
        }

        return answer;
    }
}