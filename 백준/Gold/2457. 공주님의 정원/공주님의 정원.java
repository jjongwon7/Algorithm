import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int[] monthToTimes = new int[13];

    public static void main(String[] args) throws IOException {
        initMonthToTimes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][4];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                flowers[i][j] = Integer.parseInt(split[j]);
            }
        }

        Arrays.sort(flowers, (o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            if(o1[2] != o2[2]) return o2[2] - o1[2];
            return o2[3] - o1[3];
        });

        int preStartTime = monthToTimes[2] + 1;
        int end = monthToTimes[11] + 1;
        int idx = 0;
        int max = 0;
        int answer = 0;

        while (preStartTime < end) {
            boolean findYn = false;

            for (int i = idx; i < n; i++) {
                int curStartTime = dateToTime(flowers[i][0], flowers[i][1]);
                if (preStartTime < curStartTime) {
                    break;
                }

                int curEndTime = dateToTime(flowers[i][2], flowers[i][3]);
                if (max < curEndTime) {
                    max = curEndTime;
                    findYn = true;
                    idx = i + 1;
                }
            }

            if (!findYn) {
                break;
            }

            preStartTime = max;
            answer++;
        }

        if (max < end) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    public static void initMonthToTimes() {
        Set<Integer> monthAboutMaxDayIs30 = new HashSet<>(List.of(4, 6, 9, 11));
        Set<Integer> monthAboutMaxDayIs31 = new HashSet<>(List.of(1, 3, 5, 7, 8, 10, 12));

        int maxDay = 31;

        for (int i = 1; i <= 12; i++) {
            monthToTimes[i] = monthToTimes[i - 1] + maxDay;

            if (monthAboutMaxDayIs30.contains(i + 1)) {
                maxDay = 30;
            } else if (monthAboutMaxDayIs31.contains(i + 1)) {
                maxDay = 31;
            } else {
                maxDay = 28;
            }
        }
    }

    public static int dateToTime(int month, int day) {
        return monthToTimes[month - 1] + day;
    }
}
