import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int game = 0; game < t; game++) {
            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());

            // 1인 경우 무조건 길이는 1
            if (k == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            calcMinAndMaxLength(input, k, sb);
        }

        System.out.println(sb);
    }

    private static void calcMinAndMaxLength(String input, int k, StringBuilder sb) {
        Deque<Integer>[] deques = new Deque[26];

        for (int i = 0; i < 26; i++) {
            deques[i] = new LinkedList<>();
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            int alphabetIdx = input.charAt(i) - 'a';

            // 가장 먼저 들어간 인덱스 제거하고 현재 인덱스 추가하면서 k개를 유지해야 함 (즉, FIFO)
            if (deques[alphabetIdx].size() == k) {
                deques[alphabetIdx].removeLast();
            }

            deques[alphabetIdx].offerFirst(i);

            // k개를 만족한 경우, 문자열 길이 갱신
            if (deques[alphabetIdx].size() == k) {
                int startIdx = deques[alphabetIdx].peekLast();
                minLength = Math.min(minLength, i - startIdx + 1);
                maxLength = Math.max(maxLength, i - startIdx + 1);
            }
        }

        // 만족하는 연속 문자열이 없는 경우 -1 출력해야 함
        if (minLength == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(minLength).append(" ").append(maxLength);
        }

        sb.append("\n");
    }
}