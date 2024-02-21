import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static List<Point> body = new LinkedList<>();
    static TurnTiming[] turnTimings;
    static int turnIdx;
    static int time;

    // 0: 북, 1: 동, 2: 남, 3: 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 개수

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine()); // 뱀의 방향 전환 횟수
        turnTimings = new TurnTiming[l];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turnTimings[i] = new TurnTiming(x, c);
        }

        int curX = 1;
        int curY = 1;
        int curD = 1; // dx, dy의 인덱스를 기준
        body.add(new Point(1, 1));
        while (true) {
            time++;

            int nextX = curX + dx[curD];
            int nextY = curY + dy[curD];

            if (nextX > n || nextX < 1 || nextY > n || nextY < 1) {
                break;
            } else if (!movable(nextX, nextY)) {
                break;
            } else {
                body.add(new Point(nextX, nextY));

                if (arr[nextX][nextY] == 0) { // 사과가 없는 경우
                    body.remove(0);
                } else {
                    arr[nextX][nextY] = 0;
                }

                curX = nextX;
                curY = nextY;

                while (turnIdx < turnTimings.length) {
                    TurnTiming turnTiming = turnTimings[turnIdx];
                    int turnRlt = turnTiming.calcDirection(curD);
                    if (turnRlt != -1) {
                        curD = turnRlt;
                        turnIdx++;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(time);
    }

    public static boolean movable(int nextX, int nextY) {
        for (Point point : body) {
            if (point.isMyBodyPoint(nextX, nextY)) {
                return false;
            }
        }

        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return y;
        }

        public boolean isMyBodyPoint(int nextX, int nextY) {
            return (this.x == nextX && this.y == nextY);
        }
    }

    static class TurnTiming {
        int x; // 게임 시작 시간으로부터 X초가 지난 뒤 방향 전환
        char c; // L => 왼쪽, D => 오른쪽으로 90도 회전

        public TurnTiming(int x, char c) {
            this.x = x;
            this.c = c;
        }

        public int calcDirection(int curD) {
            if (x == time) {
                if (c == 'L') {
                    return (curD + 3) % 4;
                } else {
                    return (curD + 1) % 4;
                }
            }

            return -1;
        }
    }
}