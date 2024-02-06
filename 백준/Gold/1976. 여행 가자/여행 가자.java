import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // Number of Cities
        int m = Integer.parseInt(br.readLine()); // Number of Cities in travel plan

        parent = new int[n + 1];
        plan = new int[m];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        if (m == 1) {
            System.out.println("YES");
        } else {
            for (int i = 0; i < m - 1; i++) {
                if (find(plan[i]) != find(plan[i+1])) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a >= b) {
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