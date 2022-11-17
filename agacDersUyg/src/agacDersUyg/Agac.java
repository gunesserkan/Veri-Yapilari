package agacDersUyg;

public class Agac {

    Dugum kok;

    Agac() {
        kok = null;
    }

    void ekle(Dugum yeni) {
        Dugum once = null;
        Dugum tmp = kok;
        while (tmp != null) {
            once = tmp;
            if (yeni.no < tmp.no) {
                tmp = tmp.sol;
            } else {
                tmp = tmp.sag;
            }
        }
        if (once == null) {
            kok = yeni;
        } else if (yeni.no < once.no) {
            once.sol = yeni;
        } else {
            once.sag = yeni;
        }
    }

    Dugum agacAra(int no) {
        Dugum d = kok;
        while (d != null) {
            if (d.no == no) {
                return d;
            } else if (no < d.no) {
                d = d.sol;
            } else if (no > d.no) {
                d = d.sag;
            }
        }
        return null;
    }

    Dugum enBuyuk() {
        Dugum d = kok;
        while (d.sag != null) {
            d = d.sag;
        }
        return d;
    }

    Dugum enKucuk() {
        Dugum d = kok;
        while (d.sol != null) {
            d = d.sol;
        }
        return d;
    }

    boolean yaprakSil(int no) {
        Dugum tmp=kok, ata = kok;
        boolean sol = true;
        if (kok == null) {
            return false;
        }
        while (tmp.no != no) {
            ata = tmp;
            if (no < tmp.no) {
                tmp = tmp.sol;
                sol = true;
            } else {
                sol = false;
                tmp = tmp.sag;
            }
            if (tmp == null) {
                return false;
            }
        }
        if (tmp.sol == null && tmp.sag == null) {
            if (tmp == kok) {
                kok = null;
            } else if (sol == true) {
                ata.sol = null;
            } else {
                ata.sag = null;
            }
            return true;
        } else {
            return false;
        }
    }
    void inorder(Dugum d){
        if(d==null){
        return;
        }
        inorder(d.sol);
        System.out.println(d.no+" "+d.isim);
        inorder(d.sag);
    }
}

class Dugum {

    int no;
    String isim;
    Dugum sol, sag;

    Dugum(String isim, int no) {
        this.no = no;
        this.isim = isim;
        sol = null;
        sag = null;
    }
}
