package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class n_6588 {
    static int[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int tmp = Integer.parseInt(br.readLine());
        while (tmp != 0) {
            if (max < tmp) {
                max = tmp;
            }
            arrayList.add(tmp);
            tmp = Integer.parseInt(br.readLine());
        }
        prime = new int[max];
        primeNum(max);
        // 입력 케이스만큼 반복하면서
        for (int a : arrayList) {
            boolean flag = false;
            // 입력값에 가장 가까운 소수부터 탐색
            for (int i = 3; i <= a / 2; i++) {
                if (prime[i] == 0 && prime[a - i] == 0) {
                    sb.append(a).append(" = ").append(i).append(" + ").append(a - i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (flag == false)
                sb.append("Goldbach's conjecture is wrong.");
        }
        System.out.println(sb);
    }
    static void primeNum(int max) {
        for (int i = 2; i < max; i++) {
            if (prime[i] == 0) {
                for (int j = i + i; j < max; j = j + i) {
                    prime[j] = 1;
                }
            }
        }
    }
}