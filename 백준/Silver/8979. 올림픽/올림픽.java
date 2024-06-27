import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Country> pQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int goldNum = Integer.parseInt(st.nextToken());
            int silverNum = Integer.parseInt(st.nextToken());
            int bronzeNum = Integer.parseInt(st.nextToken());
            pQ.offer(new Country(num, goldNum, silverNum, bronzeNum));
        }

        List<Country> list = new ArrayList<>();
        int rank = 1;

        while (true) {
            Country curCountry = pQ.poll();

            if (list.size() > 0) {
                Country preCountry = list.get(list.size() - 1);

                if (!isSameScore(curCountry, preCountry)) {
                    rank = list.size() + 1;
                }
            }

            curCountry.rank = rank;
            list.add(curCountry);

            if (curCountry.num == k) {
                break;
            }
        }

        System.out.println(rank);
    }

    public static class Country implements Comparable<Country> {
        int num;
        int goldNum;
        int silverNum;
        int bronzeNum;
        int rank;

        public Country(int num, int goldNum, int silverNum, int bronzeNum) {
            this.num = num;
            this.goldNum = goldNum;
            this.silverNum = silverNum;
            this.bronzeNum = bronzeNum;
        }

        @Override
        public int compareTo(Country c) {
            if (this.goldNum != c.goldNum) return c.goldNum - this.goldNum;
            if (this.silverNum != c.silverNum) return c.silverNum - this.silverNum;
            if (this.bronzeNum != c.bronzeNum) return c.bronzeNum - this.bronzeNum;
            return 0;
        }
    }

    public static boolean isSameScore(Country c1, Country c2) {
        return (c1.goldNum == c2.goldNum && c1.silverNum == c2.silverNum && c1.bronzeNum == c2.bronzeNum);
    }
}