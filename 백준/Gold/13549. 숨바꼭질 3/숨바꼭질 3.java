import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] check = new boolean[100001];

    static class Subin {
        int location;
        int time;

        public Subin(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
    public static int BFS(int n, int k) {
        Queue<Subin> queue = new LinkedList<>();
        queue.offer(new Subin(n, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Subin subin = queue.poll();
                if (subin.location == k) {
                    return subin.time;
                }
                int nextLocation = subin.location * 2;
                // 0초 후에 이동하는 경우 처리
                while (nextLocation <= 100000) {
                    if (check[nextLocation] == false) {
                        check[nextLocation] = true;
                        queue.offer(new Subin(nextLocation, subin.time));
                        nextLocation *= 2;
                    } else {
                        break;
                    }
                }
                // 1초 후에 이동하는 두 가지 경우 처리
                for (int j = 0; j < 2; j++) {
                    switch (j) {
                        case 0: // X + 1로 이동하는 경우
                           nextLocation = subin.location + 1;
                           break;
                        case 1: // X - 1로 이동하는 경우
                            nextLocation = subin.location - 1;
                    }
                    // 방문한 적 없는 지점이면 큐에 저장
                    if (nextLocation >= 0 && nextLocation <= 100000 && check[nextLocation] == false) {
                        queue.offer(new Subin(nextLocation, subin.time + 1));
                        check[nextLocation] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(BFS(n, k));
    }
}
