package leetcode.easy.single_linked_list;

import leetcode.data_structures_implementation.linked_list.OneLinkedList;

/**
 * Найти средний элемент(то есть по центру) в односвязном списке.
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/description/">Middle Element Of The Linked List</a>
 */
public class MiddleElementOfTheSingleLinkedList {

  /**
   * Найти средний элемент в связном списке, учитывая, что чья-то реализация списка имеет внутри класса поле length, где хранится количество
   * элементов в списке. Смотреть класс {@link OneLinkedList}.
   */
//  public Node<T> findMiddleNodeFirstSolution() {
//    if (length == 0) {
//      return null;
//    }
//
//    Node<T> tmp = head;
//    int index = length / 2;
//
//    for (int i = 0; i < index; i++) {
//      tmp = tmp.next;
//    }
//
//    return tmp;
//  }
//
///////////////////////////////////////////////////////////

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
//  class Solution {
//    public ListNode middleNode(ListNode head) {
//      ListNode slow = head;
//      ListNode fast = head;
//
//      while(fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//      }
//
//      return slow;
//    }
//  }
}
