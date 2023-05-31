package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n85_다익스트라알고리즘 {
    static class Edge implements Comparable<Edge> {
        public int vex; // 정점
        public int cost; // 간선의 가중치 값

        Edge(int vex, int cost) {
            this.cost = cost;
            this.vex = vex;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost-ob.cost;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0)); // 1번 정점까지 가는 비용이 0이다.
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) { // 기존 dis 배열에 저장된 값보다 큰 경우는 볼 필요가 없다. (이미 최신화 되었음)
                continue;
            }
            for (Edge ob : graph.get(now)) { // 방문한 정점이 갈 수 있는 정점들을 모두 탐색
                if (dis[ob.vex] > nowCost + ob.cost) { // 기존 dis 배열에 저장된 값보다 작은 경우
                    dis[ob.vex] = nowCost+ob.cost; // dis 값 변경
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost)); // queue에 저장
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE); // dis 배열을 MAX_VALUE로 초기화
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c)); // a -> b로 가는 가중치가 c라는 의미.
        }
        solution(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
