import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] blocks = new int[n][];
        
        for (int i = 0; i < n; i++) {
            String[] inputBlocks = br.readLine().split(" ");
            blocks[i] = new int[inputBlocks.length + 1];
            blocks[i][0] = 0;
            for (int j = 1; j <= inputBlocks.length; j++) {
                blocks[i][j] = Integer.parseInt(inputBlocks[j - 1]);
            }
        }

        dp(blocks, n, m, h);
    }
    
    public static void dp(int[][] blocks, int n, int m, int h) {
        final int MOD_VALUE = 10_007;

        int[][] mem = new int[n][h + 1];
        
        // 초기화
        mem[0][0] = 1;
        for (int block : blocks[0]) {
            if (block <= h) {
                mem[0][block] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= h; j++) {
                if (mem[i - 1][j] != 0) {
                    for (int block : blocks[i]) {
                        int next = j + block;

                        if (next >= 0 && next <= h) {
                            mem[i][next] = (mem[i][next] + mem[i - 1][j]) % MOD_VALUE;
                        }
                    }
                }
            }
        }
        
        System.out.println(mem[n - 1][h]);
    }
}