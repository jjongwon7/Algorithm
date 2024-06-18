import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static int[][] classRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        classRoom = new int[n + 1][n + 1];

        Map<Integer, Set<Integer>> favoriteInfos = new HashMap<>();

        // 좋아하는 학생 정보 입력
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            Set<Integer> favoriteSet = new HashSet<>();

            for (int j = 0; j < 4; j++) {
                favoriteSet.add(Integer.parseInt(st.nextToken()));
            }

            favoriteInfos.put(studentNum, favoriteSet);

            // 자리 정하기
            // 입력받은 순서대로 진행
            List<AdjInfo> adjInfo = getAdjInfo(favoriteSet);
            Collections.sort(adjInfo);
            AdjInfo selectedSeat = adjInfo.get(0);
            classRoom[selectedSeat.r][selectedSeat.c] = studentNum;
        }

        System.out.println(calcPoint(favoriteInfos));
    }

    // 인접한 칸 정보 불러오기
    public static List<AdjInfo> getAdjInfo(Set<Integer> favoriteSet) {
        List<AdjInfo> adjInfos = new ArrayList<>();

        // n * n 만큼 반복
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                // 이미 자리를 차지한 경우 처리
                if (classRoom[r][c] != 0) {
                    continue;
                }

                AdjInfo adjInfo = new AdjInfo(r, c);

                for (int i = 0; i < 4; i++) {
                    int adR = dr[i] + r;
                    int adC = dc[i] + c;

                    if(adR >=1 && adR <= n && adC >=1 && adC <= n) {
                        // 인접한 면이 비어있는 경우
                        if (classRoom[adR][adC] == 0) {
                            adjInfo.emptyCnt++;
                        }
                        // 인접한 면에 좋아하는 학생이 있는 경우
                        else if(favoriteSet.contains(classRoom[adR][adC])) {
                            adjInfo.studentCnt++;
                        }
                    }
                }

                adjInfos.add(adjInfo);
            }
        }

        return adjInfos;
    }

    public static int calcPoint(Map<Integer, Set<Integer>> favoriteInfos) {
        int score = 0;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int studentNum = classRoom[r][c];
                Set<Integer> favoriteSet = favoriteInfos.get(studentNum);
                int favoriteCnt = 0;

                for (int i = 0; i < 4; i++) {
                    int adR = dr[i] + r;
                    int adC = dc[i] + c;

                    // 인접한 면에 좋아하는 학생이 있는 경우
                    if(adR >=1 && adR <= n && adC >=1 && adC <= n && favoriteSet.contains(classRoom[adR][adC])) {
                        favoriteCnt++;
                    }
                }

                if (favoriteCnt == 0) {
                    score += 0;
                } else if (favoriteCnt == 1) {
                    score += 1;
                } else if (favoriteCnt == 2) {
                    score += 10;
                } else if (favoriteCnt == 3) {
                    score += 100;
                } else {
                    score += 1000;
                }
            }
        }

        return score;
    }

    public static class AdjInfo implements Comparable<AdjInfo> {
        int studentCnt = 0;
        int emptyCnt = 0;
        int r;
        int c;

        public AdjInfo(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(AdjInfo o) {
            if (this.studentCnt < o.studentCnt) { // 좋아하는 학생이 많은 순으로 정렬
                return 1;
            } else if (this.studentCnt == o.studentCnt) {
                if (this.emptyCnt < o.emptyCnt) {
                    return 1;
                } else if (this.emptyCnt == o.emptyCnt) {
                    if (this.r > o.r) {
                        return 1;
                    } else if (this.r == o.r) {
                        if (this.c > o.c) {
                            return 1;
                        }
                    }
                }
            }

            return -1;
        }
    }
}