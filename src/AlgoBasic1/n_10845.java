package AlgoBasic1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class n_10845 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int back = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
                switch (strArr[0]) {
                    case "push":
                        back = Integer.parseInt(strArr[1]);
                        queue.add(back);
                        break;
                    case "pop":
                        if (queue.isEmpty())
                            sb.append(-1).append('\n');
                        else
                            sb.append(queue.poll()).append('\n');
                        break;
                    case "size":
                        sb.append(queue.size()).append('\n');
                        break;
                    case "empty":
                        if (queue.isEmpty())
                            sb.append(1).append('\n');
                        else
                            sb.append(0).append('\n');
                        break;
                    case "front":
                        if (queue.isEmpty())
                            sb.append(-1).append('\n');
                        else
                            sb.append(queue.peek()).append('\n');
                        break;
                    case "back":
                        if (queue.isEmpty())
                            sb.append(-1).append('\n');
                        else
                            sb.append(back).append('\n');
                }
            }
        System.out.print(sb);
    }
}
