package course.week2.programs;

public class Queue {
    Object[] queue;
    private int size;
    private int front;
    private int rear;
    private int limit;

    public Queue(int limit) {
        this.limit = limit;
        queue = new Object[limit];
    }

    public int getLimit() {
        return limit;
    }


    public void enQueue(Object obj) {
        queue[rear] = obj;
        rear = (rear + 1) % limit;
        size++;
    }

    public void deQueue() {
        Object data = queue[front];
        front = (front + 1) % limit;
        size--;
    }

    public void show() {
        for (Object o : queue) {
            System.out.print ( o +"  " );
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return (size () == 0);
    }

}
