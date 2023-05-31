package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_1107 {
    static int ans = 0;
    public static int bruteForce(String n, ArrayList<Integer> arrayList) {
        int[] arr = new int[n.length()];
        boolean flag = false;
        int rlt = 0;
        for (int i = 0; i < n.length(); i++) {
            int tmp = n.charAt(i) - '0';
            int max = -1;
            for (int cur : arrayList) {
                if (tmp >= cur) {
                    max = Math.max(max, cur);
                } else {
                    break;
                }
            }
            if (max == -1) {

            } else if (max == tmp) {
                arr[i] = max;
                ans++;
            } else if (max < tmp) {
                arr[i] = max;
                ans++;
                for (int j = i + 1; j < n.length(); j++) {
                    arr[j] = arrayList.get(arrayList.size() - 1);
                    ans++;
                }
                flag = true;
            }
            if (flag) {
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < n.length(); i++) {
                rlt = rlt * 10 + arr[i];
            }
        }
        return rlt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            int[] num = new int[m];
            ArrayList<Integer> arrayList = new ArrayList<>();
            int j = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 10; i++) {
                if (num[j] == i) {
                    if (j + 1 < m) {
                        j++;
                    }
                } else {
                    arrayList.add(i);
                }
            }
            int rlt = bruteForce(n, arrayList);
            int ch = Integer.parseInt(n);
            if (rlt != 0) {
                ans += (ch - rlt);
            }
        } else {
            int ch = Integer.parseInt(n);
            while (ch > 0) {
                ch /= 10;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
