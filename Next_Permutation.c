/*
solution to https://leetcode.com/problems/next-permutation/
*/

/*
Rearranges numbers into the lexicographically next greater permutation of numbers
100 % / 100%
*/
void nextPermutation(int* nums, int numsSize){
    
    int i = numsSize - 2, pos = -1;
    
    if (i < 0) return;
    while ((pos = find_pos(nums, numsSize, i)) == -1 && i > 0) {
        i--;
    }

    if ((pos != -1)) {
        swap(nums, i, pos);
        i++;
    } 
    reverse_array(nums + i, numsSize - i);
    
    
}

int find_pos(int* nums, int length, int i) {
    
    for (int j = length - 1; j > i; j--) {
        if (nums[j] > nums[i]) {
            return j;
        }
    }
    return -1;
}

void swap(int* nums, int p1, int p2) {
    int temp = nums[p1];
    nums[p1] = nums[p2];
    nums[p2] = temp;
}

void reverse_array(int* nums, int length) {
    int j = length / 2;
    for (int i = 0; i < j; i++) {
        swap(nums, i, length - i - 1);
    }
}