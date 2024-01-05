public class SearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(
        new SearchRotatedArray().search(new int[]{3, 1}, 3));
    }
    
    public int search(int[] nums, int target) {
        if (nums.length > 1 && nums[0] >= nums[nums.length - 1]) {
            int split = findSplit(nums);

            System.out.printf("split: %d\n", split);

            if (split > 0) {
                int result = binarySearch(nums, 0, split, target);
                if (result >= 0)
                    return result;
                return binarySearch(nums, split, nums.length, target);
            }
        }

        return binarySearch(nums, 0, nums.length, target);
    }
    
    private int findSplit(int[] nums) {
        
        int mid, m = 0, n = nums.length;
        
        while (m < n) {
            mid = (m + n) / 2;
            System.out.println(mid);
            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[m]) {
                m = mid;
            }
            else {
                n = mid;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int m, int n, int target) {

        int mid;
        System.out.println("call");
        
        while (m < n) {
            mid = (m + n) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid]< target) {
                m = mid + 1;
            }
            else {
                n = mid;
            }
        }
        return -1;
    }
}
