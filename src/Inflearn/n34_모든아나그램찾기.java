package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class n34_모든아나그램찾기 {
    public static int solution(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int lt = 0;
        int ans = 0;
        boolean flag = true;
        for(char c : str2.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for(int i=0; i<str2.length(); i++) {
            if(map.containsKey(str1.charAt(i)))
                map.put(str1.charAt(i), map.get(str1.charAt(i)) - 1);
        }
        for(char c : map.keySet()) {
            if(map.get(c) != 0) {
                flag = false;
                break;
            }
        }
        if(flag)
            ans++;
        for(int rt=str2.length(); rt<str1.length(); rt++) {
            flag = true;
            if(map.containsKey(str1.charAt(lt)))
                map.put(str1.charAt(lt), map.get(str1.charAt(lt)) + 1);
            lt++;
            if(map.containsKey(str1.charAt(rt)))
                map.put(str1.charAt(rt), map.get(str1.charAt(rt)) - 1);
            for(char c : map.keySet()) {
                if(map.get(c) != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
