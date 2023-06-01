package leetcode.easy;

public class Factorial {

  public static void main(String[] args) {
    System.out.println(factorialRecursion(4));
//    System.out.println(factorialLoop(4));
  }

  /**
   * Факториал числа с рекурсией.
   */
  private static int factorialRecursion(int n) {
    if (n == 1) {
      return 1;
    }

    return n * factorialRecursion(n - 1);
  }

  /**
   * Факториал в цикле.
   */
  private static int factorialLoop(@SuppressWarnings("SameParameterValue") int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}
