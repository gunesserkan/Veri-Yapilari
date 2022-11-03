
package StackDersUyg;

public class Stack {

    private StackItem top;

    Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;//yığıt boş mu değil mi değerini döndürür
    }

    public void push(String element) {
        if (isEmpty()) {//yığıtın en üstüne yeni değer ekler
            StackItem newItem = new StackItem(element);
            top = newItem;
            return;
        }
        StackItem newItem = new StackItem(element);
        newItem.setNext(top);
        top = newItem;
    }

    public String pop() {
        if (!isEmpty()) {
            StackItem tmp = top;//yığıtta en üstteki değeri yığıttan siler ve geriye döndürür
            top = top.getNext();
            return tmp.getElement();
        } else {
            return null;
        }
    }

    public String peek() {
        if(top==null)
            return "null";
        return top.getElement();//Yığıtın en üstteki değerini döndürür
    }
    //Yığıt elemanlarını tutan bağlı liste
    private class StackItem {

        private String element;
        private StackItem next;

        StackItem(String element) {
            this.element = element;
            this.next = null;

        }

        public String getElement() {
            return this.element;
        }
        public void setNext(StackItem next) {
            this.next = next;
        }

        public StackItem getNext() {
            return this.next;
        }

    }
}
