package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class n38_크레인인형뽑기 {
    public static int solution(int n, int[][] board, int m, int[] moves) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[j][moves[i]-1] != 0) {
                    if(!stack.isEmpty()) {
                        if (stack.peek() == board[j][moves[i] - 1]) {
                            ans++;
                            stack.pop();
                        } else {
                            stack.push(board[j][moves[i] - 1]);
                        }
                    }
                    else {
                        stack.push(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return ans*2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++)
            moves[i] = sc.nextInt();
        System.out.println(solution(n, board, m , moves));
    }
}
