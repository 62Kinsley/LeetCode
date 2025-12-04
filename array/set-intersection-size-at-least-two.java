class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by the end point ascending, then by starting poing ascending 
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        // Track the last two elements added to our containing set
        int largest = -1; // The largest element in our set
        int secondLargest = -1; // The second element in our set
        int size = 0;
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Check how many of our last elements are in this interval
            boolean hasLargest = largest >= start && largest <= end;
            boolean hasSecondLargest = secondLargest >= start && secondLargest <= end;

            if(hasLargest && hasSecondLargest){
                // Already satisfied, no need to add
                continue; 
            }else if(hasLargest || hasSecondLargest){
                // Already contained one element 
                secondLargest = largest;
                largest = end;
                size ++; // add one more element to the set 
            }else {
                secondLargest = end - 1;
                largest = end;
                size += 2;
            }
        }
        return size;
    }
}