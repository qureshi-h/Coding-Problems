/*
Solution to problem from 
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

// ASCII Range of characters accepted
#define START 32
#define END 127

/* Return the length of the largest substring from
s that contains no repeating charcaters.
O(n) time complexity with constant space
100% faster and lesser memory comsumption than 
other submitted solutions */

int lengthOfLongestSubstring(char* s) {

	int  max = 0, count = 0, length = strlen(s);
  	int cut_off = 0; // start - 1 position of current substring
	int positions[ENDASCII + 1]; // stores latest position of seen characters
    
    for (int i = START; i <= END; i++) 
        positions[i] = -1;
    
    for (int pos = 0; pos < length; ++pos) (
        if (cut_off <= positions[s[pos]]) {
            if (max < count) max = count;
            count = pos - (cut_off = positions[s[pos]]);
        } else 	
            ++count;
        positions[s[pos]] = pos;
	}
    return (max > count)? max : count;
}
