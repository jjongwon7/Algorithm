import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = gcd(a, b);

        System.out.println("1".repeat((int)gcd));

    }

    public static long gcd(long a, long b) {
        long rlt = a % b;

        if (rlt == 0) {
            return b;
        } else {
            return gcd(b, rlt);
        }
    }
}