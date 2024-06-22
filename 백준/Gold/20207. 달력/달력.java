import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Schedule[] schedules;
    static int[] heights = new int[367];
    static int[] counts = new int[367];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        schedules = new Schedule[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startDay = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(startDay, endDay);
        }

        Arrays.sort(schedules); // nlogn
        readSchedule();
        System.out.println(coatSchedule());

    }

    public static void readSchedule() {
        for (Schedule schedule : schedules) {
            for (int i = schedule.startDay; i <= schedule.endDay; i++) {
                // 여백이 존재하지 않는 경우에만 높이 증가
                if (heights[i] == counts[i]) {
                    heights[i]++;
                }

                counts[i]++;
            }
        }
    }

    public static int coatSchedule() {
        int left = 1;
        int right = 1;
        int maxHeight = 0;
        int sum = 0;

        // 366까지인 이유는 365일까지 일정이 존재하는 경우를 처리하기 위함
        for (int day = 1; day <= 366; day++) {
            // 끊기면 지금까지 구한 사각형 크기 구하기
            if (heights[day] == 0) {
                sum += maxHeight * (right - left + 1);

                // left 초기화
                left = day + 1;
                maxHeight = 0;
            }
            // 연속된 일정 집계
            else {
                right = day;
                maxHeight = Math.max(heights[day], maxHeight);
            }
        }

        return sum;
    }

    public static class Schedule implements Comparable<Schedule> {
        int startDay;
        int endDay;

        public Schedule(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(Schedule o) {
            // 정렬 기준
            // 시작일이 앞서는 순
            if (this.startDay < o.startDay) {
                return -1;
            }
            // 시작일이 같다면 일정의 기간이 긴 순
            else if (this.startDay == o.startDay) {
                if (this.endDay - this.startDay > o.endDay - o.startDay) {
                    return -1;
                } else if(this.endDay-this.startDay == o.endDay - o.startDay) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}