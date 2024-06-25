import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static Node[] adjList;
    public static boolean allNodesVisited = false;
    public static boolean finishFlag = false;
    public static int visitedNodeCnt = 0;
    public static Deque<Integer> inOrderStack = new ArrayDeque<>();
    public static int lastNodeNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjList = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());
            adjList[node] = new Node(leftChild, rightChild);
        }

        inOrder(1);
        lastNodeNum = inOrderStack.pop();
        visitedNodeCnt = 1;
        System.out.println(dfs(0, 1));

    }

    public static int dfs(int moveCnt, int nodeNum) {
        Node node = adjList[nodeNum];

        // 왼쪽 자식 노드 이동
        if (node.leftChildNodeNum != -1) {
            visitedNodeCnt++;
            moveCnt = dfs(moveCnt + 1, node.leftChildNodeNum); // 자식 노드 이동하는 횟수 1회
            moveCnt++; // 부모 노드로 다시 이동하는 횟수 1회
        }

        // 오른쪽 자식 노드 이동
        if (node.rightChildNodeNum != -1) {
            visitedNodeCnt++;
            moveCnt = dfs(moveCnt + 1, node.rightChildNodeNum);

            // 중위 순회 마지막 노드 이후 리턴되는 횟수는 집계하지 않음
            if (finishFlag) {
                return moveCnt;
            } else {
                moveCnt++;
            }
        }

        // 모든 노드를 탐색한 경우
        if (visitedNodeCnt == adjList.length - 1) {
            allNodesVisited = true;
        }

        if (allNodesVisited && lastNodeNum == nodeNum) {
            finishFlag = true;
        }

        return moveCnt;
    }

    // 중위 순회
    public static void inOrder(int nodeNum) {
        Node node = adjList[nodeNum];
        if (node.leftChildNodeNum != -1) {
            inOrder(node.leftChildNodeNum);
        }

        inOrderStack.push(nodeNum);

        if (node.rightChildNodeNum != -1) {
            inOrder(node.rightChildNodeNum);
        }
    }

    public static class Node {
        int leftChildNodeNum;
        int rightChildNodeNum;

        public Node(int leftChildNodeNum, int rightChildNodeNum) {
            this.leftChildNodeNum = leftChildNodeNum;
            this.rightChildNodeNum = rightChildNodeNum;
        }
    }
}