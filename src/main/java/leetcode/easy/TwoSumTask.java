package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел так, если их содержимое по индексу в сумме даст
 * значение=target.
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum Task</a>
 */
public class TwoSumTask {

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

    throw new RuntimeException();
  }


  public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] resultArray = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        resultArray[0] = map.get(target - nums[i]);
        resultArray[1] = i;
      }
      map.put(nums[i], i);
    }

    return resultArray;
  }
}
