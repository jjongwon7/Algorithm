import java.io.*;

public class Main {

    static final int MAX_EXPONENT = 8;
    static final int MAX_ARRAY_SIZE = (int) Math.pow(3, 8);
    static boolean[][] isBlank = new boolean[MAX_ARRAY_SIZE][MAX_ARRAY_SIZE];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        readBlankPosition(1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char blankOrStar = isBlank[i][j] ? ' ' : '*';
                sb.append(blankOrStar);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void readBlankPosition(int exponent, int start) {
        if (exponent > MAX_EXPONENT) {
            return ;
        }

        int interval = (int) Math.pow(3, exponent);
        int blankLength = (int) Math.pow(3, exponent - 1);

        for (int i = start; i < n; i += interval) { // blank 시작 row
            for (int j = start; j < n; j += interval) { // blank 시작 col
                for (int k = 0; k < blankLength; k++) { // blank length 만큼 돌면서 공백 체크
                    for (int m = 0; m < blankLength; m++) { // blank length 만큼 돌면서 공백 체크
                        isBlank[i + k][j + m] = true;
                    }
                }
            }
        }

        readBlankPosition(exponent + 1, start * 3);
    }
}