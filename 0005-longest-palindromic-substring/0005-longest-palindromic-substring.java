class Solution {
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
        int startingIndex = 0;
        int lengthLongestPalindrome = 0;

        // if (leftPointer < 0 || rightPointer >= s.size()) {
        //     return s.substring(startingIndex, startingIndex + lengthLongestPalindrome);
        // }

        for (int i = 0; i < s.length(); i++) {
            // Odd numbered Case
            leftPointer = i;
            rightPointer = i;

            while (leftPointer >= 0 && rightPointer < s.length() 
                && s.charAt(leftPointer) == s.charAt(rightPointer)) {

                    if (rightPointer - leftPointer + 1 > lengthLongestPalindrome) {
                        lengthLongestPalindrome = rightPointer - leftPointer + 1;
                        startingIndex = leftPointer;
                    }

                leftPointer--;
                rightPointer++;
            }

            // Even Numbered Case 
            leftPointer = i;
            rightPointer = i+1;

            while (leftPointer >= 0 && rightPointer < s.length() 
                && s.charAt(leftPointer) == s.charAt(rightPointer)) {

                    if (rightPointer - leftPointer + 1 > lengthLongestPalindrome) {
                        lengthLongestPalindrome = rightPointer - leftPointer + 1;
                        startingIndex = leftPointer;
                    }

                leftPointer--;
                rightPointer++;
            }
        }

        return s.substring(startingIndex, startingIndex + lengthLongestPalindrome);
    }
}