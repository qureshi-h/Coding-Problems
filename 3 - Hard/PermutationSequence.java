 /**
  * solution to https://leetcode.com/problems/permutation-sequence/
  */
 
 class PerumationSequence {
    
    public static void main(String[] args) {

        int n = 4;
        for (int i = 1; i <= new PerumationSequence().factorial(n); i++) {
            System.out.printf("%d: %s\n", i, 
                new PerumationSequence().getPermutation(n, i));
        }
        // System.out.printf(new PerumationSequence().getPermutation(4, 2));
    }

    public String getPermutation(int n, int k) {
        char[] number = get_number(n);
        int num_combinations = factorial(n);

        return permute(n, k, number, num_combinations, 0);
    }

    private String permute(int n, int k, char[] number, int combinations, int curr_pos) {
        
        if (n == 0) {
            return String.valueOf(number);
        }

        int next_combinations = combinations / n;
        int i;
        for (i = curr_pos; i < number.length; i++) {
            if (k <= next_combinations) 
                break;
            k -= next_combinations;
        }

        while (i > curr_pos) {
            swap(number, i - 1, i);
            i--;
        }

        return permute(n - 1 , k, number, next_combinations, curr_pos + 1);
    }
    
    private void swap(char[] number, int i, int j) {
        char temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    } 

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private char[] get_number(int n) {
        char[] number = new char[n];
        for (int i = 1; i <= n; i++) {
            number[i - 1] = (char)(i + '0');
        }
        return number;
    }
}