package Solutions;

import java.util.HashMap;
import java.util.Map;

public class C1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        Integer index2;
        for (Integer index1 : numMap.keySet()) {
            int restTarget = target - numMap.get(index1);
            if ((index2 = numMap.get(restTarget)) != null) {
                if (!index1.equals(index2)) {
                    return new int[]{index1, index2};
                }
            }
        }
        return null;
    }
}
