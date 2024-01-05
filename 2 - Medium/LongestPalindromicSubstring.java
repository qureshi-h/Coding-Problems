import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2("cbbd"));
    }

    public String longestPalindrome(String s) {
        List<List<Integer>>  characterPositions = preprocess(s.toUpperCase());

        int currStart = 0, currEnd = 0, currLength = 0;
        for (List<Integer> currCharacterPos : characterPositions) {

            int size = currCharacterPos.size() - 1;

            if (currCharacterPos.size() < 2 ||
                    currCharacterPos.get(currCharacterPos.size() - 1) - currCharacterPos.get(0) < currLength) {
                continue;
            }

            System.out.println(currCharacterPos);

            for (int j = 0; j <= size; j++) {
                for (int k = size; k > j; k--) {
                    System.out.println(j + " " + k);
                    if (currCharacterPos.get(k) - currCharacterPos.get(j) < currLength){
                        break;
                    }
                    if (isPalindrome(s.substring(currCharacterPos.get(j), currCharacterPos.get(k) + 1))) {
                        currStart = currCharacterPos.get(j);
                        currEnd = currCharacterPos.get(k);
                        currLength = currCharacterPos.get(k) - currCharacterPos.get(j);
                    }
                }
            }


        }
        return s.substring(currStart, currEnd + 1);
    }

    private List<List<Integer>> preprocess(String s) {
        int offset = 48, maxValue = 90;
        List<List<Integer>> characterPositions = new ArrayList<>();

        for (int i = offset; i <= maxValue; i++) {
            characterPositions.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < s.length(); i++) {
            characterPositions.get(((int) s.charAt(i)) - offset).add(i);
        }
        return characterPositions;
    }

    private boolean isPalindrome(String s) {

        System.out.println(s);

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i >= j;
    }

    public String longestPalindrome2(String s) {

        int i = 0, j = s.length();

        while (i <= j) {
            if (isPalindrome(s.substring(i, j))) return s;
            if (isPalindrome(s.substring(i, j - 1))) return s.substring(i, j - 1);
            if (isPalindrome(s.substring(i + 1, j))) return s.substring(i + 1, j);

            i++;
            j--;
        }

        return s;
    }
}
