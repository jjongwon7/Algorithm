package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n84_최대수입스케쥴_PriorityQueue {
    static class Request implements Comparable<Request>{
        int money;
        int day;
        public Request(int money, int day) {
            this.money = money;
            this.day = day;
        }
        @Override
        public int compareTo(Request o) {
            if(this.day == o.day) return o.money - this.money;
            else return o.day - this.day;
        }
    }
    public static int solution(int n, ArrayList<Request> arrayList, int maxDay) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < n; j++) {
                if (arrayList.get(j).day < i) break;
                priorityQueue.offer(arrayList.get(j).money);
            }
            if (!priorityQueue.isEmpty()) {
                ans += priorityQueue.poll();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxDay = Integer.MIN_VALUE;
        ArrayList<Request> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            arrayList.add(new Request(money, day));
            if (maxDay < day) {
                maxDay = day;
            }
        }
        Collections.sort(arrayList);
        System.out.println(solution(n, arrayList, maxDay));
    }
}
