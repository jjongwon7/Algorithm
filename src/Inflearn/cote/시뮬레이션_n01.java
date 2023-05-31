package Inflearn.cote;

import java.io.IOException;
import java.util.Arrays;

/**
 *  사다리 타기
 */
public class 시뮬레이션_n01 {

    public static void DFS(int L, int[][] ladder) {
        for (int i : ladder[L]) {
            
        }
    }
    public static char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 1; i <= n; i++) {
            int cur = i;
            for (int[] arr : ladder) {
                for (int j : arr) {
                    if (cur == j || cur == j + 1) {
                        if (cur == j) {
                            cur++;
                        } else {
                            cur--;
                        }
                        break;
                    }
                }
            }
            answer[cur-1] = (char)('A' + i - 1);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
