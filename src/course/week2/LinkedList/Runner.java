package course.week2.LinkedList;

public class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList ( );
        list.insert ( 10 );
        list.insert ( 20 );
        list.insert ( 30 );
        list.insert ( 40 );

        list.inserAtStart ( 222 );

        list.insertAt ( 0, 289 );
        list.insertAt ( 10, 289 );
        list.deleteAt ( 13 );
        list.deleteAt ( 3 );

        list.show ( );
        System.out.println ( "size:   "+list.size ( ) );

    }
}
