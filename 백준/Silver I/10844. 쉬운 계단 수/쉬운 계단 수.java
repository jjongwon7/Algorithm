import java.util.Scanner;

public class Main {

    static long[][] arr = new long[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp();
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + arr[n][i]) % 1_000_000_000;
        }

        System.out.println(sum);
    }

    public static void dp() {
        arr[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    arr[i][0] = arr[i - 1][1] % 1_000_000_000;
                } else if (j == 9) {
                    arr[i][9] = arr[i - 1][8] % 1_000_000_000;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1_000_000_000;
                }
            }
        }
    }
}