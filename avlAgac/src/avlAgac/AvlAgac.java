package avlAgac;

class Dugum {

    int icerik, yukseklik;
    Dugum sol, sag;

    public Dugum(int icerik) {
        this.icerik = icerik;
        yukseklik = 1;
        sol = null;
        sag = null;

    }
}

public class AvlAgac {

    Dugum kok;

    int yukseklik(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return N.yukseklik;
        }
    }

    int maks(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    Dugum sagaDondur(Dugum y) {
        Dugum x = y.sol;
        Dugum T2 = x.sag;
        x.sag = y;
        y.sol = T2;
        y.yukseklik = (maks(yukseklik(y.sol), (yukseklik(y.sag) + 1)));
        x.yukseklik = (maks(yukseklik(x.sol), (yukseklik(x.sag) + 1)));
        return x;
    }

    Dugum solaDondur(Dugum x) {
        Dugum y = x.sag;
        Dugum T2 = y.sol;
        y.sol = x;
        x.sag = T2;
        x.yukseklik = (maks(yukseklik(x.sol), (yukseklik(x.sag) + 1)));
        y.yukseklik = (maks(yukseklik(y.sol), (yukseklik(y.sag) + 1)));
        return y;
    }

    int dengef(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return yukseklik(N.sol) - yukseklik(N.sag);
        }
    }

    Dugum ekle(Dugum d, int yeni) {
        if (d == null) {
            return (new Dugum(yeni));
        }
        if (yeni < d.icerik) {
            d.sol = ekle(d.sol, yeni);
        } else if (yeni > d.icerik) {
            d.sag = ekle(d.sag, yeni);
        } else {
            return d;
        }
        d.yukseklik = 1 + maks(yukseklik(d.sol), yukseklik(d.sag));
        int denge = dengef(d);
        //SOL-SOL
        if (denge > 1 && yeni < d.sol.icerik) {
            return sagaDondur(d);
        }
        //SAG-SAG
        if (denge < -1 && yeni > d.sag.icerik) {
            return solaDondur(d);
        }
        //SOL-SAG
        if (denge > 1 && yeni > d.sol.icerik) {
            d.sol = sagaDondur(d.sol);
            return sagaDondur(d);
        }
        if (denge < -1 && yeni < d.sag.icerik) {

            d.sag = sagaDondur(d.sag);
            return solaDondur(d);
        }
        return d;
    }

    void preorder(Dugum d) {
        if (d != null) {
            System.out.println(d.icerik + " ");
            preorder(d.sol);
            preorder(d.sag);
        }
    }

    void inorder(Dugum d) {
        if (d != null) {
            inorder(d.sol);
            System.out.println(d.icerik + " ");
            inorder(d.sag);
        }
    }

    void maksimum() {
        Dugum d = kok;
        if (d == null) {
            System.out.println("Ağaç boş");
        }
        int count = 0;
        while (d.sag != null) {
            d = d.sag;
            ++count;
        }
        System.out.println("En büyük eleman " + d.icerik + " " + count + " adımda buldu.");
    }

    public static void main(String[] args) {
        AvlAgac a = new AvlAgac();
        a.kok = a.ekle(a.kok, 10);
        a.kok = a.ekle(a.kok, 20);
        a.kok = a.ekle(a.kok, 30);
        a.kok = a.ekle(a.kok, 40);
        a.kok = a.ekle(a.kok, 50);
        a.kok = a.ekle(a.kok, 25);
        System.out.println("Ağaç inorder dolaşım");
        a.inorder(a.kok);
        a.maksimum();
    }
}
