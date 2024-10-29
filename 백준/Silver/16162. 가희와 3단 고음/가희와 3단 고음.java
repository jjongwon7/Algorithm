import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 음의 개수
        int a = Integer.parseInt(st.nextToken()); // 첫 항
        int d = Integer.parseInt(st.nextToken()); // 공차

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int preValue = a - d;

        for (int i = 0; i < n; i++) {
            int curValue = Integer.parseInt(st.nextToken());

            if (preValue + d == curValue) {
                cnt++;
                preValue = curValue;
            }
        }

        System.out.println(cnt);
    }
}