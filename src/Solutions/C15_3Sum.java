package Solutions;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C15_3Sum {
    // Two Pointer Approach
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            if(fixed > 0 && nums[fixed] == nums[fixed - 1]) continue;           // Skip duplicates
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[fixed], nums[left], nums[right]));
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int fixed = 0; fixed < nums.length - 2; fixed++) {
            if(fixed > 0 && nums[fixed] == nums[fixed - 1]) continue;           // Skip duplicates
            if(nums[fixed] > 0) break;                          // fixed value is > 0 so 0 isn't possible anymore
            int left = fixed + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[fixed], nums[left], nums[right]));
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }
}
