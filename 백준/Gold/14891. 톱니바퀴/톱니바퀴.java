import java.util.*;
import java.io.*;

public class Main {

    static int[][] gears = new int[4][8]; // N극: 0, S극: 1
    static TurnInfo[] turnInfos;
    static int[] startPointer = new int[4];
    static int k;
    static boolean[] isTurns = new boolean[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            char[] chars = input.toCharArray();

            for (int j = 0; j < 8; j++) {
                gears[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        k = Integer.parseInt(br.readLine());

        turnInfos = new TurnInfo[k];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            turnInfos[i] = new TurnInfo(gearNum - 1, direction);
        }

        for (int i = 0; i < k; i++) {
            int gearNum = turnInfos[i].gearNum;
            int direction = turnInfos[i].direction;
            Arrays.fill(isTurns, false);

            if (direction == 1) {
                turnClockwise(gearNum);
            } else {
                turnCounterClockwise(gearNum);
            }
        }

        int ans = 0;

        for (int i = 0; i < 4; i++) {
            if (gears[i][startPointer[i]] == 0) {
                ans += 0;
            } else {
                ans += Math.pow(2, i);
            }
        }

        System.out.println(ans);
    }

    static class TurnInfo {
        int gearNum;
        int direction; // 반시계 방향: -1, 시계 방향: 1

        public TurnInfo(int gearNum, int direction) {
            this.gearNum = gearNum;
            this.direction = direction;
        }
    }

    // 시계방향
    static public void turnClockwise(int gearNum) {
        int left = (startPointer[gearNum] + 6) % 8;
        int right = (startPointer[gearNum] + 2) % 8;

        isTurns[gearNum] = true;

        if (gearNum - 1 >= 0 && !isTurns[gearNum - 1]) {
            int rightAtLeftGear = (startPointer[gearNum - 1] + 2) % 8;
            if (gears[gearNum][left] != gears[gearNum - 1][rightAtLeftGear]) {
                turnCounterClockwise(gearNum - 1);
            }
        }

        if (gearNum + 1 < 4 && !isTurns[gearNum + 1]) {
            int leftAtRightGear = (startPointer[gearNum + 1] + 6) % 8;
            if (gears[gearNum][right] != gears[gearNum + 1][leftAtRightGear]) {
                turnCounterClockwise(gearNum + 1);
            }
        }

        if (startPointer[gearNum] - 1 == -1) {
            startPointer[gearNum] = 7;
        } else {
            startPointer[gearNum] = startPointer[gearNum] - 1;
        }
    }

    // 반시계방향
    static public void turnCounterClockwise(int gearNum) {
        int left = (startPointer[gearNum] + 6) % 8;
        int right = (startPointer[gearNum] + 2) % 8;

        isTurns[gearNum] = true;

        if (gearNum - 1 >= 0 && !isTurns[gearNum - 1]) {
            int rightAtLeftGear = (startPointer[gearNum - 1] + 2) % 8;
            if (gears[gearNum][left] != gears[gearNum - 1][rightAtLeftGear]) {
                turnClockwise(gearNum - 1);
            }
        }

        if (gearNum + 1 < 4 && !isTurns[gearNum + 1]) {
            int leftAtRightGear = (startPointer[gearNum + 1] + 6) % 8;
            if (gears[gearNum][right] != gears[gearNum + 1][leftAtRightGear]) {
                turnClockwise(gearNum + 1);
            }
        }

        if (startPointer[gearNum] + 1 == 8) {
            startPointer[gearNum] = 0;
        } else {
            startPointer[gearNum] = startPointer[gearNum] + 1;
        }
    }
}