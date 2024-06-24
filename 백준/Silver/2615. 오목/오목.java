import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[20][20];
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (arr[i][j] != 0) {
                    if (checkWin(i, j)) {
                        System.out.println(arr[i][j]);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean checkWin(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int count = 1;
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (isInBounds(nx, ny) && arr[x][y] == arr[nx][ny]) {
                count++;
                nx += dx[i];
                ny += dy[i];
            }

            nx = x - dx[i];
            ny = y - dy[i];

            while (isInBounds(nx, ny) && arr[x][y] == arr[nx][ny]) {
                count++;
                nx -= dx[i];
                ny -= dy[i];
            }

            if (count == 5) {
                // 5일때 반대 방향에 동일한 바둑알 있으면 6개이므로 continue
                if (isInBounds(x - dx[i], y - dy[i]) && arr[x - dx[i]][y - dy[i]] == arr[x][y]) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    static boolean isInBounds(int x, int y) {
        return x >= 1 && x <= 19 && y >= 1 && y <= 19;
    }
}