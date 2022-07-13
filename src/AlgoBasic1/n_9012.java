package AlgoBasic1;

import java.util.Scanner;

public class n_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        String str;

        T = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<T; i++)
        {
            str = sc.nextLine();
            sb.append(checkVPS(str)).append("\n");
        }
        System.out.println(sb);
    }

    static String checkVPS(String str) {
        int leftnum = 0;
        int rightnum = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                leftnum++;
                count++;
            }
            else if(str.charAt(i) == ')') {
                rightnum++;
                count--;
            }
            if(count < 0)
                return "NO";
        }

        if(str.length() % 2 == 1)
            return "NO";
        else if(leftnum != rightnum)
            return "NO";
        else
            return "YES";
    }
}
