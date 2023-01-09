package Inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Timetable implements Comparable<Timetable> {
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
public class n82_회의실배정 {
    public static int solution(int n, Timetable[] timetables) {
        int endTime = 0;
        int ans = 0;
        for (Timetable timetable : timetables) {
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
        Timetable[] timetables = new Timetable[n];
        for (int i = 0; i < n; i++) {
            timetables[i] = new Timetable(sc.nextInt(), sc.nextInt());
        }
        Collections.sort(Arrays.asList(timetables));
        System.out.println(solution(n, timetables));
    }
}
