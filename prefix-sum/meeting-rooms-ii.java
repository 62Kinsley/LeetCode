
// class Solution {
//     public int minMeetingRooms(int[][] intervals) {
        
//         int n = intervals.length;
//         int[] begin = new int[n];
//         int[] end = new int[n];

//         for(int i=0; i<n; i++){
//             begin[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }

//         Arrays.sort(begin);
//         Arrays.sort(end);

//          // 扫描过程中的计数器
//          int count = 0;
//           // 双指针技巧
//           int res =0, i=0, j=0;

//           [0, [5,[15,
//           10] 20] 30]
//           while(i<n && j<n){
//             if(begin[i] < end[j]){//说明当前的start[i] 是小于当前的end[j]的，也就是说，这时候的状态会议在未来的十分钟才会结束，而此时又要开会，所以需要再开一个会议室
//                 // 扫描到一个红点
//                 count++;
//                 i++;//下一个i继续和当前的end[j]比
//             }else{  //说明当前的start[i] 是大于当前的end[j]的，也就是说，这时候的状态会议在未来的12分钟才会开始，而此时上一个会议在第10分钟结束了，所以空出一个会议室，count--
//                 // 扫描到一个绿点
//                 count--;
//                 j++;

//             }

//             res = Math.max(res, count);
//           }

//           return res;

//     }
// }

class Solution{
   public int minMeetingRooms(int[][] intervals) {
       int n = intervals.length;
       int[] start = new int[n];
       int[] end = new int[n];

       for(int i=0; i<n; i++){
            start[i] = intervals[i][0]; //0,5,15
            end[i] = intervals[i][1];//30,10,20
       }
                                    
       Arrays.sort(start);//0,5,15
       Arrays.sort(end);//10,20,30

      int i=0, j=0;
      int count = 0;//2
      int res = 1;
      while(i<n && j<n){
        if(start[i] < end[j]){
            count++;
            i++;
        }else if(start[i] > end[j]){
            count--;
            j++;
        }else{
            i++;
            j++;
        }
        res = Math.max(count, res);
      }

        return res; 
   }
}