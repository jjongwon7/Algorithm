import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] num = new long[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            int left=0;
            int right = n - 1;
            while (left < right) {
                if (num[left] + num[right] > num[i]) {
                    right--;
                } else if (num[left] + num[right] < num[i]) {
                    left++;
                } else {
                    if (left != i && right != i) {
                        ans++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}