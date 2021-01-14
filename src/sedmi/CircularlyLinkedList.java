package sedmi;

//Prijatelji sede za kružnim stolom. Listom L,
//čiji svaki čvor sadrži ime i pokazivač na sledeći čvor dat je njihov redosled sedenja.
//Ako odbrojavanje, počev od prve, svaka k-ta osoba napušta sto ispisati redosled napuštanja stola

public class CircularlyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getNext( ) { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> tail = null; // cuvamo rep
    private Node<E> head = null; // cuvamo glavu
    private int size = 0; // broj elemenata u listi

    public CircularlyLinkedList( ) { }
    public int size( ) { return size; }
    public boolean isEmpty( ) { return size == 0; }
    public E first( ) {
        if (isEmpty( )) return null;
        return tail.getNext( ).getElement( );
    }
    public E last( ) {
        if (isEmpty( )) return null;
        return tail.getElement( );
    }

    public void rotate( ) {
        if (tail != null)
            tail = tail.getNext( );
    }
    public void add(E e) {
        Node newNode = new Node(e, null);
        if(head == null) {
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
        size++;
    }

    public E removeFirst( ) {
        if (isEmpty( )) return null;
        Node<E> head = tail.getNext( );
        if (head == tail) tail = null;
        else tail.setNext(head.getNext( ));
        size--;
        return head.getElement();
    }

    public E getAt(int index) {
        if (isEmpty()) return null;
        Node<E> vracanje = tail.getNext();
        for(int i = 0 ; i < index ; i++) {
            vracanje = vracanje.getNext();
        }
        return vracanje.getElement();
    }

    public void removeEveryNextAtPositionUntilEmpty(int index) {
        int currentIndex = 0;
        if (isEmpty()) {
            System.out.println("Nema nikoga za stolom");
        }else{
            do {
                Node<E> vracanje = tail;
                for(int i = 0 ; i < index ; i++) {
                    vracanje = vracanje.getNext();
                }
                deleteNode(vracanje);
                index++;
            }while (size() != 0);
        }
    }

    private void deleteNode(Node node) {
        if (node == null || size() == 0) {
            System.out.println("Nema nista");
            return;
        }

        // Find the required node
        Node curr = head, prev = new Node("", null);
        while (!curr.element.equals(node.element)) {
            prev = curr;
            curr = curr.next;
        }

        // Check if node is only node
        if (curr.next == node) {
            System.out.println("Ustao : " + node.getElement() + " ovo je poslednji koji sjedi");
            size--;
            node = null;
            return;
        }

        // If more than one node, check if
        // it is first node
        if (curr == head) {
            System.out.println("Ustao : " + node.getElement() );
            size--;
            head = curr.next;
        }

        // check if node is last node
        else if (curr.next == tail) {
            System.out.println("Ustao : " + node.getElement() );
            prev.next = node;
            size--;
        }
        else {
            System.out.println("Ustao : " + node.getElement() );
            prev.next = curr.next;
            size--;
        }
        return;
    }
}
