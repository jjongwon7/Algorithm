import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] check = new boolean[2001][2001];
    static class Emoji {
        int screen;
        int clipBoard;

        public Emoji(int screen, int clipBoard) {
            this.screen = screen;
            this.clipBoard = clipBoard;
        }
    }

    public static int BFS(int s) {
        int L = 0;
        Queue<Emoji> queue = new LinkedList<>();
        queue.offer(new Emoji(1, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Emoji emoji = queue.poll();
                if (emoji.screen == s) {
                    return L;
                }
                if (emoji.screen > 0) {
                    // 1번 작업
                    if (check[emoji.screen][emoji.screen] == false) {
                        check[emoji.screen][emoji.screen] = true;
                        queue.offer(new Emoji(emoji.screen, emoji.screen));
                    }
                    // 3번 작업
                    if (check[emoji.screen - 1][emoji.clipBoard] == false) {
                        check[emoji.screen - 1][emoji.clipBoard] = true;
                        queue.offer(new Emoji(emoji.screen - 1, emoji.clipBoard));
                    }
                }
                if (emoji.screen <= 1000 && emoji.clipBoard <= 1000) {
                    // 2번 작업
                    if (check[emoji.screen + emoji.clipBoard][emoji.clipBoard] == false) {
                        check[emoji.screen + emoji.clipBoard][emoji.clipBoard] = true;
                        queue.offer(new Emoji(emoji.screen + emoji.clipBoard, emoji.clipBoard));
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(BFS(s));
    }
}
