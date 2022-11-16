package arrarcomparison;

public class ArrarComparison {

    public static void isArraysEqual() {

    }

    public static List differentItem(int[] array1, int[] array2) {
        List[] listArray = new List[array2.length];
        List array3 = new List();
        for (int i = 0; i < listArray.length; i++) {
            listArray[i] = new List();
        }
        for (int i = 0; i < array2.length; i++) {
            if ((array2[i] % 31) >= listArray.length) {
                listArray[(listArray.length - 1)].add(array2[i]);
            } else {
                listArray[array2[i] % 31].add(array2[i]);
            }
        }
        for (int i = 0; i < array1.length; i++) {
            if ((array1[i] % 31) < listArray.length) {
                if (!listArray[array1[i] % 31].equal(array1[i])) {
                    array3.add(array1[i]);
                }
            } else {
                if (!listArray[listArray.length - 1].equal(array1[i])) {
                    array3.add(array1[i]);
                }
            }
        }
        return array3;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 8, 5, 12};
        int[] array2 = {2, 3, 1, 0, 5};
        List array3 = differentItem(array1, array2);
        array3.print();
    }
}
