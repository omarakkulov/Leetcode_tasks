package leetcode.easy.trees;

import static leetcode.easy.trees.MaximumSumOfRouteFromRootToLeafBinaryTree.findMaxSumPath;

import leetcode.easy.trees.MaximumSumOfRouteFromRootToLeafBinaryTree.Node;

/**
 * Поиск максимальной суммы из листа к корневому(рутовому) пути.
 */
public class MaximumSumOfRouteFromRootToLeafBinaryTree {


  // Функция для вывода максимальной суммы пути от корня к листу в заданном двоичном дереве.
  public static void findMaxSumPath(Node root) {
    int sum = getRootToLeafSum(root);
    System.out.println("The maximum sum is " + sum);
    System.out.print("The maximum sum path is ");

    printPath(root, sum);
  }

  // Функция для вычисления максимальной суммы от корня к листу в двоичном дереве.
  public static int getRootToLeafSum(Node root) {
    // базовый случай, когда дерево пустое
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    // базовый вариант: текущий узел является конечным узлом
    if (root.left == null && root.right == null) {
      return root.value;
    }

    // вычислить максимальную сумму от узла к конечному элементу для левого дочернего элемента
    int left = getRootToLeafSum(root.left);

    // вычислите максимальную сумму от узла к листу для правого дочернего элемента
    int right = getRootToLeafSum(root.right);

    // рассмотрим максимальную сумму дочернего элемента
    return (Math.max(left, right)) + root.value;
  }

  // Функция для печати пути от корня к листу с заданной суммой в двоичном дереве.
  public static boolean printPath(Node root, int sum) {
    // base case
    if (sum == 0 && root == null) {
      return true;
    }

    // когда рутовый элемент пустой
    if (root == null) {
      return false;
    }

    // повторим для левого и правого поддеревьев с уменьшением суммы
    boolean left = printPath(root.left, sum - root.value);
    boolean right = false;

    if (!left) {
      right = printPath(root.right, sum - root.value);
    }

    // вывести текущий узел, если он лежит на пути с заданной суммой
    if (left || right) {
      System.out.print(root.value + " ");
    }

    return left || right;
  }

  public static class Node {

    int value;
    Node left, right;

    Node(int value) {
      this.value = value;
      left = right = null;
    }
  }
}

class Main {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(8);
    root.left.right = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.left.right.left = new Node(10);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(9);
    root.right.right.right = new Node(5);

    findMaxSumPath(root);
  }
}
