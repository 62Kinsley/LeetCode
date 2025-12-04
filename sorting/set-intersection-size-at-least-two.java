// class Solution {
//     public int intersectionSizeTwo(int[][] intervals) {
//         // Sort by the end point ascending, then by starting poing ascending 
//         Arrays.sort(intervals, (a,b) -> {
//             if(a[1] != b[1]){
//                 return a[1] - b[1];
//             }
//             return b[0] - a[0];
//         });

//         // Track the last two elements added to our containing set
//         int largest = -1; // The largest element in our set
//         int secondLargest = -1; // The second element in our set
//         int size = 0;
//         for(int[] interval : intervals) {
//             int start = interval[0];
//             int end = interval[1];

//             // Check how many of our last elements are in this interval
//             boolean hasLargest = largest >= start && largest <= end;
//             boolean hasSecondLargest = secondLargest >= start && secondLargest <= end;

//             if(hasLargest && hasSecondLargest){
//                 // Already satisfied, no need to add
//                 continue; 
//             }else if(hasLargest || hasSecondLargest){
//                 // Already contained one element 
//                 secondLargest = largest;
//                 largest = end;
//                 size ++; // add one more element to the set 
//             }else {
//                 secondLargest = end - 1;
//                 largest = end;
//                 size += 2;
//             }
//         }
//         return size;
//     }
// }


class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // 按右端点升序排序，右端点相同时按左端点降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int res = 0;
        int p1 = -1, p2 = -1;  // 当前选中的最大两个点，p1 < p2
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            if (p2 < start) {
                // 情况1：两个点都不在区间内，选2个新点
                p1 = end - 1;
                p2 = end;
                res += 2;
            } else if (p1 < start) {
                // 情况2：只有p2在区间内，选1个新点
                p1 = p2;          // 原来的p2变成新的p1
                p2 = end;         // 新选end作为p2
                res += 1;
            }
            // 情况3：两个点都在区间内，不用选
        }
        
        return res;
    }
}


