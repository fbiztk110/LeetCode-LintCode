/* Description
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

//LintCode 165
/*Easy*/
import java.util.*;
public class MergeTwoSortedLists21{
    /**
     * Definition for ListNode
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static ListNode head1, head2;
    static class ListNode{
        int val; 
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}
    public static void main(String[] args) {
        MergeTwoSortedLists21 res = new MergeTwoSortedLists21();
        res.head1 = new ListNode(1);
        res.head1.next = new ListNode(2);
        res.head1.next.next = new ListNode(2);
        res.head2 = new ListNode(1);
        res.head2.next = new ListNode(4);
        res.head2.next.next = new ListNode(5);
        ListNode rs = res.mergeTwoLists(head1, head2);
        System.out.println("Result List is: ");
        res.printList(rs);
    }
}
