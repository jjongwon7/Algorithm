package Inflearn.introduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n34_모든아나그램찾기 {
    public static int solution(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int lt = 0;
        int ans = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            map2.put(str1.charAt(i), map2.getOrDefault(str1.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) {
            ans++;
        }
        for (int rt = str2.length(); rt < str1.length(); rt++) {
            map2.put(str1.charAt(lt), map2.get(str1.charAt(lt)) - 1);
            if (map2.get(str1.charAt(lt)) == 0) {
                map2.remove(str1.charAt(lt));
            }
            lt++;
            map2.put(str1.charAt(rt), map2.getOrDefault(str1.charAt(rt), 0) + 1);
            if (map1.equals(map2)) {
                ans++;
            }
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
