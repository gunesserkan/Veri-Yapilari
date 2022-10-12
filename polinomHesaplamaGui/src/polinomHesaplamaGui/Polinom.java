package polinomHesaplamaGui;
//listeyi tutacak olan sınıfın başlangıcı

public class Polinom {

    //Listenin ilk elemanını tutacak nesne
    private Node head;
    //listedeki elaman sayısı için değişken
    private int adet;

    //Listeyi tutan sınıfın kurucu methodu
    Polinom() {
        head = null;
        adet = 0;
    }

    //Listenin eleman sayısının int olarak geri döndürülmesi
    public int getAdet() {
        return this.adet;
    }

    public void listeSifirla() {
        head = null;
    }

    //Listeye yeni bir düğüm eklemek için metod
    public void add(int katSayi, int us) {
        if (head == null) {
            Node node = new Node(katSayi, us);
            head = node;
            ++adet;
            return;
        } else {
            Node tmp = head;
            if (tmp.getUs() < us) {
                Node node = new Node(katSayi, us);
                node.setNext(tmp);
                head = node;
                ++adet;
            } else if (tmp.getUs() == us) {
                if (tmp.getKatSayi() < katSayi) {
                    Node node = new Node(katSayi, us);
                    node.setNext(tmp);
                    head = node;
                    ++adet;
                } else {
                    Node node = new Node(katSayi, us);
                    tmp.setNext(node);
                    ++adet;
                }
            } else {
                while (tmp.getNext() != null) {
                    if (tmp.getNext().getUs() < us) {
                        Node node = new Node(katSayi, us);
                        node.setNext(tmp.getNext());
                        tmp.setNext(node);
                        head = node;
                        ++adet;
                        return;
                    } else if (tmp.getNext().getUs() == us) {
                        if (tmp.getNext().getKatSayi() < katSayi) {
                            Node node = new Node(katSayi, us);
                            node.setNext(tmp.getNext());
                            tmp.setNext(node);
                            head = node;
                            ++adet;
                            return;
                        } else {
                            Node node = new Node(katSayi, us);
                            tmp.getNext().setNext(node);
                            ++adet;
                            return;
                        }
                    }
                    tmp = tmp.next;
                }
                Node node = new Node(katSayi, us);
                tmp.setNext(node);
                ++adet;

            }
        }

    }

    //Listeye eklenen elemanların polinom olarak String türünde geri döndürülmesi
    public String yaz() {
        String polinom = "Polinom :";
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getKatSayi() > 0) {
                polinom += "+" + tmp.getKatSayi() + "X^" + tmp.getUs();
            } else {
                polinom += tmp.getKatSayi() + "X^" + tmp.getUs();

            }
            tmp = tmp.getNext();
        }
        return polinom;
    }

    //Bağlı listedeki elemanların dizi ile geri döndürülmesi
    public int[][] degerler() {
        int[][] degerlerDondurulen = new int[adet][2];
        boolean katSayiMi = true;
        Node tmp = head;
        int i = 0;
        if (tmp.getNext() == null) {
            degerlerDondurulen[i][0] = tmp.getKatSayi();
            degerlerDondurulen[i][1] = tmp.getUs();
            return degerlerDondurulen;
        }
        while (tmp.getNext() != null) {
            i++;
            degerlerDondurulen[i][0] = tmp.getKatSayi();
            degerlerDondurulen[i][1] = tmp.getUs();
            tmp = tmp.getNext();

        }
        return degerlerDondurulen;

    }

    //Node sınıfı başlangıcı
    private class Node {

        //Veri yapısı
        private int katSayi;
        private int us;
        //Sonraki düğüm
        private Node next;

        //kurucu method
        Node(int katSayi, int us) {
            this.katSayi = katSayi;
            this.us = us;
            next = null;
        }

        //Getter ve Setter tanımlamaları başlangıcı
        /**
         * @return the katSayi
         */
        public int getKatSayi() {
            return katSayi;
        }

        /**
         * @param katSayi the katSayi to set
         */
        public void setKatSayi(int katSayi) {
            this.katSayi = katSayi;
        }

        /**
         * @return the us
         */
        public int getUs() {
            return us;
        }

        /**
         * @param us the us to set
         */
        public void setUs(int us) {
            this.us = us;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }

    }
}
