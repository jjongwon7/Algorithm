import java.io.*;
import java.util.*;

public class Main {

    final static Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();
    static char[] possibleChars;
    static boolean[] used;
    static int l, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken()); // 암호를 구성하는 서로 다른 L개의 알파벳
        c = Integer.parseInt(st.nextToken()); // 암호를 구성하는 문자의 종류

        possibleChars = new char[c];
        used = new boolean[c];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            possibleChars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(possibleChars);

        dfs(0, new StringBuilder(), -1);

        System.out.println(sb);
    }

    private static void dfs(int depth, StringBuilder curPassword, int lastIdx) {
        if (depth == l) {
            if (isValidPassword(curPassword.toString())) {
                sb.append(curPassword).append("\n");
            }

            return;
        }

        for (int i = lastIdx + 1; i < c; i++) {
            if (!used[i]) {
                used[i] = true;
                curPassword.append(possibleChars[i]);
                dfs(depth + 1, curPassword, i);
                used[i] = false;
                curPassword.deleteCharAt(curPassword.length() - 1);
            }
        }
    }

    private static boolean isValidPassword(String str) {
        int vowelCount = 0;

        for (int i = 0; i < l; i++) {
            if (vowels.contains(str.charAt(i))) {
                vowelCount++;
            }
        }

        if (vowelCount >= 1 && l - vowelCount >= 2) {
            return true;
        }

        return false;
    }
}