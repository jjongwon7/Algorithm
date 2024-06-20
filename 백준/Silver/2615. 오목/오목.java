import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 1};
    static int[] dc = {1, 1, 1, 0};
    static int[] reverseDr = {1, 0, -1, -1};
    static int[] reverseDc = {-1, -1, -1, 0};
    static int[][] concaveMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        concaveMap = new int[20][20];

        // 값 입력 (검정: 1, 흰색: 2, 빈칸: 0)
        for (int r = 1; r < 20; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c < 20; c++) {
                concaveMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 1; c < 20; c++) {
            for (int r = 1; r < 20; r++) {
                if(concaveMap[r][c] != 0) {
                    for (int i = 0; i < 4; i++) {
                        int nextR = r + dr[i];
                        int nextC = c + dc[i];

                        if(nextR >=1 && nextR < 20 && nextC >=1 && nextC < 20 && concaveMap[nextR][nextC] == concaveMap[r][c]) {
                            if (dfs(2, nextR, nextC, i, concaveMap[r][c]) == 5) {
                                int reverseNextR = r + reverseDr[i];
                                int reverseNextC = c + reverseDc[i];

                                // 6목 이상이므로 정답 X
                                if(reverseNextR >=1 && reverseNextR < 20 && reverseNextC >=1 && reverseNextC < 20 && concaveMap[reverseNextR][reverseNextC] == concaveMap[r][c]) {
                                    continue;
                                }

                                // 정답인 경우
                                System.out.println(concaveMap[r][c]);
                                System.out.println(r + " " + c);
                                return ;
                            }
                        }
                    }
                }
            }
        }

        // 승부가 결정되지 않은 경우
        System.out.println(0);
    }

    public static int dfs(int depth, int r, int c, int directionIdx, int color) {
        int nextR = r + dr[directionIdx];
        int nextC = c + dc[directionIdx];

        if(nextR >=1 && nextR < 20 && nextC >=1 && nextC < 20 && concaveMap[nextR][nextC] == color) {
            return dfs(depth + 1, nextR, nextC, directionIdx, concaveMap[r][c]);
        }

        return depth;
    }
}