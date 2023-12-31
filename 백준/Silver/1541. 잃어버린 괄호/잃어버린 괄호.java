import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] split = str.split("-");
        int ans = calc(split[0]);

        for (int i = 1; i < split.length; i++) {
            ans -= calc(split[i]);
        }

        System.out.println(ans);
    }

    public static int calc(String str) {
        String[] split = str.split("[+]");

        int sum = 0;

        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}