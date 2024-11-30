import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n, m, waitTomatoCount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
        n = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수

        arr = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    queue.add(new int[] {i, j}); // 익은 토마토 큐에 저장
                } else if (arr[i][j] == 0) {
                    waitTomatoCount++;
                }
            }
        }

        // 모든 토마토가 익어있는 상태이면 0을 출력
        if (waitTomatoCount == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(queue));
    }

    /**
     * 마지막 날 이휴에 한 번 더 day가 증가한 상태로 루프를 종료
     * 따라서, day - 1을 리턴함.
     */
    public static int bfs(Queue<int[]> queue) {
        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = point[0] + dx[j];
                    int ny = point[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        waitTomatoCount--;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }

            day++;
        }

        // 토마토가 모두 익지 못하는 상황이면 -1
        return waitTomatoCount == 0 ? day - 1 : -1;
    }
}