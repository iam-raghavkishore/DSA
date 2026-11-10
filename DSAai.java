import java.util.ArrayDeque;
import java.util.Queue;

public class DSAai {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static void printLevels(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();

                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(node.value);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printLevels(root);
    }
}
