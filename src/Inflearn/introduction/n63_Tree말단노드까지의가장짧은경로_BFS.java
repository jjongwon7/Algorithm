package Inflearn.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class n63_Tree말단노드까지의가장짧은경로_BFS {
    Node root;
    public int BFS(int L, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                if (tmp.lt == null && tmp.rt == null) {
                    return L;
                } else {
                    if(tmp.lt!=null) queue.offer(tmp.lt);
                    if(tmp.rt!=null) queue.offer(tmp.rt);
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        n63_Tree말단노드까지의가장짧은경로_BFS tree = new n63_Tree말단노드까지의가장짧은경로_BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(0, tree.root));
    }
}
