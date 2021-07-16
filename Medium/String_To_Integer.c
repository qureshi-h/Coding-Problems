/*
solution to https://leetcode.com/problems/string-to-integer-atoi/submissions/
*/

/* 
converts a string to a 32-bit signed integer
*/

int myAtoi(char * str) {
    
    int is_negative = 0;
    while (*str == ' ') str++;
    
    if (*str == '+' || *str == '-') {
        is_negative = *str == '-';
        str++;
    }
    
    while (*str == '0') str++;
    
    int digits;
    for (digits = 0; str[digits] > 47 && str[digits] < 58; digits++);
    
    long number = 0;
    if (digits > 10) {
        number = (is_negative) ? INT_MIN : INT_MAX;
        return number;
    }
    
    for (int i = 0; digits; i++) {
        number += ((int)str[i] - 48) * pow(10, --digits);
    }
    
    if (number > INT_MAX)
        number = (is_negative) ? INT_MIN : INT_MAX;
   
    if (is_negative) number *= -1;
    
    return number;
}

