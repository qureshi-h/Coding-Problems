import java.util.*;

class FourSum {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int k, l;
        long newTarget, currSum;

        for (int i=0; i < nums.length - 3; i++) {
            if (nums[i + 1] > 0 && nums[i] >= target) break;

            for (int j=i+1; j < nums.length - 2; j++) {
                if (nums[j + 1] > 0 && (long)nums[i] + nums[j] > target) break;

                k = j + 1;
                l = nums.length - 1;
                newTarget = (long)target - nums[i] - nums[j];

                while (k < l) {
                    currSum = nums[k] + nums[l];

                    if (currSum == newTarget) {
                        output.add(Arrays.asList(
                            nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k + 1] == nums[k]) {++k;}
                        while (k < l && nums[l - 1] == nums[l]) {--l;}
                        ++k;
                        --l;
                    }
                    else if (currSum < newTarget) ++k;
                    else --l;

                }
                                
                while(nums[j + 1] == nums[j]  && j < nums.length - 3) ++j;
            }
            
            while(nums[i + 1] == nums[i]  && i < nums.length - 4) ++i;
        }
        
        return output;  
    }
}