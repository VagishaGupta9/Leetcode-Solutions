/*Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.*/


class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int[] last = null;
        Arrays.sort(intervals, (a,b)->(a[0] !=b[0] ? a[0]- b[0]:b[1]-a[1]));
        int count = 0;
        for(int[] interval:intervals){
            if(last==null) {
                last = interval;
            } else {
                if(last[1]>=interval[1]) {
                    count++;
                } else{
                    last = interval;
                }
            }
        }
        return intervals.length-count;
    }
}
