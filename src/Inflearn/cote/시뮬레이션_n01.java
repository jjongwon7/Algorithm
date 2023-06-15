package Inflearn.cote;

import java.util.*;
class Solution {

    public void DFS(char alpha, int pos, int depth, char[] answer, int[][] ladder) {

        // 사다리 타기가 끝난 시점

        if (depth == (ladder.length)) {
            answer[pos - 1] = alpha;
            return;
        }

        int left = 0; // ladder 배열에 존재하는 값
        int right = 0; // left의 오른쪽에 위치한 사다리

        // 현재 depth의 ladder 배열 순회
        for (int i : ladder[depth]) {
            left = i;
            right = i + 1;
            if (left == pos) {
                pos = pos + 1;
                break;
            } else if (right == pos) {
                pos = pos - 1;
                break;
            }
        }
//        System.out.println("alpha = " + alpha);
//        System.out.println("depth = " + depth);
//        System.out.println("pos = " + pos);
        DFS(alpha, pos, depth + 1, answer, ladder);
    }

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for (int i = 1; i <= n; i++) {
            DFS((char)('A' + i - 1), i, 0, answer, ladder);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}