package leetcode.easy.single_linked_list;

/**
 * Существует ли цикл в связном списке.
 * <a href="https://leetcode.com/problems/linked-list-cycle/">https://leetcode.com/problems/linked-list-cycle/</a>
 */
public class LoopInSingleLinkedList {

//  public boolean hasCycle(ListNode head) {
//    ListNode slow = head;
//    ListNode fast = head;
//
//    if (fast == null || fast.next == null) {
//      return false;
//    }
//
//    while (true) {
//      fast = fast.next;
//      if (fast == slow) {
//        return true;
//      }
//      if (fast == null) {
//        return false;
//      }
//
//      slow = slow.next;
//      fast = fast.next;
//      if (fast == slow) {
//        return true;
//      }
//      if (fast == null) {
//        return false;
//      }
//    }
//  }
}
