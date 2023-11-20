import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int sum = 0;
        int N = sc.nextInt();
        String input = sc.next();

        char[] nums = input.toCharArray();

        for (char num : nums) {
            sum += num - '0';
        }

        System.out.println(sum);
	}
}