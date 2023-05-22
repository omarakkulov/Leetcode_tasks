package leetcode.easy;

/**
 * Задача. Определить, является ли число палиндромом.
 * Палиндром - число, которое туда и обратно читается одинаково. 55 - палиндром, 41 - не палиндром.
 * <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
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
