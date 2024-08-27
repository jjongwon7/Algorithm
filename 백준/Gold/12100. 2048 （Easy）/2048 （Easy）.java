import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int maxBlock = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(maxBlock);
    }

    public static void dfs(int playCnt, int[][] boardToMove) {
        if (playCnt == 5) {
            // calcMax
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maxBlock = Math.max(maxBlock, boardToMove[i][j]);
                }
            }

            return ;
        }

        // 상하좌우 모두 탐색 대상
        for (Direction direction : Direction.values()) {
            dfs(playCnt + 1, move(boardToMove, direction));
        }
    }

    public static int[][] move(int[][] boardToMove, Direction direction) {
        int[][] movedBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            int merged = 0;
            int mergedCnt = 0;
            int fixedCnt = 0;

            for (int j = 0; j < n; j++) {
                int x = 0;
                int y = 0;

                switch (direction) {
                    case LEFT:
                        x = i;
                        y = j;
                        break;
                    case RIGHT:
                        x = i;
                        y = n - 1 - j;
                        break;
                    case UP:
                        x = j;
                        y = i;
                        break;
                    case DOWN:
                        x = n - 1 - j;
                        y = i;
                }

                if (merged == 0 && boardToMove[x][y] != 0) {
                    merged = boardToMove[x][y];
                } else if (merged != 0 && boardToMove[x][y] != 0) {
                    if (merged == boardToMove[x][y]) {
                        switch (direction) {
                            case LEFT:
                                movedBoard[x][mergedCnt + fixedCnt] = merged * 2;
                                break;
                            case RIGHT:
                                movedBoard[x][n - 1 - (mergedCnt + fixedCnt)] = merged * 2;
                                break;
                            case UP:
                                movedBoard[mergedCnt + fixedCnt][y] = merged * 2;
                                break;
                            case DOWN:
                                movedBoard[n - 1 - (mergedCnt + fixedCnt)][y] = merged * 2;
                        }

                        mergedCnt++;
                        merged = 0;
                    }

                    else {
                        switch (direction) {
                            case LEFT:
                                movedBoard[x][mergedCnt + fixedCnt] = merged;
                                break;
                            case RIGHT:
                                movedBoard[x][n - 1 - (mergedCnt + fixedCnt)] = merged;
                                break;
                            case UP:
                                movedBoard[mergedCnt + fixedCnt][y] = merged;
                                break;
                            case DOWN:
                                movedBoard[n - 1 - (mergedCnt + fixedCnt)][y] = merged;
                        }

                        fixedCnt++;
                        merged = boardToMove[x][y];
                    }
                }
            }

            if (merged != 0) {
                switch (direction) {
                    case LEFT:
                        movedBoard[i][mergedCnt + fixedCnt] = merged;
                        break;
                    case RIGHT:
                        movedBoard[i][n - 1 - (mergedCnt + fixedCnt)] = merged;
                        break;
                    case UP:
                        movedBoard[mergedCnt + fixedCnt][i] = merged;
                        break;
                    case DOWN:
                        movedBoard[n - 1 - (mergedCnt + fixedCnt)][i] = merged;
                }
            }
        }

        return movedBoard;
    }

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}