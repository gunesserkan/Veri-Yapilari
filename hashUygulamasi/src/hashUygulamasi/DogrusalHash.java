package hashUygulamasi;

public class DogrusalHash {

    private int gBoyut, maksBoyut;
    private String[] keys, values;

    public DogrusalHash(int maksBoyut) {
        this.maksBoyut = maksBoyut;
        gBoyut = 0;
        keys = new String[maksBoyut];
        values = new String[maksBoyut];
    }

    public boolean doluMu() {
        return gBoyut == maksBoyut;
    }

    public boolean bosMU() {
        return gBoyut == 0;
    }

    int hash(String key) {
        return key.hashCode() % maksBoyut;
    }

    void ekle(String key, String value) {
        int tmp = hash(key);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                ++gBoyut;
                return;
            }
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            i = (i + 1) % maksBoyut;
        } while (i != tmp);
    }

    String get(String key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + 1) % maksBoyut;
        }
        return null;
    }

    void sil(String key) {
        if (get(key) == null) {
            return;
        } else {
            int i = hash(key);
            while (!key.equals(keys[i])) {
                i = (i + 1) % maksBoyut;
            }
            keys[i] = values[i] = null;
            for (i = (i + 1) % maksBoyut; keys[i] != null; i = (i + 1) % maksBoyut) {
                String tmp1 = keys[i], tmp2 = values[i];
                keys[i] = values[i] = null;
                ekle(tmp1, tmp2);
            }
            --gBoyut;
        }
    }

    void printHash() {
        System.out.println("Hash Tablosu");
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println(i + "->" + keys[i] + "-" + values[i]);
            }
        }
        System.out.println("");
    }
}
