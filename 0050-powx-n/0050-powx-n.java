class Solution {
    public double myPow(double x, int n) {
        // Edge case - Negative n
        // Recursion ? TC ?
        // For loop - O(n) - x *= x
        // Are there any complexities with doubles?
        // 0 raised to anything -> 0
        // anything raised to 0 -> 1

        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (x == 0) {
            return 0.0;
        }

        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        if (n % 2 != 0) {
            return x * binaryExp(x * x, (n-1) / 2);
        }

        return binaryExp(x * x, n / 2);
    }
}