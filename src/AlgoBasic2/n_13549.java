//package AlgoBasic2;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class n_13549 {
//    static boolean[] check = new boolean[100001];
//
//    static class Subin {
//        int location;
//        int time;
//
//        public Subin(int location, int time) {
//            this.location = location;
//            this.time = time;
//        }
//    }
//    public static int BFS(int n, int k) {
//        int ans = Integer.MAX_VALUE;
//        Queue<Subin> queue = new LinkedList<>();
//        queue.offer(new Subin(n, 0));
//        check[n] = true;
//        while (!queue.isEmpty()) {
//            Subin subin = queue.poll();
//            if (subin.location == k) {
//                ans = Math.min(ans, subin.time);
//            }
//            else {
//                // X * 2로 이동하는 경우
//                int nextLocation = subin.location * 2;
//                if (nextLocation <= 100000 && check[nextLocation] == false) {
//                    check[nextLocation] = true;
//                    queue.offer(new Subin(nextLocation, subin.time));
//                }
//                // X + 1로 이동하는 경우
//                nextLocation = subin.location + 1;
//                if (nextLocation <= 100000 && ch    eck[nextLocation] == false) {
//                    queue.offer(new Subin(nextLocation, subin.time + 1));
//                    check[nextLocation] = true;
//                }
//                // X - 1로 이동하는 경우
//                nextLocation = subin.location - 1;
//                if (nextLocation >= 0 && check[nextLocation] == false) {
//                    queue.offer(new Subin(nextLocation, subin.time + 1));
//                    check[nextLocation] = true;
//                }
//            }
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        System.out.println(BFS(n, k));
//    }
//}
