import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tasks = new HashMap<>();
        int[] times = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            List<Integer> preTasks = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int preCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < preCnt; j++) {
                preTasks.add(Integer.parseInt(st.nextToken()));
            }

            times[i] = time;
            tasks.put(i, preTasks);
        }

        dp(n, times, tasks);
    }

    public static void dp(int n, int[] times, Map<Integer, List<Integer>> tasks) {
        int[] mem = new int[n + 1];
        int maxTime = Integer.MIN_VALUE;

        for (int taskNum = 1; taskNum <= n; taskNum++) {
            // 선행 작업 조회
            List<Integer> preTasks = tasks.get(taskNum);

            // 없다면 바로 시작
            if (preTasks.isEmpty()) {
                mem[taskNum] = times[taskNum];
            } else {
                // 있다면 선행 작업을 모두 마치고 바로 시작
                int allFinishedTime = Integer.MIN_VALUE;
                for (Integer preTask : preTasks) {
                    allFinishedTime = Math.max(mem[preTask], allFinishedTime);
                }
                mem[taskNum] = allFinishedTime + times[taskNum];
            }

            maxTime = Math.max(mem[taskNum], maxTime);
        }

        System.out.println(maxTime);
    }
}