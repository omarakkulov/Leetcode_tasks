package other.single_linked_list;

/**
 * Найти k-тый элемент списка из конца по индексу. Индекс начинается с 1.
 */
public class FindKthElementFromEndOfSingleLinkedList {

  /**
   * Найти ноду из конца списка по индексу. Индекс начинается с 1.
   *
   * @param index индекс
   */
  /*
  public Node<T> findKthFromEnd(int index) {
    if (index < 0) {
      return null;
    }

    Node<T> tmp = head;
    int tailIndex = 0;
    while (tmp.next != null) {
      tmp = tmp.next;
      tailIndex++;
    }

    if (index >= tailIndex + 2) {
      return null;
    }

    Node<T> result = head;
    int resultIndex = tailIndex - index + 1;
    for (int i = 0; i < resultIndex; i++) {
      result = result.next;
    }

    return result;
  }
   */

  /**
   * Второе решение.
   */
  /*
  public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
   */
}
