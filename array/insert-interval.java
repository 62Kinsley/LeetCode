//https://leetcode.cn/problems/insert-interval/solutions/472435/shou-hua-tu-jie-57-cha-ru-qu-jian-fen-cheng-3ge-ji/

// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> res = new ArrayList<>();
//         int i = 0;
//         int n = intervals.length;
//         int left = newInterval[0];
//         int right = newInterval[1];

//         //其实中间这里很好找规律， 我们这个left 要是>intervals[i][1] ，那就是执行第一条(左边不重叠的部分)
//         //执行第二条的话，那默认eft<= intervals[i][1]，因为不符合第一条规律，所以这行代码不用写出来，那么应该写什么呢？
//         //那看后面，如果right<intervals[i][0]，表示右边不重叠的部分，这时候如果我们把这个放在第三条的话，
//         //那么第二条（中间重叠部分）无非就是left<= intervals[i][1] 且right >= intervals[i][0],又因为eft<= intervals[i][1]是默认的了，所以无需写出来，只写right >= intervals[i][0]就可以

//         // 1. 左边完全不重叠的部分（interval 的右端 < newInterval 左端）
//         while (i < n && intervals[i][1] < left) {
//             res.add(intervals[i]);
//             i++;
//         }


//         // 2. 重叠的部分（interval 的左端 <= newInterval 右端）
        
//         while (i < n && intervals[i][0] <= right) { //这里默认 left<= intervals[i][1] ,因为不执行第一行代码的话
//             left = Math.min(left, intervals[i][0]);
//             right = Math.max(right, intervals[i][1]);
//             i++;
//         }
//         // 把合并后的区间加进去
//         res.add(new int[]{left, right});

//         // 3. 右边完全不重叠的部分（剩下的）
//         while (i < n && right < intervals[i][0] ) { 
//             res.add(intervals[i]);
//             i++;
//         }

//         return res.toArray(new int[res.size()][]);
//     }
// }


class Solution {
  public static int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<>();
      int i = 0;
      int n = intervals.length;
      int left = newInterval[0];
      int right = newInterval[1];

    //左边不重叠
    while(i < n && intervals[i][1] < left){
        res.add(intervals[i]);
        i++;
    }

    while(i < n &&  intervals[i][0] <= right){//
        left = Math.min(left, intervals[i][0]);
        right = Math.max(right, intervals[i][1]);
        i++;
    }
     res.add(new int[]{left, right});

    //右边不重叠
    while(i < n && intervals[i][0] > right){ 
        res.add(intervals[i]);
        i++;
    }
    //中间重叠
    return res.toArray(new int[res.size()][]);
  }
}



