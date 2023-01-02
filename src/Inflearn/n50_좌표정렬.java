package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinate o) {
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class n50_좌표정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Coordinate> coordinate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinate.add(new Coordinate(x, y));
        }
        Collections.sort(coordinate);
        for (Coordinate coordinate1 : coordinate) {
            System.out.println(coordinate1.x + " " + coordinate1.y);
        }
    }
}
