package isPalindrom.DataStructure;

public class Queue {

   private  Node front;
   private  Node rear;
   private  int size;
   public Queue() {
        front = null;
        rear=null;
    }
    //kuyrukta eleman olup olmadığını kontrol eder.
    public boolean isEmpty() {
        if (front == null) {
            return true;
        } else {
            return false;
        }
    }
    //kuyruğa eleman ekler.
    public void enqueue(String element){
        if(!isEmpty()){
          Node newNode=new Node(element);
          rear.setNext(newNode);
          rear=newNode;
          System.out.println(element+"queue eklendi");
        }else{
          Node newNode=new Node(element);
          front=newNode;
          rear=newNode;
          System.out.println(element+"queue eklendi");
        }
        ++size;
    }
    //kuyruğun başından eleman çıkarır ve geri çıkartılan elemanın değerini döndürür.
    public String dequeue(){
        if(!isEmpty()){
            Node tmp=front;
            front=front.getNext();
            System.out.println(tmp.getElement()+"queue silindi");
            return tmp.getElement();
        }
        else{
            return "Queue is empty";
        }
    }
    //kuyruğun en başındaki eleman değerini verir ancak silmez.
    public String getFront(){
        if(!isEmpty()){
            Node tmp=front;
            return tmp.getElement();
        }
        else{
            return "Queue is empty";
        }
    }
    //kuyrukdaki eleman sayısını veriri.
    public int getSize(){
        return size;
    }
    // kuruk veri yapısı
    private class Node {

        private String element;
        private Node next;

        Node(String element) {
            this.element = element;
            next = null;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public String getElement() {
            return element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

    }
}
