package AlgoBasic1;

import java.util.Scanner;

public class n_1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        switch (str.length() % 3) {
            case 1:
                sb.append(str.charAt(0));
                str = str.substring(1);
                break;
            case 2:
                sb.append((str.charAt(0) - '0') * 2 + (str.charAt(1) - '0'));
                str = str.substring(2);
        }
        for (int i = 0; i < str.length(); i+=3) {
            sb.append((str.charAt(i) - '0') * 4 + (str.charAt(i + 1) - '0') * 2 + (str.charAt(i + 2) - '0') * 1);
        }
        System.out.println(sb);
    }
}
