package linkedList;

import library.LinkedListNode;

import java.util.Stack;

public class PalindromeLL {

    /**
     * Using stack
     * Time complexity O(n)
     * Space compexity O(n)
     * @param head
     * @return
     */
    public boolean isPalindromeUsingStack(LinkedListNode head){
        LinkedListNode current = head;

        Stack<LinkedListNode> stack = new Stack<>();

        while (current!=null){
            stack.push(current);
            current=  current.next;

        }
        current = head;

        while(!stack.isEmpty() && current!=null){
            if (stack.pop().data != current.data){
                return Boolean.FALSE;
            }
            current = current.next;
        }

        return Boolean.TRUE;
    }



    public boolean isPalindromeByReverse(){
        return true;
    }

    public LinkedListNode getPrevOfMiddleofLL(LinkedListNode head ){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode prev = head;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    /**
     * We can create a new list in reversed order and then compare each node. The time and space are O(n).
     * @param head
     * @return
     */
    public boolean isPalindrome(LinkedListNode head) {
        if(head == null)
            return true;

        LinkedListNode p = head;
        LinkedListNode prev = new LinkedListNode(head.data);

        while(p.next != null){
            LinkedListNode temp = new LinkedListNode(p.next.data);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        LinkedListNode p1 = head;
        LinkedListNode p2 = prev;

        while(p1!=null){
            if(p1.data != p2.data)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
