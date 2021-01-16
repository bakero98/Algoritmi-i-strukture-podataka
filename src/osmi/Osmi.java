package osmi;

//Dato je binarno stablo realnih brojeva. Napraviti njegovu kopiju.
import java.util.Scanner;

public class Osmi {
    private static Osmi instance;

    public static Osmi getInstance() {
        if(instance == null){
            instance = new Osmi();
        }
        return instance;
    }

    public void osmi(){
        getBinaryTree();
    }

    private void getBinaryTree() {
        Scanner input = new Scanner(System.in);

        System.out.print("Koliko zelite elemenata u binary tree : ");
        int numberInputs = input.nextInt();
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(100);
        for(int i = 0 ; i < numberInputs ; i++) {
            System.out.print("Unesite broj : ");
            if(i==0){
                root = new BinaryTree.Node(input.nextInt());
            }else{
                bt.insert(root, input.nextInt());
            }
        }

        BinaryTree newBinaryTree = new BinaryTree();
        BinaryTree.Node root2 = new BinaryTree.Node(100);
        bt.cloneTree(root, root2);
        bt.traverseInOrder(root2);
    }
}
