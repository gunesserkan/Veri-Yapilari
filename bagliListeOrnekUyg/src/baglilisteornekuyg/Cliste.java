package baglilisteornekuyg;

class Celeman {

    int icerik;
    Celeman ileri;
    Celeman geri;

    public Celeman(int icerik) {
        this.icerik = icerik;
        this.ileri = null;
        this.geri = null;
    }

}

public class Cliste {

    Celeman bas, son;

    public Cliste() {
        bas = null;
    }

    void basaEkle(Celeman yeni) {
        if (bas == null) {
            bas = yeni;
        } else {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        }

    }

    void siraliEkle(Celeman yeni) {
        if (bas == null) {// liste boş ise
            bas = yeni;
        } else if (bas.icerik > yeni.icerik) {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        } else {
            Celeman tmp = bas;
            while (tmp.ileri != null && tmp.ileri.icerik < yeni.icerik) {
                tmp = tmp.ileri;
            }
            yeni.ileri = tmp.ileri;
            if (tmp.ileri != null) {
                yeni.ileri.geri = yeni;
            }
            tmp.ileri = yeni;
            yeni.geri = tmp;
        }

    }

    void sonaEkle(Celeman yeni) {
        if (bas == null) {
            bas = yeni;//Liste boş ise
        } else {
            Celeman tmp = bas;
            while (tmp.ileri != null) {
                tmp = tmp.ileri;
            }
            tmp.ileri = yeni;
            yeni.geri = tmp;
        }
    }

    void bastanSil() {
        if (bas == null) {
            return;
        } else if (bas.ileri != null) {
            bas = bas.ileri;
            bas.geri = null;
        } else {
            bas = null;
        }
    }

    void sondanSil() {
        Celeman tmp = bas;
        if (bas == null) {
            return;
        }
        if (bas.ileri == null) {
            bas = null;
            return;
        }
        while (tmp.ileri.ileri != null) {
            tmp = tmp.ileri;
        }
        tmp.ileri.geri = null;
        tmp.ileri = null;
    }

    String listele() {
        String S = "";
        Celeman tmp = bas;
        while (tmp != null) {
            S = S + tmp.icerik + "<->";
            tmp = tmp.ileri;
        }
        return S;
    }

    String sondanListele() {
        String S = "";
        Celeman tmp = bas;
        while (tmp.ileri != null) {
            tmp = tmp.ileri;
        }
        while (tmp != null) {

            S = S + tmp.icerik + "<->";
            tmp = tmp.geri;

        }
        return S;
    }

}
