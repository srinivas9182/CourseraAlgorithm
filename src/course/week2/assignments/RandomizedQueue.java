package course.week2.assignments;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

// implenting RandomizedQueue by resize array

public class RandomizedQueue< Item > implements Iterable < Item > {
    private static final int START_MAX = 10;
    private static Random random = new Random ( );
    private Item[] resizingArray;
    private int numberOfItems;
    private int max;

    public RandomizedQueue() {
        this.numberOfItems = 0;
        this.max = RandomizedQueue.START_MAX;
        this.resizingArray = (Item[]) new Object[this.max];
    }

    public static void main(String[] args) {

        RandomizedQueue < Integer > rq = new RandomizedQueue < Integer > ( );

        for (int i = 0; i < 10; i++) {
            rq.enqueue ( i );
        }


        System.out.println ( "items: " + rq.numberOfItems );

        rq.show ( );

        System.out.println ( rq.dequeue ( ) );
        System.out.println ( rq.dequeue ( ) );
        System.out.println ( rq.dequeue ( ) );

        //System.out.println(rq.to`String());
        System.out.println ( "items: " + rq.numberOfItems );

        Iterator it1 = rq.iterator ( );
        Iterator it2 = rq.iterator ( );

        while (it1.hasNext ( )) {
            System.out.print ( it1.next ( ) );
        }
        System.out.println ( "\n" );
        while (it2.hasNext ( )) {
            System.out.print ( it2.next ( ) );
        }


    }

    private void show() {
        Arrays.stream ( resizingArray ).forEach ( System.out::print );
        System.out.println ( "" );
    }

    public boolean isEmpty() {
        return this.numberOfItems == 0;
    }


    public int size() {
        return this.numberOfItems;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException ( );
        }

        if (this.numberOfItems == this.max) {   //resize array to double the size
            this.max = this.max * 2;
            this.resizingArray = this.createNewArray ( this.max );
        }

        this.resizingArray[numberOfItems++] = item;
    }

    /**
     * Removes a random element from the randomized queue
     *
     * @return Item that is removed
     */
    public Item dequeue() {
        if (this.isEmpty ( )) {
            throw new NoSuchElementException ( );
        }
        int rand = random.nextInt ( this.numberOfItems );
        while (this.resizingArray[rand] == null) {
            rand = random.nextInt ( this.numberOfItems );
        }
        Item toRemove = this.resizingArray[rand];
        this.resizingArray[rand] = null;    //mark that value as null
        this.numberOfItems--;
        if (this.fractionOccupied ( ) < 0.25f) {  //resize to half
            this.max = this.max / 2;
            this.resizingArray = this.createNewArray ( this.max );
        }
        return toRemove;
    }

    private Item[] createNewArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        int oldSize = this.resizingArray.length;

        int j = 0;
        for (int i = 0; i < oldSize; i++) {
            if (j == newSize) {
                break;
            }
            if (this.resizingArray[i] != null) {
                newArray[j++] = this.resizingArray[i];
            }
        }
        //System.arraycopy(newArray, 0, this.resizingArray, 0, newSize);
        return newArray;
    }

    /**
     * Helper method to identify the portion of the array occupied
     *
     * @return what fraction of the array is occupied
     */
    private float fractionOccupied() {
        float M = (float) this.max;
        float C = (float) this.numberOfItems;

        return C / M;
    }

    public Item sample() {
        if (this.isEmpty ( )) {
            throw new NoSuchElementException ( );
        }

        int rand = random.nextInt ( this.numberOfItems );
        while (this.resizingArray[rand] == null) {
            rand = random.nextInt ( this.numberOfItems );
        }

        return this.resizingArray[rand];
    }

    public Iterator < Item > iterator() {
        return new RandomizedQueueIterator ( );
    }


    private class RandomizedQueueIterator implements Iterator < Item > {
        private Item[] itemIt;
        private int itemsLeft;

        public RandomizedQueueIterator() {
            itemIt = (Item[]) new Object[numberOfItems];
            this.constructIterator ( );
            this.itemsLeft = numberOfItems;
        }

        private void constructIterator() {
            int j = 0;
            for (int i = 0; i < max; i++) {
                if (j == numberOfItems) {
                    break;
                }   //not sure if added check reqd
                if (resizingArray[i] != null) {
                    this.itemIt[j++] = resizingArray[i];
                }
            }
        }

        public boolean hasNext() {
            return this.itemsLeft != 0;
        }

        public void remove() {
            throw new UnsupportedOperationException ( );
        }

        public Item next() {
            if (!this.hasNext ( )) {
                throw new NoSuchElementException ( );
            } else {
                int rand = random.nextInt ( this.itemIt.length );

                while (itemIt[rand] == null) {
                    rand = random.nextInt ( this.itemIt.length );
                }

                Item elem = itemIt[rand];
                itemIt[rand] = null;
                this.itemsLeft--;

                return elem;
            }
        }
    }


}