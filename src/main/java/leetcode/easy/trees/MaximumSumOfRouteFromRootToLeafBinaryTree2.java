package leetcode.easy.trees;

import leetcode.easy.trees.MaximumSumOfRouteFromRootToLeafBinaryTree2.Node;

/**
 * Поиск максимальной суммы из листа к корневому(рутовому) пути.
 */
public class MaximumSumOfRouteFromRootToLeafBinaryTree2 {

  int maxSum;

  class Node {

    Node left;
    Node right;
    int data;
  }

  public void maxSumFromRootToLeaf(Node currentNode, int sum) {
    if (currentNode == null) {
      return;
    }

    if (currentNode.left == null && currentNode.right == null
        && sum + currentNode.data > maxSum) {
      maxSum = sum + currentNode.data;
      return;
    }

    maxSumFromRootToLeaf(currentNode.left, sum + currentNode.data);
    maxSumFromRootToLeaf(currentNode.right, sum + currentNode.data);
  }

  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}

class Main2 {


  public static void main(String[] args) {
    MaximumSumOfRouteFromRootToLeafBinaryTree2 binaryTree = new MaximumSumOfRouteFromRootToLeafBinaryTree2();

    Node root = binaryTree.createNewNode(2);
    root.left = binaryTree.createNewNode(7);
    root.right = binaryTree.createNewNode(5);
    root.left.left = binaryTree.createNewNode(2);
    root.left.right = binaryTree.createNewNode(6);
    root.left.right.left = binaryTree.createNewNode(5);
    root.left.right.right = binaryTree.createNewNode(11);
    root.right.right = binaryTree.createNewNode(9);
    root.right.right.left = binaryTree.createNewNode(4);

    binaryTree.maxSumFromRootToLeaf(root, 0);
    System.out.println(binaryTree.maxSum);
  }
}
