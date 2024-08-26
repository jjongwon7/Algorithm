import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Integer> numberMap = new HashMap<>();
    static int[] visitedCol;
    static int[][] board;
    static int minAnswer = Integer.MAX_VALUE;
    static int maxAnswer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        visitedCol = new int[n + 1];
        initMap();

        for (int row = 1; row <= n; row++) {
            String str = br.readLine();
            int col = 1;
            for (char c : str.toCharArray()) {
                board[row][col++] = numberMap.get(c);
            }
        }

        for (int col = 1; col <= n; col++) {
            visitedCol = new int[n + 1];
            visitedCol[col] = 1;
            dfs(2, n);
        }

        System.out.println(minAnswer);
        System.out.println(maxAnswer);
    }

    public static void initMap() {
        for (int i = 0; i < 19; i++) {
            if (i > 9) {
                numberMap.put((char) ('A' + (i - 10)), 9 - i);
            } else {
                numberMap.put((char) (i + '0'), i);
            }
        }
    }

    public static void dfs(int row, int n) {
        if (row == n + 1) {
            int sum = 1;

            for (int i = 1; i <= n; i++) {
                sum *= board[visitedCol[i]][i];
            }

            int[] cycle = new int[n + 1];
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (cycle[i] == 0) {
                    calcCycle(cycle, i, i);
                    cnt++;
                }
            }

            // 짝수
            if (cnt % 2 == 0) {
                sum *= -1;
            }

            minAnswer = Math.min(minAnswer, sum);
            maxAnswer = Math.max(maxAnswer, sum);

            return;
        }

        for (int nc = 1; nc <= n; nc++) {
            if (visitedCol[nc] == 0) {
                visitedCol[nc] = row;
                dfs(row + 1, n);
                visitedCol[nc] = 0;
            }
        }
    }

    public static void calcCycle(int[] cycle, int prev, int group) {
        int cur = visitedCol[prev];

        if (cycle[prev] != 0) {
            return;
        }

        cycle[prev] = group;
        calcCycle(cycle, cur, group);
    }
}