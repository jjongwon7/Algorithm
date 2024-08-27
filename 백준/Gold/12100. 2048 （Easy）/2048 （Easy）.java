import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Integer> numberMap = new HashMap<>();
    static int[][] board;
    static int n;
    static int maxBlock = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2^10 * 20 * 20 => 2^12 완탐 가능
        // return: 최대 5번 이동해서 만들 수 있는 가장 큰 블록
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

        dfs(playCnt + 1, moveLeft(boardToMove));
        dfs(playCnt + 1, moveRight(boardToMove));
        dfs(playCnt + 1, moveTop(boardToMove));
        dfs(playCnt + 1, moveDown(boardToMove));
    }

    public static int[][] moveLeft(int[][] boardToMove) {
        int[][] movedBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            int merged = 0;
            int mergedCnt = 0;
            int fixedCnt = 0;

            for (int j = 0; j < n; j++) {
                if (merged == 0 && boardToMove[i][j] != 0) {
                    merged = boardToMove[i][j];
                } else if (merged != 0 && boardToMove[i][j] != 0) {
                    // 숫자가 같은 경우 블록 합침
                    if (merged == boardToMove[i][j]) {
                        movedBoard[i][mergedCnt + fixedCnt] = merged * 2;
                        mergedCnt++;
                        merged = 0;
                    }
                    // 숫자가 다른 경우 이전 블록은 합쳐질 수 없음 (즉, 위치 고정)
                    else {
                        movedBoard[i][mergedCnt + fixedCnt] = merged;
                        fixedCnt++;
                        merged = boardToMove[i][j];
                    }
                }
            }

            if (merged != 0) {
                movedBoard[i][mergedCnt + fixedCnt] = merged;
            }
        }

        return movedBoard;
    }

    public static int[][] moveRight(int[][] boardToMove) {
        int[][] movedBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            int merged = 0;
            int mergedCnt = 0;
            int fixedCnt = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (merged == 0 && boardToMove[i][j] != 0) {
                    merged = boardToMove[i][j];
                } else if (merged != 0 && boardToMove[i][j] != 0) {
                    // 숫자가 같은 경우 블록 합침
                    if (merged == boardToMove[i][j]) {
                        movedBoard[i][n - 1 - (mergedCnt + fixedCnt)] = merged * 2;
                        mergedCnt++;
                        merged = 0;
                    }
                    // 숫자가 다른 경우 이전 블록은 합쳐질 수 없음 (즉, 위치 고정)
                    else {
                        movedBoard[i][n - 1 - (mergedCnt + fixedCnt)] = merged;
                        fixedCnt++;
                        merged = boardToMove[i][j];
                    }
                }
            }

            if (merged != 0) {
                movedBoard[i][n - 1 - (mergedCnt + fixedCnt)] = merged;
            }
        }

        return movedBoard;
    }

    public static int[][] moveTop(int[][] boardToMove) {
        int[][] movedBoard = new int[n][n];

        for (int j = 0; j < n; j++) {
            int merged = 0;
            int mergedCnt = 0;
            int fixedCnt = 0;

            for (int i = 0; i < n; i++) {
                if (merged == 0 && boardToMove[i][j] != 0) {
                    merged = boardToMove[i][j];
                } else if (merged != 0 && boardToMove[i][j] != 0) {
                    // 숫자가 같은 경우 블록 합침
                    if (merged == boardToMove[i][j]) {
                        movedBoard[mergedCnt + fixedCnt][j] = merged * 2;
                        mergedCnt++;
                        merged = 0;
                    }
                    // 숫자가 다른 경우 이전 블록은 합쳐질 수 없음 (즉, 위치 고정)
                    else {
                        movedBoard[mergedCnt + fixedCnt][j] = merged;
                        fixedCnt++;
                        merged = boardToMove[i][j];
                    }
                }
            }

            if (merged != 0) {
                movedBoard[mergedCnt + fixedCnt][j] = merged;
            }
        }

        return movedBoard;
    }

    public static int[][] moveDown(int[][] boardToMove) {
        int[][] movedBoard = new int[n][n];

        for (int j = 0; j < n; j++) {
            int merged = 0;
            int mergedCnt = 0;
            int fixedCnt = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (merged == 0 && boardToMove[i][j] != 0) {
                    merged = boardToMove[i][j];
                } else if (merged != 0 && boardToMove[i][j] != 0) {
                    // 숫자가 같은 경우 블록 합침
                    if (merged == boardToMove[i][j]) {
                        movedBoard[n - 1 - (mergedCnt + fixedCnt)][j] = merged * 2;
                        mergedCnt++;
                        merged = 0;
                    }
                    // 숫자가 다른 경우 이전 블록은 합쳐질 수 없음 (즉, 위치 고정)
                    else {
                        movedBoard[n - 1 - (mergedCnt + fixedCnt)][j] = merged;
                        fixedCnt++;
                        merged = boardToMove[i][j];
                    }
                }
            }

            if (merged != 0) {
                movedBoard[n - 1 - (mergedCnt + fixedCnt)][j] = merged;
            }
        }

        return movedBoard;
    }
}