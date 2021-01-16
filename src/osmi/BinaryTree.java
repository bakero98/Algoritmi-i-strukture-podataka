package osmi;

public class BinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public Node() {

        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void cloneTree(Node root, Node newNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            newNode.left = new Node();
            newNode.left.value = root.left.value;
            cloneTree(root.left, newNode.left);
        }
        if (root.right != null) {
            newNode.right = new Node();
            newNode.right.value = root.right.value;
            cloneTree(root.right, newNode.right);
        }

    }
}
