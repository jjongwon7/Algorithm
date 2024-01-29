import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] prime = new boolean[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        calcPrime();

        for (int i=n; i < 10_000_000; i++) {
            if (prime[i]) {
                if (palindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void calcPrime() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static boolean palindrome(int i) {
        char[] chars = Integer.toString(i).toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}