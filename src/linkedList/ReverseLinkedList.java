package linkedList;

import library.AssortedMethods;
import library.LinkedListNode;

/**
 * input : 1->2->3-->4
 * output: 4->3->2->1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * https://www.youtube.com/watch?v=CXjQUdAwRSg
 *
 */
public class ReverseLinkedList {

    private static LinkedListNode head;

    public static LinkedListNode reverseIterative(LinkedListNode head){
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }

    /**
     * Reverse in recursive
     * @param current
     * @param prev
     * @return
     */
    public static LinkedListNode reverseRecursive(LinkedListNode current, LinkedListNode prev){

            if(current.next == null) {
                head = current;
                current.next = prev;
                return head;
            }

            LinkedListNode next = current.next;
            current.next = prev;

            reverseRecursive(next, current);
            return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        LinkedListNode newHead = reverseIterative(head);
        System.out.println(newHead.printForward());

        LinkedListNode newHeadR = reverseRecursive(newHead, null);
        System.out.println(newHeadR.printForward());
    }
}
