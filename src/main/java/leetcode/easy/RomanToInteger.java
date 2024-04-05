package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/description/">Roman To Integer</a>
 */
public class RomanToInteger {

  public static void main(String[] args) {
    var lviii = romanToInt("LVIII");
    System.out.println(lviii);
  }

  public static int romanToInt(String s) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);

    Set<String> set = new HashSet<>();
    set.add("I");
    set.add("X");
    set.add("C");

    var chars = s.toCharArray();

    boolean isNextElementRelatedToCurrent = false;
    int result = 0;

    for (int i = 0; i < chars.length; i++) {
      if (isNextElementRelatedToCurrent) {
        isNextElementRelatedToCurrent = false;
        continue;
      }

      var key = String.valueOf(chars[i]);

      if (map.containsKey(key)) {
        if (set.contains(key)) {
          String nextElement;
          try {
            nextElement = String.valueOf(chars[i + 1]);
          } catch (ArrayIndexOutOfBoundsException e) {
            result += map.get(key);
            break;
          }

          isNextElementRelatedToCurrent = isNextElementRelatedToCurrent(key, nextElement);
          if (isNextElementRelatedToCurrent) {
            result += map.get(key + nextElement);
            continue;
          }
        }
        result += map.get(key);
      }
    }

    return result;
  }

  private static boolean isNextElementRelatedToCurrent(String currentElement, String nextElement) {
    switch (currentElement) {
      case "I": {
        if (nextElement.equals("V") || nextElement.equals("X")) {
          return true;
        }
        break;
      }
      case "X": {
        if (nextElement.equals("L") || nextElement.equals("C")) {
          return true;
        }
        break;
      }
      case "C": {
        if (nextElement.equals("D") || nextElement.equals("M")) {
          return true;
        }
        break;
      }
      default:
        throw new RuntimeException();
    }
    return false;
  }
}
