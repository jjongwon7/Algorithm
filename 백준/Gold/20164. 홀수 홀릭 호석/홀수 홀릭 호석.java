import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int minOddCnt = Integer.MAX_VALUE;
    static int maxOddCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        operationNum(inputNum, 0);

        System.out.println(minOddCnt + " " + maxOddCnt);
    }

    public static void operationNum(int num, int oddCnt) {
        // 수의 각 자리 숫자 중에서 홀수의 개수를 카운트
        oddCnt += countOdd(num);

        // 수가 한 자리이면 더 이상 아무것도 하지 않고 종료
        if(num < 10) {
            minOddCnt = Math.min(minOddCnt, oddCnt);
            maxOddCnt = Math.max(maxOddCnt, oddCnt);
        }

        // 수가 두 자리이면 2개로 나눠서 합을 구함
        else if(num < 100) {
            int leftDigit = num / 10;
            int rightDigit = num % 10;

            operationNum(leftDigit + rightDigit, oddCnt);
        }

        // 수가 세 자리 이상이면 임의로 나눠서 합을 구함
        else {
            String str = String.valueOf(num);

            for (int i = 1; i < str.length() - 1; i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    int leftDigit = Integer.parseInt(str.substring(0, i));
                    int middleDigit = Integer.parseInt(str.substring(i, j));
                    int rightDigit = Integer.parseInt(str.substring(j));

                    operationNum(leftDigit + middleDigit + rightDigit, oddCnt);
                }
            }
        }

    }

    public static int countOdd(int num) {
        int oddCnt = 0;

        while (num > 0) {
            // 일의 자리 수 홀수 체크
            if ((num % 10) % 2 == 1) {
                oddCnt++;
            }

            num /= 10;
        }

        return oddCnt;
    }
}