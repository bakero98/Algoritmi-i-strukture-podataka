package zadatak1;

public class BinaryTree {

    public void insert(Node rootNode, Node newNode) {
        if (newNode.average < rootNode.average) {
            if (rootNode.left != null) {
                insert(rootNode.left, newNode);
            } else {
                System.out.println(" Inserted [ " + newNode.indeks + " " + newNode.average + "] to left of [" + rootNode.indeks + " " + rootNode.average + " ]" );
                rootNode.left = new Node(newNode.indeks, newNode.average);
            }
        } else if (newNode.average > rootNode.average) {
            if (rootNode.right != null) {
                insert(rootNode.right, newNode);
            } else {
                System.out.println("  Inserted [ " + newNode.indeks + " " + newNode.average + " ] to right of [ " + rootNode.indeks + " " + rootNode.average + " ]");
                rootNode.right = new Node(newNode.indeks, newNode.average);
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.toString());
            traverseInOrder(node.right);
        }
    }

    public Node findNode(Node rootNode, int indeks) {
        if(rootNode == null) {
            return null;
        }
        if(rootNode.indeks == indeks){
            return rootNode;
        }

        Node leftSideFind = findNode(rootNode.left, indeks);
        if(leftSideFind != null) { return leftSideFind; }

        Node rightSideFind = findNode(rootNode.right, indeks);
        return rightSideFind;
    }

    public void cloneTree(Node root, Node newNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            newNode.left = new Node();
            newNode.left.indeks = root.left.indeks;
            newNode.left.average = root.left.average;
            cloneTree(root.left, newNode.left);
        }
        if (root.right != null) {
            newNode.right = new Node();
            newNode.right.indeks = root.right.indeks;
            newNode.right.average = root.right.average;
            cloneTree(root.right, newNode.right);
        }

    }

    int getLeafCount(Node node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    Node getHighest(Node rootNode) {
        Node current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
}
