//package leetcode.easy;
//
//import java.util.Stack;
//
///**
// * <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two Numbers</a>
// */
//public class AddTwoNumbers {
//
//  public static void main(String[] args) {
//    ListNode listNode1 = new ListNode(9,
//        new ListNode(9,
//            new ListNode(9,
//                new ListNode(9,
//                    new ListNode(9,
//                        new ListNode(9,
//                            new ListNode(9, null)))))));
//
//    ListNode listNode2 = new ListNode(9,
//        new ListNode(9,
//            new ListNode(9,
//                new ListNode(9, null))));
//
//    var listNode = addTwoNumbers(listNode1, listNode2);
//    System.out.println(listNode);
//
//  }
//
//  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    long longy1 = getOneLinkedListNodeIntValue(l1);
//    long longy2 = getOneLinkedListNodeIntValue(l2);
//
//    long tmpResult = longy1 + longy2;
//
//    var resultByIntValue = getResultByIntValue(tmpResult);
//
//    return resultByIntValue;
//  }
//
//  /**
//   * Получить число исходя из перебора линкедлиста.
//   */
//  private static long getOneLinkedListNodeIntValue(ListNode incomingNode) {
//    if (incomingNode == null) {
//      throw new IllegalStateException("incomingNode is null");
//    }
//
//    StringBuilder sb = new StringBuilder();
//
//    Stack<Long> stack = new Stack<>();
//
//    ListNode currentNode = incomingNode;
//    while (currentNode != null) {
//      stack.push((long) currentNode.val);
//      currentNode = currentNode.next;
//    }
//
//    while (!stack.isEmpty()) {
//      sb.append(stack.pop());
//    }
//
//    return Long.parseLong(sb.toString());
//  }
//
//  private static ListNode getResultByIntValue(long value) {
//    String strValue = new StringBuilder(String.valueOf(value)).reverse().toString();
//
//    ListNode headNode = null;
//    ListNode tmpNode = null;
//
//    for (char ch : strValue.toCharArray()) {
//      int tmp = Integer.parseInt(String.valueOf(ch));
//
//      ListNode newNode = new ListNode(tmp, null);
//
//      if (headNode == null) {
//        headNode = newNode;
//        tmpNode = headNode;
//      } else {
//        tmpNode.next = newNode;
//        tmpNode = newNode;
//      }
//    }
//
//    return headNode;
//  }
//
//  private static class ListNode {
//
//    int val;
//    ListNode next;
//
//    ListNode(int val, ListNode next) {
//      this.val = val;
//      this.next = next;
//    }
//  }
//
//}
