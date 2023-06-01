package leetcode.data_structures_implementation.trees;

import leetcode.data_structures_implementation.trees.RecursiveBST.Node;

/**
 * Рекурсивная реализация методов бинарного дерева поиска.
 */
public class RecursiveBST {

  Node root;

  public boolean contains(int value) {
    return contains(root, value);
  }

  /**
   * Рекурсивная проверка на то, что дерево содержит указанный элемент.
   */
  private boolean contains(Node currentNode, int value) {
    if (currentNode == null) {
      return false;
    }

    if (value < currentNode.value) {
      return contains(currentNode.left, value);
    } else if (value > currentNode.value) {
      return contains(currentNode.right, value);
    } else {
      return true;
    }
  }

  public Node insert(int value) {
    return insert(root, value);
  }

  /**
   * Добавить новый элемент в дерево.
   */
  private Node insert(Node currentNode, int value) {
    if (currentNode == null) {
      currentNode = new Node(value);
      return currentNode;
    }

    if (value < currentNode.value) {
      currentNode.left = insert(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = insert(currentNode.right, value);
    } else {
      return null;
    }

    return currentNode;
  }

  public void deleteNode(int value) {
    deleteNode(root, value);
  }

  /**
   * Удалить элемент из дерева.
   */
  private Node deleteNode(Node currentNode, int value) {
    if (currentNode == null) {
      return null;
    }

    if (value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
    } else {
      if (currentNode.left == null && currentNode.right == null) {
        return null;
      } else if (currentNode.left == null) {
        currentNode = currentNode.right;
      } else if (currentNode.right == null) {
        currentNode = currentNode.left;
      } else {
        int subTreeMin = findMinimumValue(currentNode.right);
        currentNode.value = subTreeMin;
        currentNode.right = deleteNode(currentNode.right, subTreeMin);
      }
    }

    return currentNode;
  }

  /**
   * Найти минимальный элемент в дереве относительно данной ноды.
   */
  private int findMinimumValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }

  public static class Node {

    public Node(int value) {
      this.value = value;
    }

    int value;
    RecursiveBST.Node left;
    RecursiveBST.Node right;

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

class RBSTRunner {

  public static void main(String[] args) {
    RecursiveBST recursiveBST = new RecursiveBST();
    recursiveBST.root = new Node(10);
//    recursiveBST.root.left = new Node(5);
//    recursiveBST.root.left.right = new Node(7);
//    recursiveBST.root.right = new Node(19);
//    recursiveBST.insert(20);
//    recursiveBST.insert(25);
//    recursiveBST.insert(5);
//    recursiveBST.insert(9);
    recursiveBST.insert(7);
    recursiveBST.insert(4);

    recursiveBST.deleteNode(4);
    System.out.println();
  }
}
