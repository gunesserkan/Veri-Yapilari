package isPalindrom.DataStructure;

public class Stack {

    private StackItem top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;//stack boş mu değil mi değerini döndürür
    }

    public void push(String element) {
        if (isEmpty()) {//stackin en üstüne yeni değer ekler
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
            StackItem tmp = top;//stackin en üstteki değeri stackten siler ve geriye döndürür
            top = top.getNext();
            return tmp.getElement();
        } else {
            return null;
        }
    }

    public String peek() {
        return top.getElement();//stackin en üstteki değerini döndürür.
    }

    //Stack veri yapısı
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
