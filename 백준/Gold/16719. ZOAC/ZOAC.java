import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static char[] arr;
    static boolean[] isSelected;
    static int[] orders;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        isSelected = new boolean[arr.length];
        Set<Character> set = new TreeSet<>();

        for (char c : arr) {
            set.add(c);
        }

        int order = 1;
        orders = new int[arr.length];

        for (Character character : set) {
            for (int i = 0; i < arr.length; i++) {
                if (character == arr[i]) {
                    orders[i] = order;
                }
                order++;
            }
        }

        while (cnt < arr.length) {
            dfs(0);
        }

        System.out.println(sb);
    }

    public static void dfs(int startIdx) {
        if (startIdx >= arr.length) {
            return ;
        }

        int minOrder = Integer.MAX_VALUE;
        int minOrderIdx = arr.length;

        for (int i = startIdx; i < arr.length; i++) {
            if (!isSelected[i]) {
                if (minOrder > orders[i]) {
                    minOrderIdx = i;
                    minOrder = orders[i];
                }
            }
        }

        if (minOrderIdx == arr.length) {
            return ;
        }

        isSelected[minOrderIdx] = true;

        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i]) {
                sb.append(arr[i]);
            }
        }

        sb.append("\n");
        cnt++;

        for (int i = minOrderIdx + 1; i < arr.length; i++) {
            dfs(minOrderIdx + 1);
        }
    }
}