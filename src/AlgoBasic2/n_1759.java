package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1759 {
    static int l, c;
    static char[] ans;
    static char[] arr;
    static boolean[] check;

    public static boolean isVaild() {
        int consonant = 0; // 자음
        int vowel = 0; // 모음
        for (int i = 0; i < c; i++) {
            if (check[i] == true) {
                char alp = arr[i];
                if (alp == 'a' || alp == 'e' || alp == 'i' || alp == 'o' || alp == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }
        if (vowel >= 1 && consonant >= 2) {
            return true;
        } else {
            return false;
        }
    }
    public static void solution(int L, int pre) {
        if (L == l) {
            if (isVaild()) {
                for (char an : ans) {
                    System.out.print(an);
                }
                System.out.println();
            }
            return;
        }
        for (int i = pre; i < c; i++) {
            if (check[i] == false) {
                ans[L] = arr[i];
                check[i] = true;
                solution(L + 1, i+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = new char[l];
        arr = new char[c];
        check = new boolean[c];
        st = new StringTokenizer(br.readLine());
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        solution(0, 0);
    }
}
