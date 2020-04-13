package course.week2.sort;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort ( );
        int[] intArr = {10, 1, 9, 4, 2, 8, 5, 7, 3};
        System.out.println ( "before sort:   " );
        is.printArr ( intArr );
        is.insertionSort ( intArr );
        System.out.println ( "after sort:   " );
        is.printArr ( intArr );
    }

    private void insertionSort(int[] intArr) {
        int len = intArr.length;
        for (int i = 0; i < len; i++) {
            int key = intArr[i];
            int j = i - 1;
            while ((j > -1) && (intArr[j] > key)) {
                intArr[j + 1] = intArr[j];
                j--;
            }
            intArr[j + 1] = key;
        }
    }

    private void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print ( arr[i] + " " );
        System.out.println ( );
    }
}
