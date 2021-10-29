package javaclass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinrayTree {

    private Node node;
    static boolean[] visited = new boolean[10];
    static int[][] Graph = new int[10][10];
    static List<Integer> result;


    public BinrayTree(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }



    public List<Integer> bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.getValue());
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
        return result;
    }

    //전위 순회 node -> left -> right;
    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        dfs(node.getLeft());
        dfs(node.getRight());
    }

    //중위 순회 left -> node -> right
    public void middleSearch(Node node) {
        if (node == null) {
            return;
        }
        middleSearch(node.getLeft());
        System.out.print(node.getValue() + " ");
        middleSearch(node.getRight());
    }

    // 후외 순회  left ->right ->root
    public void rearSearch(Node node) {
        if (node == null) {
            return;
        }
        rearSearch(node.getLeft());
        rearSearch(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    // <- node 말고 데이터로 하면 -  전위 > //
    static void setDfsGraph(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < 5; ++i) {
            if (!visited[i] && Graph[node][i] != 0) {
                setDfsGraph(i);
            }
        }
    }
}
