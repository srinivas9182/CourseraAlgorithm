package course.week2.assignments;


/**
 * @author Srinivas Kouru
 * <p>
 * Coursera: Algorithms 1
 * Assignment 2: Randomized Queues and Deques
 * <p>
 * Deque.java
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class Deque< Item > implements Iterable < Item > {

    private Node first;
    private Node last;
    private Integer itemsCount;

    public Deque() {
        this.first = null;
        this.last = null;
        this.itemsCount = 0;
    }

    public static void main(String[] args) {
        Deque < Integer > que = new Deque < Integer > ( );
        System.out.println ( "que size at innitial:  " + que.size ( ) );
        System.out.println ( "is que empty  " + que.isEmpty ( ) );

        que.addFirst ( 2 );
        que.addLast ( 5 );
        que.addFirst ( 1 );
        que.addLast ( 9 );
        que.show ();

        que.removeFirst ();
        que.show ();
        que.removeLast ();
        que.show ();

        Iterator itr = que.iterator();

        while (itr.hasNext ()){
            System.out.println ( itr.next () );
        }
        System.out.println ( "que size at last:  " + que.size ( ) );
        System.out.println ( "is que empty  at last:  " + que.isEmpty ( ) );

    }
    public Integer size() {
        return this.itemsCount;
    }

    public Boolean isEmpty() {
        return (size ( ) == null || size ( ) == 0);
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException ( );
        }

        if (this.isEmpty ( )) {
            this.first = new Node ( item );
            this.last = this.first;
        } else {
            Node node = new Node ( item );
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        }
        this.itemsCount++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException ( );
        }
        if (this.isEmpty ( )) {
            this.last = new Node ( item );
            this.first = last;
        } else {
            Node node = new Node ( item );
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        this.itemsCount++;
    }

    public Item removeFirst() {
        if (this.isEmpty ( )) {
            throw new NoSuchElementException ( );
        }
        Node node = this.first;
        if (size ( ) == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first.next.prev = null;
            this.first = this.first.next;
        }
        this.itemsCount--;
        node.next = null;
        return node.item;
    }

    public Item removeLast() {

        if (this.isEmpty ( )) {
            throw new NoSuchElementException ( );
        }
        Node node = this.last;
        if (this.size ( ) == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.last.prev.next = null;
            this.last = this.last.prev;
        }
        this.itemsCount--;
        node.next = null;
        return node.item;
    }

    @Override
    public Iterator < Item > iterator() {
        return new DequeIterator ( );
    }


    private class DequeIterator implements Iterator < Item > {
        private Node current;

        public DequeIterator() {
            this.current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!this.hasNext ( )) {
                throw new NoSuchElementException ( );
            } else {
                Node node = current;
                current = current.next;
                return node.item;
            }
        }
    }

    public void show(){
        Node node = this.first;
        while(node.next !=null){
            System.out.print ( node.item +" ");
            node = node.next;
        }
        System.out.print ( node.item +" ");
        System.out.println ( "" );
    }

    private class Node {
        private Item item;
        private Node next;
        private Node prev;

        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }


}
