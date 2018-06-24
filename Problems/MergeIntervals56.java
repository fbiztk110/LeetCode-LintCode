/* Description
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

Challenge
O(n log n) time and O(1) extra space.
*/

//LintCode 
/*Medium*/

/**
 * MergeIntervals56
 */
public class MergeIntervals56 {
    public class Interval {
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int start, int end) {
            start = start;
            end = end;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()){
            return intervals;
        }
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> result = new ArrayList<>();
        for(int i = 0, j = 0; i < n; i++){
            if(i == n - 1 || start[i + 1] > end[i]){
                result.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}