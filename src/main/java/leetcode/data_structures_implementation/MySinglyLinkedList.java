package leetcode.data_structures_implementation;

import lombok.ToString;

/**
 * Реализация односвязного списка.
 */
public class MySinglyLinkedList<T> {

  private Node<T> head;
  private Node<T> tail;
  private int length;

  public MySinglyLinkedList(T value) {
    Node<T> newNode = new Node<T>(value);
    this.head = newNode;
    this.tail = newNode;
    this.length++;
  }

  public void printList() {
    Node<T> tmp = head;
    for (int i = 0; i < length; i++) {
      System.out.printf("Node%s{value=%s}", i + 1, tmp.value);
      System.out.println();
      tmp = tmp.next;
    }
  }

  /**
   * Удалить элемент с хвоста.
   */
  public Node<T> removeLastFirstSolution() {
    if (length == 0) {
      return null;
    }
    Node<T> penultimate = head;
    Node<T> removedNode = null;

    for (int i = 0; i < length; i++) {
      if (penultimate.next == tail) {
        removedNode = tail;
        penultimate.next = null;
        tail = penultimate;
        length--;
        break;
      }
      penultimate = penultimate.next;

      if (length == 1) {
        removedNode = head;
        head = null;
        tail = null;
        length--;
        break;
      }
    }

    return removedNode;
  }

  /**
   * Удалить элемент с хвоста.
   */
  public Node<T> removeLastSecondSolution() {
    if (length == 0) {
      return null;
    }

    Node<T> tmp = head;
    Node<T> prev = head;
    Node<T> removedNode = null;

    for (int i = 0; i < length; i++) {
      if (tmp.next != null) {
        prev = tmp;
        tmp = tmp.next;
      } else {
        removedNode = tail;
        tail = prev;
        tail.next = null;
        length--;
        break;
      }
    }

    return removedNode;
  }

  /**
   * Удалить элемент с хвоста.
   */
  public Node<T> removeLastThirdSolution() {
    if (length == 0) {
      return null;
    }

    Node<T> tmp = head;
    Node<T> prev = head;

    while (tmp.next != null) {
      prev = tmp;
      tmp = tmp.next;
    }
    tail = prev;
    tail.next = null;
    length--;

    if (length == 0) {
      tail = null;
      head = null;
    }

    return tmp;
  }

  /**
   * Добавление элемента в конец.
   */
  public void append(T value) {
    Node<T> newNode = new Node<>(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  /**
   * Добавить элемент в голову.
   */
  public void prepend(T value) {
    Node<T> newNode = new Node<>(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  /**
   * Удалить элемент с головы.
   */
  public Node<T> removeFirst() {
    if (length == 0) {
      return null;
    }
    Node<T> tmp = head;
    head = tmp.next;
    tmp.next = null;
    length--;
    if (length == 0) {
      tail = null;
    }

    return tmp;
  }

  /**
   * Взять элемент по индексу.
   */
  public Node<T> get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node<T> tmp = head;
    for (int i = 0; i < index; i++) {
      tmp = tmp.next;
    }
    return tmp;
  }

  /**
   * Добавить элемент по индексу, поменяв значение в существующем.
   */
  public boolean setFirstSolution(int index, T value) {
    if (index < 0 || index >= length) {
      return false;
    }

    Node<T> tmp = head;
    for (int i = 0; i < index; i++) {
      tmp = tmp.next;
    }
    tmp.value = value;

    return true;
  }

  /**
   * Добавить элемент по индексу, поменяв значение в существующем.
   */
  public boolean setSecondSolution(int index, T value) {
    Node<T> tmp = get(index);
    if (tmp == null) {
      return false;
    }

    tmp.value = value;
    return true;
  }

  /**
   * Вставить ноду в список по индексу, не меняя значение других.
   */
  public boolean insert(int index, T value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
      return true;
    }

    var newNode = new Node<>(value);
    var tmp = get(index - 1);

    newNode.next = tmp.next;
    tmp.next = newNode;
    length++;

    return true;
  }

  /**
   * Удалить элемент по индексу.
   */
  public Node<T> removeByIndex(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    if (index == 0) {
      return removeFirst();
    }

    if (index == length - 1) {
      return removeLastThirdSolution();
    }

    var prev = get(index - 1);
    var current = prev.next;

    prev.next = current.next;
    current.next = null;
    length--;

    return current;
  }

  /**
   * Развернуть список.
   */
  public void reverse() {
    Node<T> tmp = head;
    head = tail;
    tail = tmp;

    Node<T> after = tmp.next;
    Node<T> before = null;
    for (int i = 0; i < length; i++) {
      after = tmp.next;
      tmp.next = before;
      before = tmp;
      tmp = after;
    }
  }

  /**
   * Найти средний элемент в связном списке.
   */
  public Node<T> findMiddleNodeFirstSolution() {
    if (length == 0) {
      return null;
    }

    Node<T> tmp = head;
    int index = length / 2;

    for (int i = 0; i < index; i++) {
      tmp = tmp.next;
    }

    return tmp;
  }

  /**
   * Найти средний элемент в связном списке.
   */
  public Node<T> findMiddleNodeSecondSolution() {
    if (length == 0) {
      return null;
    }

    Node<T> slow = head;
    Node<T> fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public String getHead() {
    return String.format("Head={%s}", head.value);
  }

  public String getTail() {
    return String.format("Tail={%s}", tail.value);
  }

  public String getLength() {
    return String.format("Length={%s}", length);
  }

  @ToString
  private class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }
}

class Runner {

  public static void main(String[] args) {
    MySinglyLinkedList<Integer> linkedList = new MySinglyLinkedList<>(10);
    linkedList.append(20);
    linkedList.append(30);
    linkedList.append(40);
    linkedList.append(50);
//    linkedList.append(60);

    var middleNode = linkedList.findMiddleNodeSecondSolution();
    System.out.println(middleNode);
  }
}
