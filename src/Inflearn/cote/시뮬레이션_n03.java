package Inflearn.cote;

import java.util.*;
public class 시뮬레이션_n03 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    // 좌표를 담을 클래스 정의
    private static class Point {
        int x;
        int y;
        int vector;

        public Point(int x, int y, int vector) {
            this.x = x;
            this.y = y;
            this.vector = vector;
        }
    }

    public static int DFS(Point person, Point dog, int depth, int[][] board) {
        // 철수가 강아지를 찾은 경우
        if ((person.x == dog.x) && (person.y == dog.y)) {
            return depth;
        } else if (depth >= 10000) { // 10,000분을 초과하는 경우
            return 0;
        } else {
            int npx = person.x + dx[person.vector];
            int npy = person.y + dy[person.vector];

            int ndx = dog.x + dx[dog.vector];
            int ndy = dog.y + dy[dog.vector];

            moveNextPoint(person, npx, npy, board);
            moveNextPoint(dog, ndx, ndy, board);

            return DFS(person, dog, depth + 1, board);
        }
    }

    public static Point moveNextPoint(Point cur, int nx, int ny, int[][] board) {
        // 이동할 수 없는 경우 회전
        if (nx == -1 || nx == board.length || ny == -1 || ny == board.length || board[ny][nx] == 1) {
            cur.vector = (cur.vector + 1) % 4;
        } else {
            cur.x = nx;
            cur.y = ny;
        }
        return cur;
    }

    public static int solution(int[][] board){
        int answer = 0;
        Point person = null;
        Point dog = null;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2) {
                    person = new Point(j, i, 0);
                } else if (board[i][j] == 3) {
                    dog = new Point(j, i, 0);
                }
            }
        }

        answer = DFS(person, dog, 0, board);

        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}
