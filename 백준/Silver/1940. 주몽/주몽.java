import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] material = new int[n];
        int left = 0;
        int right = n - 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            material[i] = sc.nextInt();
        }

        Arrays.sort(material);

        while (left < right) {
            if (material[left] + material[right] > m) {
                right--;
            } else if (material[left] + material[right] == m) {
                ans++;
                left++;
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans);
    }
}