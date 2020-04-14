package course.week2.sort;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort ss = new ShellSort ( );
        int[] intArr = {9, 43, 123, 65, 34, 68, 34, 78, 30, 70, 110};
        System.out.println ( "before sort:   " );
        ss.printArr ( intArr );
        ss.shellSort ( intArr );
        System.out.println ( "" );

        System.out.println ( "after sort:   " );
        ss.printArr ( intArr );
    }

    private void shellSort(int[] intArr) {
        int length = intArr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int key = intArr[i];
                int j = i;
                while (j >= gap && intArr[j - gap] > key) {
                    intArr[j] = intArr[j - gap];
                    j -= gap;
                }
                intArr[j] = key;
            }
        }
    }

    private void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print ( arr[i] + " " );
        System.out.println ( );
    }
}
