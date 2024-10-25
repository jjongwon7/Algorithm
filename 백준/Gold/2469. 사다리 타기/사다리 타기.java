import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine()); // 사람의 수
        int n = Integer.parseInt(br.readLine()); // 가로 줄 수
        String resultOfGame = br.readLine();
        boolean[][] isLadderExists = new boolean[n][k-1];
        int idxOfUnknown = -1;
        for (int i = 0; i < n; i++) {
            String ladderInfo = br.readLine();

            for (int j = 0; j < k-1; j++) {
                if (ladderInfo.charAt(j) == '?') {
                    idxOfUnknown = i;
                    break;
                }

                switch (ladderInfo.charAt(j)) {
                    case '*' :
                        isLadderExists[i][j] = false;
                        break;
                    case '-' :
                        isLadderExists[i][j] = true;
                }
            }
        }

        char[] topArr = new char[k];
        for (int i = 0; i < k; i++) {
            topArr[i] = (char) ('A' + i);
        }

        char[] bottomArr = new char[k];
        for (int i = 0; i < k; i++) {
            bottomArr[i] = resultOfGame.charAt(i);
        }

        // 사다리 위치가 정해지지 않은 것 기준 위쪽 사다리 타기 결과 구하기
        for (int i = 0; i < idxOfUnknown; i++) {
            topArr = checkLadderExistsAndSwap(topArr, isLadderExists, k, i);
        }

        // 사다리 위치가 정해지지 않은 것 기준 아래쪽 사다리 타기 결과 구하기
        for (int i = n - 1; i >= idxOfUnknown + 1; i--) {
            bottomArr = checkLadderExistsAndSwap(bottomArr, isLadderExists, k, i);
        }

        // 비교하기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k - 1; i++) {
            // 사다리가 필요 없는 경우
            if (topArr[i] == bottomArr[i]) {
                sb.append("*");
                continue;
            }

            // 사다리 유무와 별개로 만들 수 없는 경우
            if (topArr[i] != bottomArr[i + 1]) {
                System.out.println("x".repeat(k - 1));
                return;
            }

            // 사다리 유무와 별개로 만들 수 없는 경우
            if (topArr[i + 1] != bottomArr[i]) {
                System.out.println("x".repeat(k - 1));
                return;
            }

            // 사다리 설치(2개 연속 설치할 수 없는 특징 고려)
            sb.append("-");
            i++;
            if (i < k - 1) {
                sb.append("*");
            }
        }

        System.out.println(sb);
    }

    public static char[] checkLadderExistsAndSwap(char[] original, boolean[][] isLadderExists, int k, int row) {
        char[] tempArr = new char[k];

        for (int j = 0; j < k - 1; j++) {
            if (isLadderExists[row][j]) {
                tempArr[j + 1] = original[j];
                tempArr[j] = original[j + 1];
                j++;
            } else {
                tempArr[j] = original[j];
            }
        }

        if (!Character.isAlphabetic(tempArr[k - 1])) {
            tempArr[k - 1] = original[k - 1];
        }

        return tempArr;
    }
}