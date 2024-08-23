import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCnt; t++) {
            // 입력: 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표
            // 강산이가 백스페이스를 입력했다면, '-'가 주어진다.
            // 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다.
            // 화살표의 입력은 '<'와 '>'로 주어진다 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다.

            List<Character> list = new LinkedList<>();
            int idx = 0;

            for (char c : br.readLine().toCharArray()) {
                if (idx < 0) {
                    idx = 0;
                } else if (idx > list.size()) {
                    idx = list.size();
                }

                if(c == '<') {
                    if (idx > 0) {
                        idx--;
                    }
                } else if (c == '>') {
                    if (idx < list.size()) {
                        idx++;
                    }
                } else if (c == '-') {
                    if (idx > 0) {
                        list.remove(--idx);
                    }
                } else {
                    list.add(idx++, c);
                }
            }
            sb.append(list.stream().map(String::valueOf).collect(Collectors.joining())).append("\n");
        }
        System.out.println(sb);
    }
}