import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // input line 2
        st = new StringTokenizer(br.readLine());
        int knownPersonNum = Integer.parseInt(st.nextToken());

        List<Integer> knownPersons = new ArrayList<>();

        for (int i = 0; i < knownPersonNum; i++) {
            knownPersons.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer>[] participants = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int participantNum = Integer.parseInt(st.nextToken());
            participants[i] = new ArrayList<>();

            for (int j = 0; j < participantNum; j++) {
                participants[i].add(Integer.parseInt(st.nextToken()));
            }

            if (participantNum >= 2) {
                int cur = participants[i].get(0);
                for (int j = 1; j <= participantNum - 1; j++) {
                    int next = participants[i].get(j);
                    union(cur, next);
                    cur = next;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            int cur = participants[i].get(0);
            for (int j = 0; j < knownPersonNum; j++) {
                if (find(cur) == find(knownPersons.get(j))) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}