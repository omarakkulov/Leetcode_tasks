package leetcode.easy;

/**
 * Задача. Определить, является ли число палиндромом. Палиндром - число, которое туда и обратно читается одинаково. 55 - палиндром, 41 - не
 * палиндром.
 * <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(isPalindrome2(515));
  }

  public static boolean isPalindrome1(int x) {
    String tmp = String.valueOf(x);
    return tmp.equals(new StringBuilder(tmp).reverse().toString());
  }

  public static boolean isPalindrome2(int x) {
    char[] chars = String.valueOf(x).toCharArray();

    StringBuilder sb = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      sb.append(chars[i]);
    }

    var expectedInt = Integer.parseInt(sb.toString());

    return expectedInt == x;
  }
}
