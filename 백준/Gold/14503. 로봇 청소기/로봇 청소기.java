import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 0 => 북
    // 1 => 동
    // 2 => 남
    // 3 => 서
    static int[] dn = {-1, 0, 1, 0};
    static int[] dm = {0, 1, 0, -1};
    static int[][] arr;
    static int r;
    static int c;
    static int d;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // cur setting
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // (d == 0) => 북
        // (d == 1) => 동
        // (d == 2) => 남
        // (d == 3) => 서
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        // 0 => 청소 X
        // 1 => 청소 O
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (arr[r][c] == 0) {
                arr[r][c] = 1;
                arr[r][c] = -1;
                ans++;
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
            if (isAllCleanRoom()) {
                if (!calcRule2Move()) {
                    break;
                }
            }
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                // 반시계 방향으로 90도 회전
                turnCounterclockwise();

                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                checkFrontRoomIsNotCleanAndMove();
            }
        }

        System.out.println(ans);
    }

    public static boolean isAllCleanRoom() {
        for (int i = 0; i < 4; i++) {
            if (movable(r + dn[i], c + dm[i])) {
                if (arr[r + dn[i]][c + dm[i]] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean calcRule2Move() {
        if (d == 0) { // 남쪽으로 이동
            r += dn[2];
            c += dm[2];
        } else if (d == 1) { // 서쪽으로 이동
            r += dn[3];
            c += dm[3];
        } else if (d == 2) { // 북쪽으로 이동
            r += dn[0];
            c += dm[0];
        } else { // 동쪽으로 이동
            r += dn[1];
            c += dm[1];
        }
        return movable(r, c);
    }

    public static boolean movable(int r, int c) {
        return r < n && c < m && r >= 0 && c >= 0 && arr[r][c] != 1;
    }

    public static void turnCounterclockwise() {
        d = (d + 3) % 4;
    }

    public static void checkFrontRoomIsNotCleanAndMove() {
        if (movable(r + dn[d], c + dm[d])) {
            if (arr[r + dn[d]][c + dm[d]] == 0) {
                r += dn[d];
                c += dm[d];
            }
        }
    }
}