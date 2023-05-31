package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n83_결혼식 {
    static class Time implements Comparable<Time>{
        int time;
        char state;
        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if(this.time == o.time) return this.state - o.state;
            else return this.time - o.time;
        }
    }
    public static int solution(ArrayList<Time> arrayList) {
        int ans = Integer.MIN_VALUE;
        Collections.sort(arrayList);
        int cnt = 0;
        for (Time time : arrayList) {
            if (time.state == 'e') {
                cnt--;
            } else if (time.state == 's') {
                cnt++;
                if (ans < cnt) {
                    ans = cnt;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arrayList.add(new Time(start, 's'));
            arrayList.add(new Time(end, 'e'));
        }
        System.out.println(solution(arrayList));
    }
}
