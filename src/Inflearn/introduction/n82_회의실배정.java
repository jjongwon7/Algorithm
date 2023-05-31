package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class n82_회의실배정 {
    static class Timetable implements Comparable<Timetable> {
        int start;
        int end;

        public Timetable(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Timetable o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }
    public static int solution(int n, ArrayList<Timetable> arrayList) {
        int endTime = 0;
        int ans = 0;
        for (Timetable timetable : arrayList) {
            if (timetable.start >= endTime) {
                endTime = timetable.end;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Timetable> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new Timetable(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arrayList);
        System.out.println(solution(n, arrayList));
    }
}
