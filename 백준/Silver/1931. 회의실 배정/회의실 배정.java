import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(start, end);
        }

        Arrays.sort(arr, Comparator.comparingInt(Meeting::getEnd).thenComparingInt(Meeting::getStart));

        alloc(arr);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void alloc(Meeting[] arr) {
        int cnt = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].start >= end) {
                cnt++;
                end = arr[i].end;
            }
        }

        System.out.println(cnt);
    }
}