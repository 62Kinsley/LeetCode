class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by the end point ascending, then by starting poing ascending 
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        int res = 0;
        int p1= -1, p2 = -1;//2 3

                    //   p1 p2
        //[[1,3],[1,4],[3,5],[2,5]]
        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

           
            if(p2 < start){
                p1 = end - 1;
                p2 = end;
                res +=2; 
            }

            if( p1 <start){
                p2=end;
                res += 1;
            }

            // if( p1>=start && p2<= end){
            //     res += 0;
            // }
        }
        return res;
    
    }
        
        
}


// class Solution {
//     public int intersectionSizeTwo(int[][] intervals) {
//         // 按右端点升序排序，右端点相同时按左端点降序，z h
//         Arrays.sort(intervals, (a, b) -> {
//             if (a[1] != b[1]) return a[1] - b[1];
//             return b[0] - a[0];
//         });
        
//         int res = 0;
//         int p1 = -1, p2 = -1;  // 当前选中的最大两个点，p1 < p2
        
//         for (int[] interval : intervals) {
//             int start = interval[0];
//             int end = interval[1];
            
//             if (p2 < start) {
//                 // 情况1：两个点都不在区间内，选2个新点
//                 p1 = end - 1;
//                 p2 = end;
//                 res += 2;
//             } else if (p1 < start) {
//                 // 情况2：只有p2在区间内，选1个新点
//                 p1 = p2;          // 原来的p2变成新的p1
//                 p2 = end;         // 新选end作为p2
//                 res += 1;
//             }
//             // 情况3：两个点都在区间内，不用选
//         }
        
//         return res;
//     }
// }


