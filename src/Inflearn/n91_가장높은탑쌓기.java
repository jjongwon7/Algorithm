package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Block implements Comparable<Block>{
    int area;
    int height;
    int weight;

    public Block(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Block block) {
        return block.area - this.area;
    }
}

public class n91_가장높은탑쌓기 {
    static int[] dy;

    public static int solution(ArrayList<Block> arrayList) {
        int ans = 0;
        Collections.sort(arrayList);
        dy[0] = arrayList.get(0).height;
        ans = dy[0];
        for (int i = 1; i < arrayList.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayList.get(j).weight > arrayList.get(i).weight && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + arrayList.get(i).height;
            ans = Math.max(dy[i], ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Block> arrayList = new ArrayList<>();
        dy = new int [n];
        for (int i = 0; i < n; i++) {
            arrayList.add(new Block(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(arrayList));
    }
}
