#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

int distribute_pies(int* distribution, int students);
void find_values(int* distribution, int students, int* max, int* min);
int check(int* distribution, int students);

int main(void)
{
	/* Solution to https://www.codechef.com/problems/EQIDLIS */

	int test_cases;
	assert(scanf("%d", &test_cases));

	int students, count, * distribution, value;

	for (int i = 0; i < test_cases; i++)
	{
		assert(scanf("%d", &students));
		distribution = (int*)malloc(sizeof(*distribution) * students);
		assert(distribution);

		count = 0;
		for (int j = 0; j < students; j++)  // reading initial distribution
		{
			assert(scanf("%d", &value));
			count += (distribution[j] = value);
		}

		if ((count % students)) printf("-1\n");  // sanity check
		else printf("%d\n", distribute_pies(distribution, students));

		free(distribution);
		getchar(); // read newline character
	}
}


int distribute_pies(int* distribution, int students)
{
	/* Recursively finds the number of times the step needs to be repeated
	Step 1 and 2 can be done much more elengantly if array is sorted
	but that takes O(nlogn) average case */

	if (check(distribution, students)) return 0;  // step 1

	static int max, min;
	find_values(distribution, students, &max, &min);  // step 2
	int exchange = ((distribution[max] - (float)distribution[min]) / 2) + 0.5;
	distribution[min] += exchange;
	distribution[max] -= exchange;

	return 1 + distribute_pies(distribution, students);
}

void find_values(int* distribution, int students, int* max, int* min)
{
	/* Finds max and min value in linear time */
	int value, curr_max = 0, curr_min = 0;

	for (int i = 1; i < students; i++)
	{
		if (distribution[i] < distribution[curr_min]) curr_min = i;
		if (distribution[i] > distribution[curr_max]) curr_max = i;
	}

	*max = curr_max;
	*min = curr_min;
}

int check(int* distribution, int students)
{
	/* Checks if the all values are equal in O(n) */
	for (int i = 0; i < students - 1; i++)
	{
		if (distribution[i] != distribution[i + 1]) return 0;
	}
	return 1;
}