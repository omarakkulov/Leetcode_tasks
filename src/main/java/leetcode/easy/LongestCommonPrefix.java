package leetcode.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/description/">Longest Common Prefix</a>
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"a", "aca", "accb", "b"};
    var s = longestCommonPrefix(strs);
    System.out.println(s);
  }

  public static String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();
    Arrays.sort(strs);

    String first = strs[0];
    String last = strs[strs.length - 1];

    int forLoopValue = Math.min(first.length(), last.length());

    for (int i = 0; i < forLoopValue; i++) {
      if (first.charAt(i) != last.charAt(i)) {
        return sb.toString();
      }
      sb.append(first.charAt(i));
    }
    return sb.toString();
  }
}
