/*solution to https://leetcode.com/problems/remove-element/ */

public class RemoveElement {
    
    public int removeElement(int[] nums, int val) {
        int truePos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[truePos] = nums[i];
                ++truePos;   
            }
        }

        return truePos;
    }
}
