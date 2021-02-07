package zadatak1;

//Napisati program koji iz fajla ulaz.txt ucitava listu studenata sa prosjecnim ocjenama. U jednom redu je zapisan indeks
//studenta i prosjecna ocjena. Formirati binarno stablo pretrage od ucitanih podataka i omoguciti korisniku da na osnovu
//indeksa dobije prosjecnu ocjenu studentam kao i broj indeksa studenta sa najvecom prosjecnom ocjenom. Potrebno je prosiriti
//klasu Node takod a ukljuci podataka o ocjeni, dok se indeks koristi za pretragu.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak1 {
    private static Zadatak1 instance;
    private BinaryTree binaryTree;
    private ArrayList<Node> nodeList;
    private Node rootNode;

    public static Zadatak1 getInstance() {
        if (instance == null) {
            instance = new Zadatak1();
        }
        return instance;
    }

    public void Zadatak1() {
        start();
    }

    private void start() {
        binaryTree = new BinaryTree();
        nodeList = new ArrayList<>();

        try {
            File myObj = new File("C:/Users/Balsa/Desktop/Algoritmi i strukture podataka/src/zadatak1/ulaz.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split("[ ]");
                System.out.println(data[0] + " " + data[1]);
                nodeList.add(new Node(Integer.parseInt(data[0]), Double.parseDouble(data[1])));
            }
            myReader.close();
            //Pozivam kreiranje drveta
            createBinaryTree();

            System.out.println("trazim indeks 2212");
            System.out.println(binaryTree.findNode(rootNode, 2212));
            System.out.println("Najveci je " + binaryTree.getHighest(rootNode));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void createBinaryTree() {
        rootNode = nodeList.get(0);
        for ( int i = 1 ; i < nodeList.size() ; i++ ) {
            binaryTree.insert(rootNode, nodeList.get(i));
        }
    }
}
