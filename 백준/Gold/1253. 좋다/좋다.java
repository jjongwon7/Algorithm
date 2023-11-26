import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        for (int targetIndex = 0; targetIndex < n; targetIndex++) {
            int left = 0;
            int right = n - 1;
            int target = num[targetIndex];
            while (left < right) {
                if (num[left] + num[right] > target) {
                    right--;
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    if (left != targetIndex && right != targetIndex) {
                        ans++;
                        break;
                    } else if (left == targetIndex) {
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