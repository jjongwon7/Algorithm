import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (queue.size() != 1) {
            Integer card1 = queue.poll();
            Integer card2 = queue.poll();
            int cnt = card1 + card2;
            sum += cnt;
            queue.add(cnt);
        }

        System.out.println(sum);
    }
}