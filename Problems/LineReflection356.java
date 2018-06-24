/* Description
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example
Given points = [[1,1],[-1,1]], return true.
Given points = [[1,1],[-1,-1]], return false.

Challenge
Could you do better than O(n2)?
*/

//LintCode 908
/*Medium*/

/**
 * LineReflection356
 */
import java.util.*;
public class LineReflection356 {
    public boolean isReflected(int[][] points) {
        // Write your code here
        int max = 0, min = 0;
        HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            max = Math.max(points[i][0], max);
            min = Math.min(points[i][0], min);
            if (!hashmap.containsKey(points[i][1])) {
                HashSet<Integer> hashset = new HashSet<>();
                hashset.add(points[i][0]);
                hashmap.put(points[i][1], hashset);
            } else {
                hashmap.get(points[i][1]).add(points[i][0]);
            }
        }
        for (int i = 0; i < points.length; i++) {
            if (!hashmap.containsKey(points[i][1]) || !hashmap.get(points[i][1]).contains(max + min - points[i][0])) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { -1, 1 } };
        System.out.println(new LineReflection356().isReflected(points));
    }
}