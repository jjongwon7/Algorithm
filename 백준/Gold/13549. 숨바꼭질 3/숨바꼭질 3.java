import java.io.*;
import java.util.*;

public class Main {

    static int[] walk = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈
        int k = Integer.parseInt(st.nextToken()); // 동생
        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        boolean[] visited = new boolean[100001];
        int moveCnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        while (n <= 100000) {
            visited[n] = true;
            queue.offer(n);
            n *= 2;

            if (n == 0) break;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();

                if (curPos == k) {
                    return moveCnt;
                }

                // 걷기
                for (int direction = 0; direction < 2; direction++) {
                    int nextPos = curPos + walk[direction];

                    if (nextPos <= 100000 && nextPos >= 0 && !visited[nextPos]) {
                        while (nextPos <= 100000) {
                            if (nextPos == k) {
                                return moveCnt + 1;
                            }

                            if (!visited[nextPos]) {
                                visited[nextPos] = true;
                                queue.offer(nextPos);
                            } else {
                                break;
                            }
                            nextPos *= 2;
                        }
                    }
                }
            }

            moveCnt++;
        }

        return 0;
    }
}