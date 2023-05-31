package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_3085 {
    static int n, ans = 0;
    static char[][] arr;

    public static void swap(int a, int b, int c, int d) {
        char tmp;
        tmp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = tmp;
    }

    public static void checkRow(int row) {
        int sum = 1;
        for (int column = 0; column < n - 1; column++) {
            if (arr[row][column] == arr[row][column + 1]) {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 1;
            }
        }
        ans = Math.max(ans, sum);
    }

    public static void checkColumn(int column) {
        int sum = 1;
        for (int row = 0; row < n - 1; row++) {
            if (arr[row][column] == arr[row + 1][column]) {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 1;
            }
        }
        ans = Math.max(ans, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j <str.length() ; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        // 초기 최대값 찾기
        for (int i = 0; i < n; i++) {
            checkRow(i);
            checkColumn(i);
        }


        // 열 교환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    checkRow(i);
                    checkColumn(j);
                    checkColumn(j + 1);
                    swap(i, j, i, j + 1);
                }
            }
        }
        // 행 교환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] != arr[j + 1][i]) {
                    swap(j, i, j + 1, i);
                    checkRow(j);
                    checkRow(j + 1);
                    checkColumn(i);
                    swap(j, i, j + 1, i);
                }
            }
        }
        System.out.println(ans);
    }
}