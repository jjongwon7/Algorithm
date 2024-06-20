import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int leftTopRow = 0;
        int leftTopColumn = 0;
        int rightDownRow = n - 1;
        int rightDownColumn = m - 1;

        for (int i = 0; i < r; i++) {
            rotate(leftTopRow, leftTopColumn, rightDownRow, rightDownColumn);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void rotate(int leftTopRow, int leftTopColumn, int rightDownRow, int rightDownColumn) {
        int[][] rotatedArr = new int[n][m];

        while (leftTopRow <= rightDownRow && leftTopColumn <= rightDownColumn) {
            rotateRowLeft(leftTopColumn, rightDownColumn, leftTopRow, rotatedArr);
            rotateRowRight(leftTopColumn, rightDownColumn, rightDownRow, rotatedArr);
            rotateColumnDown(leftTopRow, rightDownRow, leftTopColumn, rotatedArr);
            rotateColumnUp(leftTopRow, rightDownRow, rightDownColumn, rotatedArr);

            leftTopRow++;
            leftTopColumn++;
            rightDownRow--;
            rightDownColumn--;
        }

        arr = rotatedArr;
    }

    public static void rotateRowLeft(int leftColumn, int rightColumn, int row, int[][] rotatedArr) {
        for (; leftColumn < rightColumn; leftColumn++) {
            rotatedArr[row][leftColumn] = arr[row][leftColumn + 1];
        }
    }

    public static void rotateRowRight(int leftColumn, int rightColumn, int row, int[][] rotatedArr) {
        for (; rightColumn > leftColumn; rightColumn--) {
            rotatedArr[row][rightColumn] = arr[row][rightColumn - 1];
        }
    }

    public static void rotateColumnDown(int topRow, int downRow, int column, int[][] rotatedArr) {
        for (; downRow > topRow; downRow--) {
            rotatedArr[downRow][column] = arr[downRow - 1][column];
        }
    }

    public static void rotateColumnUp(int topRow, int downRow, int column, int[][] rotatedArr) {
        for (; topRow < downRow; topRow++) {
            rotatedArr[topRow][column] = arr[topRow + 1][column];
        }
    }
}