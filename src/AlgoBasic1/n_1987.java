//package AlgoBasic1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class n_1987 {
//    static char[][] board;
//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, 1, 0, -1};
//    static int[] ch;
//    static int max;
//    public static void DFS(int x, int y, int r, int c, int cnt) {
//        max = Math.max(max, cnt);
//        ch[board[x][y]-'A'] = 1;
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx >= 1 && nx <= r && ny >= 1 && ny <= c && ch[board[nx][ny] - 'A'] == 0) {
//                DFS(nx, ny, r, c, cnt + 1);
//                ch[board[nx][ny]-'A'] = 0;
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bufferedReader.readLine());
//        for (int test = 1; test <= n; test++) {
//            max = Integer.MIN_VALUE;
//            ch = new int[26];
//            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            int r = Integer.parseInt(stringTokenizer.nextToken());
//            int c = Integer.parseInt(stringTokenizer.nextToken());
//            board = new char[r + 1][c + 1];
//            for (int i = 1; i <= r; i++) {
//                String str = bufferedReader.readLine();
//                for (int j = 1; j <= c; j++) {
//                    board[i][j] = str.charAt(j-1);
//                }
//            }
//            DFS(1, 1, r, c, 1);
//            System.out.println("#" + test + " " + max);
//        }
//
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int R, C;
    static int[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int ans = 0;

    public static void dfs(int x, int y, int count) {
        if (visit[map[x][y]]) { // 이미 visited 한 곳이라면
            ans = Math.max(ans, count); // ans 값을 update한다.
            return;
        } else {
            visit[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                    dfs(cx, cy, count + 1);
                }
            }
            visit[map[x][y]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case=1; test_case<=T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (R >=1 && C <= 20)
            {
                map = new int[R][C];
                for (int i = 0; i < R; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < C; j++) {
                        map[i][j] = str.charAt(j) - 'A';
                    }
                }

                dfs(0, 0, 0);
                //출력 양식에 맞게 출력
                System.out.println("#"+test_case+" "+ans);
            }
        }
    }
}