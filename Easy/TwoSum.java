/**
 * solution to https://leetcode.com/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    /*
    Given an array of integers nums and an integer target,
    returns the indices of the two numbers such that they add up to target.
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        Object index;
        for (int i = 0; i < nums.length; i++) {
            if ((index = hashMap.get(target - nums[i])) != null)
                return new int[]{i, (int)index};
            hashMap.put(nums[i], i);
        }
        return null;
    }
}