// class Solution {
//     public int longestConsecutive(int[] nums) {
//         //这道题要找最长的连续sequence
//         //那么我们肯定是希望前面的数字越前越好
//         //后面的数字越后越好，这样才能尽可能的长
//         //前面的数字要前到多少才算前呢？ 我们可以将nums里的数字存到hashset里
//         //如果遍历到nums当前的数字，然后看看hashset有没有当前数的前一个数，例如，遍历到4的时候，看看set有没有3，有就跳出当前遍历，继续下一个数，
//         //遍历到200的时候，看看set有没有199，没有的话，200就是它的这个这个sequence里面最前的数字了，然后就可以开始往后找了，
//         //还是在set里面找，如果往后有201，那就cout++， 如此， 像1234的也是这样，最后比较哪个count大就输出哪个


//         //1.hashset to store the num in nums array
//         HashSet<Integer> set = new HashSet<>();
//         int res = 0;

//         for(int num : nums){
//             set.add(num);
//         }

//         for(int num: set){
//             //这里应该直接在set里遍历，因为set是去重的了，如果在原来的nums遍历的话会很浪费时间！！这个很重要！
//             if(set.contains(num-1)){
//                 continue;//有当前数字的前一个数的话，跳出当前循环，因为我们要找到尽可能前面的数
//             }else{
//                 int count = 1;
//                 while(set.contains(num+1)){
//                     count++;
//                     num = num+1;
//                 }
//                 res = Math.max(res, count);
//             }
//         }

//         return res;
        
//     }
// }

//time: O(N)
//space:O(N)

// class Solution {
//     public int longestConsecutive(int[] nums) {
        
//         int res = 0;
//         Set<Integer> set = new HashSet<>();//去重
//         for(int num: nums){
//             set.add(num);//0,1,2
//         }

//         //[100,4,200,1,3,2]
//         for(int num : set){//1
//             if(set.contains(num-1)){
//                 continue;
//             }
//             else{//set.!contains(num-1)
//                 int count = 0;
//                 while(set.contains(num)){//5
//                     count++;//4
//                     num = num+1;//5
//                 }

//                 res = Math.max(res, count);//4
//             }
//         }
//         return res;
//     }
// } 

class Solution {
    public int longestConsecutive(int[] nums) {

        //edge case:
        if(nums.length <= 1){
            return nums.length;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int res = 1;
         for(int num: nums){
            set.add(num);//0,1,2
        }

        for(int num: set){//1
            if(set.contains(num-1)){
                continue;
            }else{
                int count = 1;
                int cur = num;
                while(set.contains(cur+1)){//2
                    count++;//1
                    res = Math.max(res, count);//4
                    cur = cur+1;//
                }
            }
           
        }
        return res;
    }
}