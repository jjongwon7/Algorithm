package Inflearn.introduction;

import java.util.Scanner;
import java.util.Stack;

public class n38_크레인인형뽑기 {
    public static int solution(int n, int[][] board, int m, int[] moves) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            // 위에서부터 인형이 존재하는지 순회
            for (int i = 1; i <= n; i++) {
                // 존재하는 경우
                if(board[i][move] != 0) {
                    // 바구니에 같은 모양의 인형이 연속으로 쌓인 경우
                    if (!stack.isEmpty() && (stack.peek() == board[i][move])) {
                        ans++;
                        stack.pop();
                    }
                    // 그렇지 않은 경우 바구니에 push
                    else {
                        stack.push(board[i][move]);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }
        return ans*2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
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
