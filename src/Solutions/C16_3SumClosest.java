package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums); // Sort the array

        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            // Skip duplicates for the fixed pointer
            if (fixed > 0 && nums[fixed] == nums[fixed - 1]) continue;
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];
                if (sum == target) return target; // Found the exact target
                // Update the closest sum if this is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                // Move the pointers
                if (sum < target) {
                    left++;
                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return closestSum;
    }

    public int threeSumClosestV2(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums); // Sort the array

        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            // Skip duplicates for the fixed pointer
            if (fixed > 0 && nums[fixed] == nums[fixed - 1]) continue;

            int left = fixed + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];

                if (sum == target) return target; // Found the exact target

                // Update the closest sum if this is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move the pointers
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
