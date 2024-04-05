package other.single_linked_list;

import java.util.Iterator;

public class ReverseSingleLinkedList<T> implements Iterable<T> {

  public static void main(String[] args) {
    ReverseSingleLinkedList<Integer> integerList = new ReverseSingleLinkedList<>();
    integerList.add(1);
    integerList.add(2);
    integerList.add(3);
    integerList.add(4);

    integerList.forEach(System.out::println);

    integerList.reverse();

    System.out.println("------------------------");
    integerList.forEach(System.out::println);
  }

  private Node<T> head;
  private Node<T> tail;

  /**
   * Развернуть список.
   */
  public void reverse() {
    if (!isEmpty() && head.next != null) {
      tail = head;
      Node<T> current = head.next;
      head.next = null;

      while (current != null) {
        Node<T> next = current.next;
        current.next = head;
        head = current;
        current = next;
      }
    }
  }

  public void add(T value) {
    Node<T> newNode = new Node<>(value);
    if (head == null) {
      head = newNode;
      head.next = null;
      tail = head;
    }

    tail.next = newNode;
    tail = newNode;
  }

  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        var value = current.value;
        current = current.next;
        return value;
      }
    };
  }

  private static class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }
}
