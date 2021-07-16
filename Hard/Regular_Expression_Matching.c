/*
solution to https://leetcode.com/problems/regular-expression-matching/
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

bool isMatch(char* s, char* p);
bool isMatchRecursive(char* s, char* p, char last_char);
bool character_match(char string_char, char pattern_char);

int main()
{
	char s[] = "ab";
	char p[] = ".*..";
	printf("%d", isMatch(s, p));
}

/*
Given an input string s and a pattern p, implements a regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching covers the entire input string (not partial).

30% / 82%
(Faster approach possible using dynamic programming)
*/
bool isMatch(char* s, char* p) {
	return isMatchRecursive(s, p, '/0');
}

bool isMatchRecursive(char* s, char* p, char last_char) {

	if (!*p) {
		if (!*s) return 1;
		return 0;
	}
	if (!*s) {
		if (!*p) return 1;
		if (*p != '*' && !((p + 1) && *(p + 1) == '*')) return 0;
	}
	if (*(p + 1) == '*') {
		return isMatchRecursive(s, p + 1, *p);
	}
	if (isalpha(*p)) {
		if (*p != *s) return 0;
		return isMatchRecursive(s + 1, p + 1, *p);
	}
	if (*p == '.') {
		return isMatchRecursive(s + 1, p + 1, *p);
	}

	// pattern char is '*'
	int result = isMatchRecursive(s, p + 1, *s);
	for (int i = 0; !result && *(s + i) && character_match(*(s + i), last_char); i++) {
		result = isMatchRecursive(s + i + 1, p + 1, '/0');
	}
	return result;
}

bool character_match(char string_char, char pattern_char) {
	return (pattern_char == '.') ? 1 : tolower(string_char) == pattern_char;
}