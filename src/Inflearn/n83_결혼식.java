package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Time implements Comparable<Time>{
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
public class n83_결혼식 {
    //    public static int solution(int n, int[][] num) {
//        int[] cnt = new int[73];
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int start = num[i][0]; start < num[i][1]; start++) {
//                cnt[start]++;
//            }
//        }
//        for (int i = 0; i < 73; i++) {
//            max = Math.max(max, cnt[i]);
//        }
//        return max;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] num = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                num[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(solution(n, num));
//    }
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
