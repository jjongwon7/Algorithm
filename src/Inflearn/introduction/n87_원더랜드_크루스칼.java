package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n87_원더랜드_크루스칼 {
    static class Edge implements Comparable<Edge>{
        public int vex;
        public int cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob){
            return this.cost - ob.cost; // PriorityQueue는 작은 수를 우선순위로 가진다.
        }
    }

    static int[] ch;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int answer=0;
        int n=kb.nextInt();
        int m=kb.nextInt();
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(); // 인접 리스트 선언
        ch=new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new Edge(b, c)); // a -> b의 비용이 c 라는 의미
            graph.get(b).add(new Edge(a, c)); // 무방향 그래프이므로 추가해줘야함.
        }
        pQ.offer(new Edge(1, 0)); // 1번 정점부터 출발
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex; // 도착 정점
            if (ch[ev] == 0) { // 방문한 적이 없는 정점인 경우
                ch[ev] = 1; // 방문했다는 의미로 ch 배열의 값 1로 변경
                answer += tmp.cost; // ans에 비용 더해줌.
                for (Edge ob : graph.get(ev)) { // ev를 시작 정점으로 갈 수 있는 정점들 탐색
                    if (ch[ob.vex] == 0) { // 방문한 적이 없는 정점이면
                        pQ.offer(new Edge(ob.vex, ob.cost)); // queue에 넣어줌.
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
