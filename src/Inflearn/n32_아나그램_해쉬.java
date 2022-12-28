package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class n32_아나그램_해쉬 {
    public static String solution(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if(map1.size() != map2.size())
            return "NO";
        else {
            for (char c : map1.keySet()) {
                if (map2.containsKey(c)) {
                    if (map1.get(c) != map2.get(c))
                        return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
