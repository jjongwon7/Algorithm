package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1261 {
    static int n, m;
    static int[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i + 1][j + 1] = Character.getNumericValue(str.charAt(j));
                System.out.println("maze[i+1][j+1] = " + maze[i + 1][j + 1]);
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }
}
