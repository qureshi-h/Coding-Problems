/**
 * solution to https://leetcode.com/problems/first-missing-positive/
 */

class FirstMissingPositive {


    public static void main(String[] args) {
        
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0, 4, 3, 6}));
    }
    public int firstMissingPositive(int[] nums) {
        int max = nums.length + 1;
        int number;
        
        for (int i = 0; i < nums.length;) {
            number = nums[i];
            if (number > 0 && number < max) {
                if (number - 1 == i || nums[number - 1] == number) {  // number already at correct place
                    i++;
                } 
                else {
                    nums[i] = nums[number - 1];
                    nums[number - 1] = number;
                }
                
            }
            else {
                i++;
            }
        }

        for (int i = 1; i < max; i++) {
            if (nums[i - 1] != i)
                return i;
        }
        return max; 
    }
}