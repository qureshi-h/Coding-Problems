/**
 * solution to https://leetcode.com/problems/roman-to-integer/
 */

public class RomanToInteger {

    private enum RomanIntegers {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

        int value;
        RomanIntegers(int value) {
            this.value = value;
        }

        public static RomanIntegers getEnum(char character) {
            switch (character) {
                case 'I': return I;
                case 'V': return V;
                case 'X': return X;
                case 'L': return L;
                case 'C': return C;
                case 'D': return D;
                case 'M': return M;
            }
            return I;
        }
    }

    /*
    Given a roman numeral, converts it to an integer
     */
    public int romanToInt(String s) {

        int i = 0;
        int total = 0, diff;
        RomanIntegers curr;

        for (; i < s.length() - 1; i++) {
            curr = RomanIntegers.getEnum(s.charAt(i));
            if ((diff = RomanIntegers.getEnum(s.charAt(i + 1)).ordinal() -
                    curr.ordinal()) > 0 && diff < 3) {
                total += RomanIntegers.getEnum(s.charAt(i + 1)).value - curr.value;
                i++;
            }
            else total += curr.value;
        }

        if (i == s.length() - 1) total += RomanIntegers.getEnum(s.charAt(i)).value;

        return total;
    }
}