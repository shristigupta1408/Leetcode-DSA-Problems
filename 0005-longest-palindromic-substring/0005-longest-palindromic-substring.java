class Solution {
    int startingIndex = 0;
    int lengthLongestPalindrome = 0;
    String givenString;

    public String longestPalindrome(String s) {
        // Would need a 2D DP array to track indices 
        // if dp[i][j] = true, then s[i..j] is a palindrome
        // Longest - where i - j or j - i is the maximum
        // Odd numbered - when the left and right portions from the centre
        // are palindromes too. 
        // Not matching - 0 + find the palindrome of the rest of the string
        // 2 options - move 1 pointer to the right, move the other to the left
        // Palindrome - when the pointers meet, or they are adjacent, or pointers reach the end
        // How do the pointers cross each other?
        // Have a current pointer - and look at adjacent alphabets and keep moving those pointers
        // But then how do you deal with even length palindromes?

        int leftPointer;
        int rightPointer;
        givenString = s;

        for (int i = 0; i < s.length(); i++) {
            // Odd numbered Case
            leftPointer = i;
            rightPointer = i;

            findLongestPalindromicSubstring(leftPointer, rightPointer);

            // Even Numbered Case 
            leftPointer = i;
            rightPointer = i+1;

            findLongestPalindromicSubstring(leftPointer, rightPointer);
        }

        return s.substring(startingIndex, startingIndex + lengthLongestPalindrome);
    }

    private void findLongestPalindromicSubstring(int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < givenString.length() 
                && givenString.charAt(leftPointer) == givenString.charAt(rightPointer)) {

                    if (rightPointer - leftPointer + 1 > lengthLongestPalindrome) {
                        lengthLongestPalindrome = rightPointer - leftPointer + 1;
                        startingIndex = leftPointer;
                    }

                leftPointer--;
                rightPointer++;
            }
    }
}