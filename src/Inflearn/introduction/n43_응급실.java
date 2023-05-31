package Inflearn.introduction;

import java.util.*;

public class n43_응급실 {
    static class Person {
        int num;
        int priority;
        public Person(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
    public static int solution(int n, int m, int[] num) {
        Queue<Person> queue = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<n; i++)
            queue.offer(new Person(i, num[i]));
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for(Person p : queue) {
                if (tmp.priority < p.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                ans++;
                if(tmp.num == m)
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        System.out.println(solution(n, m, num));
    }
}
