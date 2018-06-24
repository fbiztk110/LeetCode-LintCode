/* Description:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807. 

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.*/

//LintCode 167
/*Medium*/
/**
 * Definition for singly-linked list. 
 * public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
import java.*;
class AddTwoNumbers2 {
    static ListNode head1, head2;
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNums(l1, l2, 0);
    }

    public ListNode addTwoNums(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        int sum = 0;
        if(l1 != null){
            sum += l1.val;
        }
        if(l2 != null){
            sum += l2.val;
        }
        sum += carry;
        ListNode current = new ListNode(sum % 10);
        if(l1 == null && l2 == null){
            current.next = addTwoNums(null,null,sum / 10);
        }else if(l1 == null){
            current.next = addTwoNums(null, l2.next, sum / 10);
        }else if(l2 == null){
            current.next = addTwoNums(l1.next, null, sum / 10);
        }else{
            current.next = addTwoNums(l1.next, l2.next, sum / 10);
        }
        return current;
    }
    /* Utility function to print a linked list */

	void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}
    public static void main(String[] args) {
        AddTwoNumbers2 res = new AddTwoNumbers2();
        
        res.head1 = new ListNode(7);
        res.head1.next = new ListNode(2);
        res.head1.next.next = new ListNode(2);
        res.head2 = new ListNode(2);
        res.head2.next = new ListNode(2);
        res.head2.next.next = new ListNode(2);
        System.out.print("First list is: ");
        res.printList(head1);
        System.out.print("Second list is: ");
        
        res.printList(head2);
        ListNode rs = res.addTwoNumbers(head1, head2);
        System.out.print("Result List is: ");
        res.printList(rs);
    } 
}