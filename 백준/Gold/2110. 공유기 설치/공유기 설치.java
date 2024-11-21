import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집의 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기의 개수

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int right = 1_000_000_000;
        int left = 0;
        int answer = 0;

        while (left <= right) {
            int mid = right - (right - left) / 2;

            int installationCount = 1;
            int house1 = 0;
            int house2 = 1;
            for (; house2 < n; house2++) {
                if (houses[house2] - houses[house1] >= mid) {
                    installationCount++;
                    house1 = house2;
                }
            }

            if (installationCount >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
}