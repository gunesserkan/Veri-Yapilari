package dizikontrol;

public class Main {

    public static boolean esitMi(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        } else {
            Hash[] hash = new Hash[array1.length];
            for (int i = 0; i < hash.length; i++) {
                hash[i] = null;
            }
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] == null) {
                    hash[(array2[i] % hash.length)] = new Hash(array2[i]);
                } else if (hash[i].getValue() != array2[i]) {
                    int j = array1[i] % hash.length;
                    boolean devamMi = true;
                    while (devamMi) {
                        if (j >= hash.length) {
                            j = 0;
                        }
                        if (hash[j] == null) {
                            hash[j] = new Hash(array2[i]);
                            devamMi = false;
                        }
                        ++j;
                    }
                }
            }
            for (int i = 0; i < hash.length; i++) {
                if (hash[(array1[i] % hash.length)] != null) {
                    if (hash[(array1[i] % hash.length)].getValue() != array1[i]) {
                        int j = array1[i] % hash.length;
                        boolean devamMi = true;
                        do{
                            if (j >= hash.length) {
                                j = 0;
                            }
                            if ((j%hash.length)== i%hash.length) {
                                return false;
                            } else if (hash[j].getValue() != array2[j]) {
                                j=(j+1)%hash.length;
                            }
                        }while(devamMi);
                    }
                } else {

                }
            }
        }

        return true;
    }

    public static String farklıDegerler(int[] array1, int[] array2) {
        // int[] array3 = new int[array1.length];
        String degerler = "";
        Hash[] hash = new Hash[array1.length];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = null;
        }
        for (int i = 0; i < array2.length; i++) {
            if (hash[array2[i] % hash.length] == null) {
                hash[(array2[i] % hash.length)] = new Hash(array2[i]);
            } else if (hash[array2[i] % hash.length].getValue() != array2[i]) {
                int j = array2[i] % hash.length;
                boolean devamMi = true;
                while (devamMi) {
                    if (j >= hash.length) {
                        j = 0;
                    }
                    if (hash[j] == null) {
                        hash[j] = new Hash(array2[i]);
                        devamMi = false;
                    }
                    ++j;
                }
            }
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[(array1[i] % hash.length)] != null) {
                if (hash[(array1[i] % hash.length)].getValue() != array1[i]) {
                    //array3[i]=array1[i];
                    degerler += String.valueOf(array1[i]) + " ";
                } else {
                    int j = array1[i] % hash.length;
                    boolean devamMi = true;
                    while (devamMi) {
                        if (j >= hash.length) {
                            j = 0;
                        }
                        if (hash[j] == null || hash[j].getValue() == array1[j]) {
                            devamMi = false;
                        } else if (hash[j].getValue() != array1[j]) {
                            ++j;
                        }
                    }
                }
            } else {
                //array3[i]=array1[i];
                degerler += String.valueOf(array1[i]) + " ";
            }
        }
        //return array3;
        return degerler;

    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 5, 4, 0, 2, 5};
        int[] array2 = {2, 4, 5, 0, 1, 1, 2};
        if (esitMi(array1, array2)) {
            System.out.println("Bu iki dizi eşitttir.");
        } else {
            System.out.println("Bu iki dizi eşit değildir.");
        }
        String degerler = farklıDegerler(array1, array2);
        if (degerler.length() != 0) {
            System.out.println(degerler);
        } else {
            System.out.println("Farklı değer bulunamadı");
        }
    }
}
