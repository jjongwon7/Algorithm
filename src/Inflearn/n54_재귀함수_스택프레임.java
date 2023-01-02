package Inflearn;

import java.util.Scanner;

public class n54_재귀함수_스택프레임 {
    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DFS(3);
    }
}
