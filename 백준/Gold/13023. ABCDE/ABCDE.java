import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean flag = false;
    static int n; // 사람의 수
    static int m; // 친구 관계의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i);

            if (flag) {
                break;
            }
        }

        if (flag) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void dfs(int depth, int start) {
        if (depth == 4) {
            flag = true;
            return;
        }
        visited[start] = true;
        for (Integer end : list[start]) {
            if (!visited[end]) {
                dfs(depth + 1, end);
            }
        }
        visited[start] = false;
    }
}