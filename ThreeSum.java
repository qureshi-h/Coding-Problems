/*
solution to https://leetcode.com/problems/3sum/
*/

import java.util.*;
import java.util.stream.Collectors;

/*
Given an integer array nums, returns all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
*/
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> outList = new ArrayList<>();
        int firstPositive;

        Arrays.sort(nums);
        if ((firstPositive = findFirstPositive(nums)) == -1) {
            return outList;
        }

        System.out.println(Arrays.toString(nums));
        findTriplets(nums, outList, firstPositive);

        if (firstPositive + 2 < nums.length && nums[firstPositive] == 0 &&
                nums[firstPositive + 1] == 2 && nums[firstPositive + 2] == 0) {
            outList.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        }

        return outList.stream().distinct().collect(Collectors.toList());
    }

    private int findFirstPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        return -1;
    }

    private void findTriplets(int[] nums, List<List<Integer>> outList, int firstPositive) {
        int i, j, k;
        for (i = 0; i < firstPositive; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) k--;
                else if (nums[i] + nums[j] + nums[k] < 0) j++;
                else {
                    outList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                }
            }
        }
    }
}
