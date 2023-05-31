package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n81_씨름선수 {
    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
    public static int solution(int n, ArrayList<Person> arrayList) {
        Collections.sort(arrayList);
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < arrayList.get(i).weight) {
                max = arrayList.get(i).weight;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
                arrayList.add(new Person(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(n, arrayList));

    }
}
