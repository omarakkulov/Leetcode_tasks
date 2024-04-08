package leetcode.easy;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 */
public class ValidParentheses {

  public static void main(String[] args) {
    boolean isValid = isValid("([][])");
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    var chars = s.toCharArray();

    for (char aChar : chars) {
      if (aChar == '(') {
        stack.push(')');
      } else if (aChar == '{') {
        stack.push('}');
      } else if (aChar == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != aChar) {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
