package Inflearn.cote;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 시뮬레이션_n02 {

    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, 1, 0, -1};
    public static void DFS(Point point, int curTime, int[][] board, int k, int[] answer, int vector) {

        if (curTime == k) {
            answer[0] = point.y;
            answer[1] = point.x;
            return;
        }

        int nx = point.x + dx[vector]; // 다음 이동할 x값
        int ny = point.y + dy[vector]; // 다음 이동할 y값

        // 주어진 범위를 벗어나거나, 장애물이 있는 경우 로봇을 회전시킴
        if (nx == -1 || nx == board.length || ny == -1 || ny == board.length || board[ny][nx] == 1) {
            DFS(point, curTime + 1, board, k, answer, (vector + 1) % 4);
        } else { // 이동할 수 있는 경우 이동시킴
            DFS(new Point(nx, ny), curTime + 1, board, k, answer, vector);
        }
    }

    public static int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        DFS(new Point(0, 0), 0, board, k, answer, 0);

        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));

    }
}
