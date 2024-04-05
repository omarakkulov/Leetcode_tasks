package other.trees;

import lombok.AllArgsConstructor;

/**
 * Инвертировать бинарное дерево.
 * <a href="https://leetcode.com/problems/palindrome-number/">Invert Binary Tree</a>
 */
public class InvertBinaryTree {

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.of(4);

    treeNode.left = TreeNode.of(2);
    treeNode.left.left = TreeNode.of(1);
    treeNode.left.right = TreeNode.of(3);

    treeNode.right = TreeNode.of(7);
    treeNode.right.right = TreeNode.of(9);
    treeNode.right.left = TreeNode.of(6);

    var treeNode1 = invertTree(treeNode);
    System.out.println(treeNode1);
  }


  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  @AllArgsConstructor
  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    public static TreeNode of(int value) {
      return new TreeNode(value);
    }
  }
}
