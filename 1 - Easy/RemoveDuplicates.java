/* solution to https://leetcode.com/problems/remove-duplicates-from-sorted-array/ */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int truePos = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[truePos] = nums[i];
                ++truePos;   
            }
        }

        return truePos;
    }
    
    
}
