/*
solution to https://leetcode.com/problems/divide-two-integers/
*/

/*
divides two integers without using multiplication, division, or mod operators 
100% / 100%
*/
int divide(long dividend, long divisor){
   
    if (dividend == INT_MIN && divisor == -1)
        return INT_MAX;
    
    int is_positive = ((dividend >= 0 && divisor >= 0) ||
        (dividend < 0 && divisor < 0)) ? 1 : -1;

    return is_positive * recursive_divide(labs(dividend), labs(divisor));
}

long recursive_divide(long dividend, long divisor) {

    if (dividend < divisor) return 0;
    long sum = divisor;
    long output = 1;
    
    while(sum + sum < dividend) {
        sum += sum;
        output += output;
    }
    
    return output + recursive_divide(dividend-sum, divisor);
}
