import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum + arrayList.get(i) < 0) {
                ans = Math.max(ans, arrayList.get(i));
                sum = 0;
            } else {
                sum += arrayList.get(i);
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}
