package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n50_좌표정렬 {
    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if(this.x==o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arrayList.add(new Point(x, y));
        }
        Collections.sort(arrayList);
        for (Point point : arrayList) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
