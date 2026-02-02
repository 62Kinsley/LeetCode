// intervals区间

// class Solution{
//     public int[][] merge(int[][] intervals){

//         //左边界排序
//         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

//         List<int[]> res = new ArrayList<>();

//         int left = intervals[0][0];
//         int right = intervals[0][1];

//         for(int i=1; i<intervals.length; i++){

//             if(intervals[i][0] <= right){
//                 right = Math.max(right, intervals[i][1]);

//             }else{
//                 res.add(new int[]{left, right});
//                 left = intervals[i][0];
//                 right = intervals[i][1];
//             }
//         }
//         res.add(new int[]{left, right});

//         return res.toArray(new int[res.size()][]);

//     }

// }

class Solution{
    public int[][]  merge(int[][] intervals){

        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int m = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for(int i=1; i<m; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];

            if(left > end){
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(end, intervals[i][1]);
            }
        }
        list.add(new int[]{start, end});

        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}


