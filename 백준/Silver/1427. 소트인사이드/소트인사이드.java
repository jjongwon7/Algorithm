import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        char[] num = str.toCharArray();
        int max;
        int maxIdx;

        for (int i = 0; i < num.length; i++) {
            max = Integer.MIN_VALUE;
            maxIdx = i;

            for (int j = i; j < num.length; j++) {
                if (max < num[j]) {
                    max = num[j];
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                swap(num, maxIdx, i);
            }

            sb.append(num[i]);
        }

        System.out.println(sb);
    }

    public static void swap(char[] num, int maxIdx, int changeIdx) {
        char tmp = num[maxIdx];
        num[maxIdx] = num[changeIdx];
        num[changeIdx] = tmp;
    }
}