import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[w];

        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = w - 1;
        int leftMaxHeight = blocks[left];
        int rightMaxHeight = blocks[right];
        int ans = 0;

        while (left < right) {
            if (leftMaxHeight < rightMaxHeight) {
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, blocks[left]);
                ans += leftMaxHeight - blocks[left];
            } else {
                right--;
                rightMaxHeight = Math.max(rightMaxHeight, blocks[right]);
                ans += rightMaxHeight - blocks[right];
            }
        }

        System.out.println(ans);
    }
}