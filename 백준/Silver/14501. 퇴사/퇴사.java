import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] maxPriceArr;
    static int[] timeArr;
    static int[] priceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        maxPriceArr = new int[n + 2];
        timeArr = new int[n + 1];
        priceArr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            timeArr[i] = Integer.parseInt(st.nextToken());
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            if (i + timeArr[i] - 1 > n) {
                maxPriceArr[i] = maxPriceArr[i + 1];
            } else {
                maxPriceArr[i] = Math.max(priceArr[i] + maxPriceArr[i + timeArr[i]], maxPriceArr[i + 1]);
            }
        }

        System.out.println(maxPriceArr[1]);

    }
}