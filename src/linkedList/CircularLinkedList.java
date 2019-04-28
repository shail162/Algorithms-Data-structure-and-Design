package linkedList;

import library.LinkedListNode;

public class CircularLinkedList {

    public static void main(String args[]){

        LinkedListNode node = new LinkedListNode(10);

        LinkedListNode head = node;
       // node.next = node;

        node.next = new LinkedListNode(15);


        node.next.next = new LinkedListNode(20);
        node.next.next.next = new LinkedListNode(30);
        node.next.next.next.next = new LinkedListNode(40);
        node.next.next.next.next.next = new LinkedListNode(50);

        LinkedListNode tail = node.next.next.next.next.next;
        tail.next = head;

        head = deleteNode(head,10);
        printCircularLL(head);
    }

    public static void printCircularLL(LinkedListNode head) {
        LinkedListNode curr = head;
        LinkedListNode prev = curr;

        while (curr!=null && prev.next!=head){
            System.out.println(curr.data);
            prev = curr;
            curr = curr.next;
        }
    }

    public static LinkedListNode deleteNode(LinkedListNode head, int data){

        if (head == null){
            return null;
        }

        LinkedListNode curr = head;
        LinkedListNode prev = curr;

        if (head == head.next && head.data == data){
            System.out.println("List has only 1 node");
            return null;
        }

        while (curr!=null && prev.next!=head){

            //if node to delete found
            if(curr.data == data){
                if (curr == head){ // 1. if node to delete is head of linked list
                    LinkedListNode tail = findTail(curr);
                    curr = curr.next;
                    head = curr;
                    tail.next = head;
                } else  if (curr.next == head){ //2. if node to delete is tail of linked list
                    prev.next = head;
                } else {        // 3.middle node
                    prev.next = curr.next;
                }

                return head;
            }

            prev = curr;
            curr = curr.next;

        }

        return head;
    }

    private static LinkedListNode findTail(LinkedListNode head){
        LinkedListNode curr = head;

        while (curr!=null && curr.next!=head){
            curr = curr.next;
        }

        return curr;
    }

}
