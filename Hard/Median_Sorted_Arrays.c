/*
solution to https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

/*
finds the median of two sorted arrays
*/
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    
    int p1 = 0, p2 = 0;
    int isOdd = (nums1Size + nums2Size) % 2;
    int firstHalf;
    int medianPos = (nums1Size + nums2Size + 1) / 2 - 1;
    
    while (nums1Size > p1 && p2 < nums2Size) {
        if (p1 + p2 >= medianPos) {
            if (isOdd) 
                return (nums1[p1] > nums2[p2]) ? nums2[p2] : nums1[p1];
            else if (p1 + p2 == medianPos) {
                firstHalf = (nums1[p1] > nums2[p2]) ? nums2[p2++] : nums1[p1++];
            }
            else 
                return (firstHalf + ((nums1[p1] > nums2[p2]) ? 
                nums2[p2] : nums1[p1])) / 2.0;

        }
        else if (nums1[p1] < nums2[p2])
            p1++;
        else
            p2++;

    }

    int p3 = (p1 == nums1Size) ? p2 : p1;
    int* array = (p1 == nums1Size) ? nums2 : nums1;    
    p3 += (medianPos - p1 - p2 > 0) ? medianPos - p1 - p2 : 0;

    if (isOdd) return array[p3]; 
    return ((medianPos - p1 - p2 < 0) ? 
        firstHalf + array[p3] : array[p3 + 1] + array[p3]) / 2.0;
}