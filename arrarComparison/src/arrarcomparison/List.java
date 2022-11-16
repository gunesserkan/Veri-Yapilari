package arrarcomparison;

public class List {

    private Node head;
    List() {
        head = null;
    }
    public void add(int element) {
        if (head == null) {
            Node newNode = new Node(element);
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.getNext();
            }
            Node newNode = new Node(element);
            tmp.setNext(newNode);
        }
    }

    public boolean equal(int element) {
        Node tmp = head;
        if (tmp != null) {
            while (tmp != null) {
                if (tmp.getElement() == element) {
                    return true;
                }
                tmp = tmp.getNext();
            }
        }
        return false;
    }
    public void print(){
    Node tmp=head;
    while(tmp!=null){
        System.out.println(tmp.getElement());
        tmp=tmp.getNext();
    }
    }
    private class Node {

        private int element;
        private Node next;

        Node(int element) {
            this.element = element;
            next = null;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
