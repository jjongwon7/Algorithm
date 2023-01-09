package Inflearn;

import java.util.Scanner;

public class n89_돌다리건너기 {
    static int[] dy;
    public static int solution(int[] dy) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i < dy.length; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[dy.length-1] + dy[dy.length-2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.println(solution(dy));
    }
}
