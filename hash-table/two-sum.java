
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i< nums.length; i++){
            
//             int balance = target - nums[i];
//             //因为要找的balance一定是要在当前这个nums[i]之前的数字去找的
//             //所以不能先存当前的nums[i]和i
//             //因为存了的话，有可能这个balance就是当前的这个nums[i]
//             //那结果就是重复位置的两个一样的数，就是错的。所以

//             if(map.containsKey(balance)){
//                 return new int[]{ map.get(balance), i};
//             }//一定要先看map是否containsKey(balance)

//             map.put(nums[i], i);
//             //然后再存key，这两个顺序不能调换！因为如果先存了，就错了 ，可以试试。。。。

            
//         }
//         return null;
        
//     }
// }

class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();// element, index
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{i, map.get(need)};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}