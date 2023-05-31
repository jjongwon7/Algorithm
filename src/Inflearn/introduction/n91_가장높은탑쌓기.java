package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n91_가장높은탑쌓기 {
    static class Block implements Comparable<Block>{
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

    static int[] dp;

    public static int solution(ArrayList<Block> arrayList) {
        Collections.sort(arrayList);
        dp[0] = arrayList.get(0).height;
        int ans = dp[0];
        for (int i = 1; i < arrayList.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayList.get(j).weight > arrayList.get(i).weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + arrayList.get(i).height;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Block> arrayList = new ArrayList<>();
        dp = new int [n];
        for (int i = 0; i < n; i++) {
            arrayList.add(new Block(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(arrayList));
    }
}
