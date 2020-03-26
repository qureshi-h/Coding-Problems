/*
Solution to problem from
https://leetcode.com/problems/reverse-integer/
*/

#define MAX_LENGTH 10
#define OUT_BASE 10

/* fills up the value array with the 
digits in x in reverse order */
void reverse_itoa(int x, char* value) {
    int i;
    for (i = 0; x; i++) {
        value[i] = x % 10 + '0';
        x /= 10;
    }
    value[i] = '\0';
}

/* Reverses digits of a 32 digit number. 
Returns 0 in case of integer overflow. 
O(n) space and time complexity
100%/100% */
int reverse(int x){
    
    // reverse of int min is also out of bounds
    if (x == INT_MIN) return 0; // avoid error on abs()
    
    int is_negative = x < 0;
    x = abs(x);
    
    char value[MAX_LENGTH + 1];
    reverse_itoa(x, value);
   
    //long used to avoid overflow
    long y = strtol(value, NULL,  OUT_BASE);
    
    if (y > INT_MAX) return 0;
    return (is_negative) ? -y : y;
}

