/*
solution to https://leetcode.com/problems/zigzag-conversion/
*/

/* 
converts string into a zigzag pattern with numRows
and reads it line by line 80% / 6 %
*/

char* convert(char* s, int numRows) {
	char** zigZag = zigzag(s, numRows);
	char* output = (char*)malloc(sizeof(*output) * strlen(s) + 1);
    assert(output);
	
    int pos = 0;
	for (int i = 0; i < numRows; i++) {
		for (int j = 0; zigZag[i][j]; j++)
			output[pos++] = zigZag[i][j];
	}
	output[pos] = '\0';
    free(zigZag);
    
	return output;
}

char** zigzag(char* s, int numRows)
{
	char** zigZag = (char**)malloc(sizeof(*zigZag) * numRows);
	int *columnPos = (int*)malloc(sizeof(*columnPos) * numRows);
    assert(zigZag && columnPos);
	
    int i, length = strlen(s);
	for (i = 0; i < numRows; i++) {
		zigZag[i] = (char*)malloc(sizeof(**zigZag) * length + 1);
		columnPos[i] = 0;
	}
	
	recursiveZigZag(s, zigZag, numRows, columnPos);
	for (i = 0; i < numRows; i++) {
		zigZag[i][columnPos[i]] = '\0';
	}

	return zigZag;
}

void recursiveZigZag(char* s, char** zigZag, int numRows, int *column)
{
	int i, j = 0;
	for (i = 0; i < numRows && s[j]; i++)
		zigZag[i][column[i]++] = s[j++];
	
	for (i-=2; i > 0 && s[j]; i--)
		zigZag[i][column[i]++] = s[j++];

	if (s[j]) recursiveZigZag(s + j, zigZag, numRows, column);
}