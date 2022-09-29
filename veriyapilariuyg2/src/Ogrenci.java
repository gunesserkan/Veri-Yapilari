public class Ogrenci {
    String isim;
    int numara;
    int vize;

    public Ogrenci(String isim, int numara, int vize) {
        this.isim = isim;
        this.numara = numara;
        this.vize = vize;
    }
    public String toString(){
        return numara+" "+isim+" "+vize;
    }
}
