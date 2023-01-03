package leetcode.easy;

/**
 * @link https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(isPalindrome(55));
  }

  public static boolean isPalindrome(int x) {
    String tmp = String.valueOf(x);
    return tmp.equals(new StringBuilder(tmp).reverse().toString());
  }
}
