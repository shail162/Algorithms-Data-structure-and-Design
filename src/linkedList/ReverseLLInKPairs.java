package linkedList;

import library.AssortedMethods;
import library.LinkedListNode;

/**
 * https://www.youtube.com/watch?v=bN8nk4ZXzK0
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 *
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:   5->4->3->2->1->8->7->6->NULL.
 *
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseLLInKPairs {

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(4, 1, 10);

        System.out.println(head.printForward());

        LinkedListNode newhead = reverseKgroups(head, 3);
        System.out.println(newhead.printForward());
    }


    public static LinkedListNode reverseKgroups(LinkedListNode head, int k){

        int count = 0;
        LinkedListNode curr = head;
        while (count < k && curr!=null){
            curr = curr.next;
            count++;
        }

        if(count == k){
            System.out.print("push stack " + curr.data + "\n");
            curr = reverseKgroups(curr, k);
            System.out.print("pop stack " + curr.data + "\n");
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                LinkedListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
