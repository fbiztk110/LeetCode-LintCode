/* Description
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example
Given [1,3,2], the max area of the container is 2.
*/

//LintCode 383
/*Medium*/

/**
 * ContainerWithMostWater11
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] heights) {
        // write your code here
        
    }

    public static void main(String[] args) {
        int[] heights = {1,1};
        System.out.println(new ContainerWithMostWater11().maxArea(heights));
    }
}