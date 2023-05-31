package Inflearn.introduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class n33_매출액의종류 {
    public static ArrayList<Integer> solution(int n, int k, int[] num) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) {
            map.put(num[i], map.getOrDefault(num[i], 0) + 1);
        }
        arr.add(map.size());
        for(int i=k; i<n; i++) {
            map.put(num[i-k], map.get(num[i-k])-1);
            if(map.get(num[i-k]) == 0)
                map.remove(num[i-k]);
            map.put(num[i], map.getOrDefault(num[i], 0) + 1);
            arr.add(map.size());
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        for(int i : solution(n, k, num)) {
            System.out.print(i + " ");
        }
    }
}
