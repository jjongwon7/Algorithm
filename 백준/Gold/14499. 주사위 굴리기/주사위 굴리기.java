import java.util.*;
import java.io.*;

public class Main {

    // 1: 동쪽, 2: 서쪽, 3: 북쪽, 4: 남쪽
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[6];
    static int[] diceIdx = {0, 1, 2, 3, 4, 5};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        // 1: 동쪽, 2: 서쪽, 3: 북쪽, 4: 남쪽
        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(st.nextToken());
            int nextX = curX + dx[direction - 1];
            int nextY = curY + dy[direction - 1];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                moveDice(direction);
                if (map[nextX][nextY] == 0) {
                    map[nextX][nextY] = dice[diceIdx[5]];
                } else {
                    dice[diceIdx[5]] = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                }

                curX = nextX;
                curY = nextY;

                sb.append(dice[diceIdx[0]]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void moveDice(int direction) {
        int[] tmp = Arrays.copyOf(diceIdx, diceIdx.length);
        if (direction == 1) { // 동
            diceIdx[0] = tmp[2];
            diceIdx[2] = tmp[5];
            diceIdx[3] = tmp[0];
            diceIdx[5] = tmp[3];
        } else if (direction == 2) { // 서
            diceIdx[0] = tmp[3];
            diceIdx[2] = tmp[0];
            diceIdx[3] = tmp[5];
            diceIdx[5] = tmp[2];
        } else if (direction == 3) { // 북
            diceIdx[0] = tmp[1];
            diceIdx[1] = tmp[5];
            diceIdx[4] = tmp[0];
            diceIdx[5] = tmp[4];
        } else { // 남
            diceIdx[0] = tmp[4];
            diceIdx[1] = tmp[0];
            diceIdx[4] = tmp[5];
            diceIdx[5] = tmp[1];
        }
    }
}