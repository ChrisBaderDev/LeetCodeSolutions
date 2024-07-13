package Solutions;

public class C11_ContainerWithMostWater {

    // The naive approach - Not executable in time limit
    public int maxArea(int[] height) {
        int maxArea = -1;
        // Calculate every possible combination and return the largest.
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int x = j - i;                              // Distance between the two walls
                int y = Math.min(height[i], height[j]);     // Height of the lower wall
                maxArea = Math.max(maxArea, x * y);         // Area between both walls, if it is bigger than best known.
            }
        }
        return maxArea;
    }

    // The pointer solution
    public int maxAreaV2(int[] height) {
        int maxArea = -1;
        int left = 0, right = height.length - 1;

        while(left != right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, x * y);

            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    // The improved pointer solution
    public int maxAreaV3(int[] height) {
        int maxArea = -1;
        int left = 0, right = height.length - 1;

        while(left < right) {
            int width = (right - left);
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * minHeight);

            while(left < right && height[left] <= minHeight) {
                left++;
            }
            while(left < right && height[right] <= minHeight) {
                right--;
            }
        }
        return maxArea;
    }
}
