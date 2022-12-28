package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n42_교육과정설계 {
    public static String solution(String str1, String str2) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : str1.toCharArray())
            queue.add(c);
        for(char c : str2.toCharArray()) {
            if(queue.peek() == c) {
                queue.remove();
                if(queue.size() == 0)
                    return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
