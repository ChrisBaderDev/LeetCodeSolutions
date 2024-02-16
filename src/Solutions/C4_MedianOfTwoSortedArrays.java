package Solutions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class C4_MedianOfTwoSortedArrays {

    // 4 - find median of two sorted arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums.add(nums2[i]);
        }
        Collections.sort(nums);
        if (nums.size() % 2 == 0) {
            return (double) (nums.get(nums.size() / 2) + nums.get((nums.size() / 2) - 1)) / 2;
        } else {
            return nums.get(nums.size() / 2);
        }
    }

    public static double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int sumLength = n + m;
        int nPointer = 0, mPointer = 0;

        // Variables to keep track of the last and second-to-last elements seen
        int last = 0, secondToLast = 0;

        for (int i = 0; i <= sumLength / 2; i++) {
            secondToLast = last; // Keep track of the second-to-last element

            // Decide whether to move the nPointer or mPointer
            if (nPointer < n && (mPointer >= m || nums1[nPointer] < nums2[mPointer])) {
                last = nums1[nPointer];
                nPointer++;
            } else {
                last = nums2[mPointer];
                mPointer++;
            }
        }

        // Calculate median
        if (sumLength % 2 == 0) {
            // Even amount of data
            return (last + secondToLast) / 2.0;
        } else {
            // Uneven amount of data
            return last;
        }
    }

    public static double findMedianSortedArraysV3(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m) {
            return findMedianSortedArraysV3(nums2, nums1);
        }
        int low = 0, high = n;
        while (low <= high) {
            // Partition the nums arrays
            int partitionNums1 = (low + high) / 2;
            int partitionNums2 = (n + m + 1) / 2 - partitionNums1;

            // Handle edge cases for nums1
            int maxLeftNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int minRightNums1 = (partitionNums1 == n) ? Integer.MAX_VALUE : nums1[partitionNums1];

            // Handle edge cases for nums2
            int maxLeftNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int minRightNums2 = (partitionNums2 == m) ? Integer.MAX_VALUE : nums2[partitionNums2];

            // Check if we have found the correct partition
            if (maxLeftNums1 >= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                // Even amount of data
                if ((n + m) % 2 == 0) {
                    return (double) Math.max(maxLeftNums1, maxLeftNums2);
                } else { // Uneven amount of data
                    return (double) Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightNums1) {
                high = partitionNums1 - 1;
            } else {
                low = partitionNums1 + 1;
            }
        }
        return 0;       // Should not be reached.
    }
}
