package Inflearn.introduction;

import java.util.HashMap;
import java.util.Scanner;

public class n31_학급회장_해쉬 {
    public static char solution(int n, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char ans=' ';
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : map.keySet()) {
            if(max < map.get(c)) {
                max = map.get(c);
                ans = c;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }
}
