package heap_uyg;

import java.util.Scanner;

class Eleman {

    int icerik;

    Eleman(int icerik) {
        this.icerik = icerik;
    }
}

class Yigin {

    Eleman[] dizi;
    int tane;

    public Yigin(int N) {
        dizi = new Eleman[N];
        tane = 0;
    }

    boolean bosMu() {
        return tane == 0;
    }

    void yukariCik(int no) {
        int ata = (no - 1) / 2;
        while (ata >= 0 && dizi[ata].icerik < dizi[no].icerik) {
            Eleman ara = dizi[ata];
            dizi[ata] = dizi[no];
            dizi[no] = ara;
            no = ata;
            ata = (no - 1) / 2;
        }
    }

    void ekle(Eleman yeni) {
        ++tane;
        dizi[tane - 1] = yeni;
        yukariCik(tane - 1);
    }

    void asagiIn(int no) {
        int altSol = 2 * no + 1, altSag = 2 * no + 2;
        while ((altSol < tane && dizi[no].icerik < dizi[altSol].icerik) || (altSag < tane & dizi[no].icerik < dizi[altSag].icerik)) {
            if (altSag > tane || dizi[altSol].icerik > dizi[altSag].icerik) {
                Eleman ara = dizi[no];
                dizi[no] = dizi[altSol];
                dizi[altSol] = ara;
                no = altSol;
            } else {
                Eleman ara = dizi[no];
                dizi[no] = dizi[altSag];
                dizi[altSag] = ara;
                no = altSag;
            }
            altSol = 2 * no + 1;
            altSag = 2 * no + 2;
        }
    }

    Eleman azamiDondur() {
        if (!bosMu()) {
            Eleman tmp = dizi[0];
            dizi[0] = dizi[tane - 1];
            asagiIn(0);
            --tane;
            return tmp;
        } else {
            return null;
        }
    }

    void yazdir() {
        for (int i = 0; i < tane / 2; i++) {
            int sol = 2 * i + 1;
            int sag = 2 * i + 2;
            System.out.println("Ata Dugum: " + dizi[i].icerik);
            if (sol < tane) {
                System.out.println("sol cocuk: " + dizi[sol].icerik);
            }
            if (sag < tane) {
                System.out.println("Sag cocuk: " + dizi[sag].icerik);
            }
            System.out.println(" ");
        }
    }
}

public class Heap_uyg {

    public static void main(String[] args) {
        Yigin y1, y2;
        y1 = new Yigin(10);
        y2 = new Yigin(10);
        Scanner klavye = new Scanner(System.in);
        System.out.println("Headp-1 sayıları virgul ile girin.");
        String h1 = klavye.nextLine();
        String[] s1 = h1.split(",");
        for (int i = 0; i < s1.length; i++) {
            y1.ekle(new Eleman(Integer.parseInt(s1[i])));
        }
        y1.yazdir();
        String h2 = klavye.nextLine();
        String[] s2 = h2.split(",");
        for (int i = 0; i < s2.length; i++) {
            y2.ekle(new Eleman(Integer.parseInt(s2[i])));
        }
        y2.yazdir();
    }
}
