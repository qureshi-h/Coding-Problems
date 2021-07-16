/* 
solution to https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>

#define STARTASCII 32
#define ENDASCII 127


/*
finds the length of the longest substring without repeating characters
*/

void longestSubstring(char* s, int* p, int* pos, int* max)
{
	int i, length = strlen(s), count = 0;
	if (*pos == length - 1)
	{
		(*pos)++;
		if (!(*max))* max = 1;
		return;
	}

	for (i = STARTASCII; i <= ENDASCII; ++i)
		p[i] = -1;

	for (i = *pos; i < length; ++i)
	{
		if (p[(int)s[i]] != -1)
			break;
		else
			p[(int)s[i]] = i;

		++count;
	}

	*pos = p[(int)s[i]] + 1;
	if (*max < count)* max = count;
}

int lengthOfLongestSubstring(char* s) {

	int p[ENDASCII + 1];

	int count = 0, pos = 0, length = strlen(s);
	while (pos < length)
		longestSubstring(s, p, &pos, &count);

	return count;
}

int main(void)
{
	char s[] = "abcabcbb";
	printf("%d", lengthOfLongestSubstring(s));
}
