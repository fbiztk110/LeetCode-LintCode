/* Description
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

//LintCode 104
/*Hard*/
/**
 * MergeKSortedLists23
 */

public class MergeKSortedLists23 {
    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode
     * next; ListNode(int x) { val = x; } }
     */
    static ListNode head1, head2;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return sort(lists, 0, lists.size() - 1);
    }

    public ListNode sort(List<ListNode> lists, int low, int high) {
        if (low >= high) {
            return lists.get(low);
        }
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
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
        // MergeKSortedLists23 lists = new MergeKSortedLists23();
        // lists.head1 = new ListNode(1);
        // lists.head1.next = new ListNode(2);
        // lists.head1.next.next = new ListNode(5);
        // lists.head2 = new ListNode(-1);
        // lists.head2.next = new ListNode(0);
        // lists.head2.next.next = new ListNode(5);
        // List<ListNode> result = lists.mergeKLists(lists);
        // System.out.println("Result List is: ");
        // lists.printList(result);
    }
}