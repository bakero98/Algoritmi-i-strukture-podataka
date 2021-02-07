package zadatak1;

public class Node {
    int indeks;
    double average;
    Node left;
    Node right;

    Node(int indeks, double average) {
        this.indeks = indeks;
        this.average = average;
        right = null;
        left = null;
    }

    Node() {

    }

    @Override
    public String toString() {
        return this.indeks + " " + this.average;
    }
}
