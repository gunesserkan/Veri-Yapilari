package hashUygulamasi;

class Node {

    String key;
    int value;
    Node next;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}

public class LHash {

    int mBoyut, boyut;
    Node[] tablo;

    public LHash(int mBoyut) {
        this.mBoyut = mBoyut;
        boyut = 0;
        tablo = new Node[mBoyut];
        for (int i = 0; i < tablo.length; i++) {
            tablo[i] = null;
        }
    }

    int myHash(String key) {
        int h = key.hashCode();
        return h % mBoyut;
    }

    int get(String key) {
        int hash = myHash(key);
        if (tablo[hash] == null) {
            return -1;
        } else {
            Node tmp = tablo[hash];
            while (tmp != null && !tmp.key.equals(key)) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                return -1;
            } else {
                return tmp.value;
            }
        }
    }

}
