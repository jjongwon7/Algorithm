package Inflearn.introduction;

import java.util.Scanner;
import java.util.*;

public class n86_친구인가 {
    static int[] unf;
    public static int Find(int v){ // 집합 번호 리턴
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a); // a의 집합 번호 리턴
        int fb=Find(b); // b의 집합 번호 리턴
        if(fa!=fb) unf[fa]=fb; // 서로 다른 집합인 경우 같은 집합으로 만들어준다.
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=1; i<=m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            Union(a, b);
        }
        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=Find(a);
        int fb=Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}