package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел так, если их содержимое по индексу в сумме даст
 * значение=target.
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum Task</a>
 */
public class TwoSum {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(twoSum2(new int[]{1, 3, 6}, 7)));
  }

  public static int[] twoSum1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    throw new RuntimeException("cannot find numbers to solution");
  }

  public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int[] resultArr = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        resultArr[0] = map.get(target - nums[i]);
        resultArr[1] = i;
      } else {
        map.put(nums[i], i);
      }
    }

    return resultArr;
  }

}
