package leetcode.data_structures_implementation.trees;


/**
 * Бинарное дерево поиска.
 */
public class BinarySearchTree {

  Node root;

  /**
   * Вставить значение в бинарное дерево поиска.
   */
  public Node insert(int incomingValue) {
    Node newNode = new Node(incomingValue);
    if (root == null) {
      root = newNode;
      return root;
    }

    Node temp = root;
    while (true) {
      if (newNode.value == temp.value) {
        return null;
      }

      if (newNode.value < temp.value) {
        if (temp.left == null) {
          temp.left = newNode;
          return newNode;
        }
        temp = temp.left;
      } else {
        if (temp.right == null) {
          temp.right = newNode;
          return newNode;
        }
        temp = temp.right;
      }
    }
  }

  /**
   * Вставить значение в бинарное дерево поиска.
   */
  public boolean booleanInsert(int incomingValue) {
    // сначала создаем новый добавляемый объект ноды
    Node newNode = new Node(incomingValue);

    // проверяем, что рутовый элемент пустой
    if (root == null) {
      root = newNode;
      return true;
    }

    // создаем временную переменную для итерации по дереву в цикле
    Node temp = root;
    while (true) {
      // если добавляемый элемент равен значению временного, то false
      if (newNode.value == temp.value) {
        return false;
      }

      // если добавляемый элемент меньше временного
      if (newNode.value < temp.value) {
        // если у временного элемента отсутствует левый
        if (temp.left == null) {
          temp.left = newNode;
          return true;
        }
        // иначе перескакиваем на левый элемент
        temp = temp.left;
        //иначе если добавляемый элемент больше временного
      } else {
        // если у временного элемента отсутствует правый
        if (temp.right == null) {
          temp.right = newNode;
          return true;
        }
        // иначе перескакиваем на правый элемент
        temp = temp.right;
      }
    }
  }

  /**
   * Проверка на то, что дерево содержит указанный элемент.
   */
  public boolean contains1(int incomingValue) {
    if (root == null) {
      return false;
    }

    Node temp = root;
    while (true) {
      if (incomingValue == temp.value) {
        return true;
      }

      if (incomingValue < temp.value) {
        if (temp.left == null) {
          return false;
        }
        temp = temp.left;
        if (temp.value == incomingValue) {
          return true;
        }
      } else {
        if (temp.right == null) {
          return false;
        }
        temp = temp.right;
        if (temp.value == incomingValue) {
          return true;
        }
      }
    }
  }

  /**
   * Проверка на то, что дерево содержит указанный элемент.
   */
  public boolean contains2(int incomingValue) {
    Node temp = root;
    while (temp != null) {
      if (incomingValue < temp.value) {
        temp = temp.left;
      } else if (incomingValue > temp.value) {
        temp = temp.right;
      } else {
        return true;
      }
    }
    return false;
  }

  private static class Node {

    public Node(int value) {
      this.value = value;
    }

    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
      return "Node{"
          + "value=" + value
          + ", left=" + left
          + ", right=" + right
          + '}';
    }
  }
}

class BstRunner {

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(10);
    binarySearchTree.insert(20);
    binarySearchTree.insert(5);
    binarySearchTree.insert(4);
    binarySearchTree.insert(6);
    binarySearchTree.insert(58);
    binarySearchTree.insert(8);
    binarySearchTree.insert(9);
    binarySearchTree.insert(30);

    var contains = binarySearchTree.contains1(1);

    System.out.println(binarySearchTree);
    System.out.println(contains);
  }
}
