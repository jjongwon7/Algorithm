import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double max = Double.MIN_VALUE;
        double sum = 0.0;
        double[] score = new double[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            max = Math.max(max, score[i]);
        }

        for (double v : score) {
            v = v / max * 100;
            sum += v;
        }

        System.out.println(sum / n);
    }
}
