package javaNew.prodconsumer;

import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add( item);
    }

    public synchronized Object dequeue()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }


    public static void main(String args[]) {
        BlockingQueue queue = new BlockingQueue(5);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 4; i++) {
                    try {
                        queue.enqueue(i);
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println("enqueue : " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Integer val = (Integer) queue.dequeue();
                        System.out.println("dequeue" + val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
