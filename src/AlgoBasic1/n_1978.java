package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int[] rlt = new int[arr[N - 1] + 1];
        primeNum(arr[N - 1], rlt);

        for(int i=0; i<N; i++) {
            if(rlt[arr[i]] == 1)
                cnt++;
        }
        System.out.println(cnt);
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
