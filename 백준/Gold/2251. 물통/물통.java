import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean visited[][];
    static int[] maxVolumeArr;
    static Set<Integer> ansSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] bottleArr = {0, 0, c};
        maxVolumeArr = new int[]{a, b, c};
        visited = new boolean[a + 1][b + 1];
        ansSet.add(c);

        bfs(bottleArr);

        for (int i : ansSet) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs (int[] startBottleArr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startBottleArr);
        visited[startBottleArr[0]][startBottleArr[1]] = true;

        while (!queue.isEmpty()) {
            int[] bottleArr = queue.poll();

            for (int i = 0; i < 6; i++) {
                int[] movedBottleArr = moveWater(bottleArr, sender[i], receiver[i]);

                if (!visited[movedBottleArr[0]][movedBottleArr[1]]) {
                    queue.add(movedBottleArr);
                    visited[movedBottleArr[0]][movedBottleArr[1]] = true;
                    if (movedBottleArr[0] == 0) {
                        ansSet.add(movedBottleArr[2]);
                    }
                }
            }
        }
    }

    public static int[] moveWater(int[] bottleArr, int sender, int receiver) {
        int[] movedBottleArr = Arrays.copyOf(bottleArr, bottleArr.length);
        int freeVolume = getFreeVolume(movedBottleArr, receiver);

        if (movedBottleArr[sender] > freeVolume) {
            movedBottleArr[sender] -= freeVolume;
            movedBottleArr[receiver] = maxVolumeArr[receiver];
        } else {
            movedBottleArr[receiver] += movedBottleArr[sender];
            movedBottleArr[sender] = 0;
        }

        return movedBottleArr;
    }

    public static int getFreeVolume(int[] bottleArr, int bottle) {
        int maxVolume = maxVolumeArr[bottle];
        int nowVolume = bottleArr[bottle];

        return maxVolume - nowVolume;
    }
}