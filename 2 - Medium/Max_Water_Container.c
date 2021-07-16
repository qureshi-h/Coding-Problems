/*
solution to https://leetcode.com/problems/container-with-most-water/
*/

int maxAreaRecursive(int* p1, int* p2);


int maxArea(int* height, int heightSize){
    return maxAreaRecursive(height, height + heightSize - 1);
}

int maxAreaRecursive(int* p1, int* p2) {
    
    int* shorterP = p1;
    if (*p1 > *p2) shorterP = p2;
    
    if (p2 - p1 == 1) return (p2 - p1) * *shorterP;
    
    int new, currArea = (p2 - p1) * *shorterP;
    if (shorterP == p1) new = maxAreaRecursive(p1 + 1, p2);
    else new = maxAreaRecursive(p1, p2 - 1);
    if (currArea > new) return currArea;
    return new;
}


