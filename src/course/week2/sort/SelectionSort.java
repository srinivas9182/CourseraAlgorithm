package course.week2.sort;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort ( );
        int[] intArr = {9, 4, 7, 1, 5, 4};
        ss.printArr ( intArr );
        ss.selectionSort ( intArr );
        ss.printArr ( intArr );

    }

    private void selectionSort(int[] intArr) {
        int len = intArr.length;

        for (int i = 0; i < len - 1; i++) {

            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (intArr[j] < intArr[min]) {
                    min = j;
                }
                int temp = intArr[min];
                intArr[min] = intArr[i];
                intArr[i] = temp;
            }

        }
    }

    private void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print ( arr[i] + " " );
        System.out.println ( );
    }
}

