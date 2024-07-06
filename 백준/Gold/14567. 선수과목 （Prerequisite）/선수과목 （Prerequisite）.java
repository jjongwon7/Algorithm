import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 과목의 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건의 수
        Major[] majors = new Major[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            majors[i] = new Major(pre, post);
        }

        Arrays.sort(majors);
        dp(n, m, majors);
    }

    public static void dp(int n, int m, Major[] majors) {
        int[] mem = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            mem[i] = 1;
        }

        for (Major major : majors) {
            mem[major.post] = Math.max(mem[major.pre] + 1, mem[major.post]);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(mem[i] + " ");
        }
    }

    public static class Major implements Comparable<Major> {
        int pre;
        int post;

        public Major(int pre, int post) {
            this.pre = pre;
            this.post = post;
        }

        @Override
        public int compareTo(Major m) {
            if (this.post == m.post) {
                return this.pre - m.pre;
            }

            return this.post - m.post;
        }
    }
}