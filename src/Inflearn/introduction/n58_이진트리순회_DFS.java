package Inflearn.introduction;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class n58_이진트리순회_DFS {
    static Node root;
    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.data);
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
}
