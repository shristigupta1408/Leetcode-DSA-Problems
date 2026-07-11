class Solution {
    int startingIndex = 0;
    int lengthLongestPalindrome = 0;
    String givenString;

    public String longestPalindrome(String s) {
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