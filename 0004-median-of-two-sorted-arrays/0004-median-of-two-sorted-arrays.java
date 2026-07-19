class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int total = n1 + n2;
        int target = (total + 1) / 2;

        int l = 0;
        int r = n1;

        while (true) {
            int take1 = l + (r - l) / 2;
            int take2 = target - take1;

            int max1 = (take1 == 0) ? Integer.MIN_VALUE : nums1[take1 - 1];
            int min1 = (take1 == n1) ? Integer.MAX_VALUE : nums1[take1];
            int max2 = (take2 == 0) ? Integer.MIN_VALUE : nums2[take2 - 1];
            int min2 = (take2 == n2) ? Integer.MAX_VALUE : nums2[take2];

            if (max1 > min2) {
                r = take1 - 1;
                continue;
            }

            if (max2 > min1) {
                l = take1 + 1;
                continue;
            }

            int medianValOdd = Math.max(max1, max2);
            if (total % 2 == 1) {
                return medianValOdd;
            } else {
                return (medianValOdd + Math.min(min1, min2)) / 2.0;
            }
        }
    }
}