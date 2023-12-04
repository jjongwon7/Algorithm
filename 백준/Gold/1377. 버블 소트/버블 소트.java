import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        ArrayInfo[] arrayInfos = new ArrayInfo[N];

        for (int i = 0; i < N; i++) {
            arrayInfos[i] = new ArrayInfo(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arrayInfos);

        for (int i = 0; i < N; i++) {
            // pre - post
            if ((arrayInfos[i].index - i) > max) {
                max = arrayInfos[i].index - i;
            }
        }

        System.out.println(max + 1);
    }

    static class ArrayInfo implements Comparable<ArrayInfo> {
        int value;
        int index;

        public ArrayInfo(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayInfo o) {
            return this.value - o.value;
        }
    }
}