package javaNew;

import java.util.*;

/**
 * BlockingQueue interface in Java is added in Java 1.5 along with various other concurrent Utility classes like ConcurrentHashMap,
 * Counting Semaphore, CopyOnWriteArrrayList etc. BlockingQueue interface supports flow control (in addition to queue)
 * by introducing blocking if either BlockingQueue is full or empty. A thread trying to enqueue an element in a
 * full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more element
 * or clearing the queue completely. Similarly it blocks a thread trying to delete from an empty queue until some other treads
 * inserts an item. BlockingQueue does not accept null value. If we try to enqueue null item,
 * then it throws NullPointerException.
 */
public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit = 10;

    public BlockingQueue(int limit)
    {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item)
            throws InterruptedException
    {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add((String)item);
    }

    public synchronized Object dequeue()
            throws InterruptedException
    {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }
}
