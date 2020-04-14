package course.week2.sort;

public class ShuffleArray {

    public static void main(String[] args) {
        ShuffleArray sa = new ShuffleArray ( );
        String[] strArr = {"A", "B", "C", "D", "E", "F"};
        System.out.println ( "before sort:     " );
        sa.printArr ( strArr );
        System.out.println ( "" );
        sa.shuffle ( strArr );
        System.out.println ( "after sort:     " );
        sa.printArr ( strArr );
    }

    private void shuffle(Object[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            int rand = i + (int) (Math.random ( ) * (length - i));
            Object temp = strArr[rand];
            strArr[rand] = strArr[i];
            strArr[i] = temp;
        }
    }

    private void printArr(Object arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print ( arr[i] + " " );
        System.out.println ( );
    }
}
