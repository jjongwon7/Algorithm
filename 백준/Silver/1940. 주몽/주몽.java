import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] material = new int[n];
        boolean[] usedMaterial = new boolean[100001];
        int left = 0;
        int right = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            material[i] = sc.nextInt();
        }

        while (left < n - 1) {
            if (usedMaterial[material[left]]) {
                left++;
                right = left + 1;
            } else if (material[left] + material[right] == m) {
                usedMaterial[material[left]] = true;
                usedMaterial[material[right]] = true;
                ans++;
                left++;
                right = left + 1;
            } else {
                if (right < n - 1) {
                    right++;
                } else {
                    left++;
                    right = left + 1;
                }
            }
        }

        System.out.println(ans);
    }
}
