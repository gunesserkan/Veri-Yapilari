package veriyapılarıuyg;

public class Veriyapılarıuyg {

    public static int ardisikara(int aranan, int... dizi) {
        for (int i = 0; i < dizi.length; i++) {
            if (aranan == dizi[i]) {
                System.out.println(i + 1 + ". adımda bulundu");
                return i;
            }
        }

        return -1;

    }

    public static int ikiliara(int aranan, int[] dizi) {
        int bas = 0, son = dizi.length - 1;
        int i = 0;
        while (bas <= son) {
            int orta = (bas + son) / 2;
            i = i + 1;
            if (aranan == dizi[orta]) {
                System.out.println(i + ". adımda bulundu");
                return orta;
            } else if (aranan < dizi[orta]) {
                son = orta - 1;
            } else {
                bas = orta + 1;
            }
        }
        return -1;
    }

    static void topla(int m, int n) {
        int sayac = 0,sayac2=0;
        for (int i = 0; i < m; i++) {
                for (int j=n;j>1;j=j/2) {
                    sayac++;
                }
            
        }
        System.out.println("T(n)" + sayac);
    }

    public static void main(String[] args) {
        /*
        int[] d = {1, 8, 10, 15, 25, 32, 45, 50, 55, 75, 87, 123, 145};
        int indis = ikiliara(145, d);
        if (indis >= 0) {
            System.out.println("Bulundu");
        } else {
            System.out.println("Bulunamadı");
        }
         */

        topla(100,100);

    }

}
