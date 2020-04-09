package course.week2.programs;

/*   Implementing Queue using Array*/

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue ( 10 );
        for (int i = 0; i < 10; i++) {
            queue.enQueue ( i );
        }
        queue.show ( );
        System.out.println ( "size:   " + queue.size ( ) );
        System.out.println ( "is empty:   " + queue.isEmpty ( ) );

        System.out.println ( "after remove " );

        for (int i = 0; i < 5; i++) {
            queue.deQueue ( );
        }
        queue.show ( );
        System.out.println ( "size:   " + queue.size ( ) );
        System.out.println ( "is empty:   " + queue.isEmpty ( ) );
    }
}
