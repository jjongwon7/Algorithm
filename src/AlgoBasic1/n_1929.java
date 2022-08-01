package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] rlt = new int[N+1];
        primeNum(N, rlt);
        for(int i=M; i<=N; i++) {
            if (rlt[i] == 1)
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
    // 해당 인덱스의 값이 1이라면 소수인 배열 만들기
    static void primeNum(int max, int[] rlt) {
        for (int i = 1; i <= max; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if ((i % j) == 0)
                    cnt++;
            }
            if (cnt == 2)
                rlt[i] = 1;
        }
    }
}
