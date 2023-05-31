package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class n04_단어뒤집기 {
    public static ArrayList<String> solution(String[] str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(String ans : str) {
            String tmp = new StringBuilder(ans).reverse().toString();
            arrayList.add(tmp);
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = sc.next();
        }
        for(String ans : solution(str)) {
            System.out.println(ans);
        }
    }
}
