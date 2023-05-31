package AlgoBasic2;

import java.util.Scanner;

public class n_1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[3];
        int ans = 0;
        while (true) {
            ans++;
            for (int i = 0; i < 3; i++) {
                arr[i]++;
            }
            if (arr[0] == 16) {
                arr[0] = 1;
            }
            if (arr[1] == 29) {
                arr[1] = 1;
            }
            if (arr[2] == 20) {
                arr[2] = 1;
            }
            if (arr[0] == e && arr[1] == s && arr[2] == m) {
                break;
            }
        }
        System.out.println(ans);
    }
}
