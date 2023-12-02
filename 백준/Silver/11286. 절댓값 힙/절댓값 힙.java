import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int aAbs = Math.abs(a);
            int bAbs = Math.abs(b);

            if (aAbs == bAbs) {
                return a > b ? 1 : -1;
            } else {
                return aAbs - bAbs;
            }
        });

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (cur == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(cur);
            }
        }

        System.out.println(sb);
    }
}