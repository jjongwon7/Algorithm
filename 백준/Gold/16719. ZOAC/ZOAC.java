import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        isSelected = new boolean[arr.length];
        int selectedCnt = 0;

        while (selectedCnt < arr.length) {
            selectedCnt += dfs(0);
        }

        System.out.println(sb);
    }

    public static int dfs(int startIdx) {
        // 시작 인덱스가 배열 사이즈를 초과한 경우 처리
        if (startIdx >= arr.length) {
            return 0;
        }

        int selectedCnt = 0;
        char minChar = 'Z' + 1;
        int minOrderIdx = arr.length;

        // 가장 앞 쪽에 위치한 가장 작은 문자 추출
        for (int i = startIdx; i < arr.length; i++) {
            if (!isSelected[i]) {
                if (minChar > arr[i]) {
                    minOrderIdx = i;
                    minChar = arr[i];
                }
            }
        }

        // 이미 모두 선택된 경우 처리
        if (minOrderIdx == arr.length) {
            return 0;
        }

        isSelected[minOrderIdx] = true;

        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i]) {
                sb.append(arr[i]);
            }
        }

        sb.append("\n");
        selectedCnt++;

        while (true) {
            int cnt = dfs(minOrderIdx + 1);
            if (cnt == 0) break;
            selectedCnt += cnt;
        }

        return selectedCnt;
    }
}