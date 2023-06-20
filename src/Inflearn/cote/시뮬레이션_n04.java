package Inflearn.cote;

import java.util.*;
public class 시뮬레이션_n04 {
    public static int[] solution(int c, int r, int k){

        int[] answer = new int[2];

        if(k > c * r) return new int[] {0, 0}; // 모든 좌석이 배정된 경우 [0,0] 리턴

        int[][] seat = new int[c][r]; // 문제의 배열을 시계 방향으로 90도 회전시킨 배열

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0, count = 1, d = 1; // d = 1 -> 3시 방향으로 이동

        while(count < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(solution(6, 5, 12)));
        System.out.println(Arrays.toString(solution(6, 5, 20)));
        System.out.println(Arrays.toString(solution(6, 5, 30)));
        System.out.println(Arrays.toString(solution(6, 5, 31)));
    }

}
