/* Description
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/

//LintCode 451
/*Easy*/

public class SwapNodesInPairs24 {
    static ListNode head;
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        next = null;
        }
    }
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while(head.next != null && head.next.next != null){
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            //move to next pair
            head = n1;
        }
        return dummy.next;
    }
    void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}
    public static void main(String[] args) {
        SwapNodesInPairs24 res = new SwapNodesInPairs24();
        res.head = new ListNode(1);
        res.head.next = new ListNode(2);
        res.head.next.next = new ListNode(3);
        res.head.next.next.next = new ListNode(4);
        ListNode rs = res.swapPairs(head);
        System.out.println("Result List is: ");
        res.printList(rs);
    }
}
