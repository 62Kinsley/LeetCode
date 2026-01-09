// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         //[1,2,3,4,2,6]
//         int[] res = new int[2];
//         int n = nums.length;
//         int[] record = new int[n+1];
//         //[0,1,1,0,1]
//         //[1,1]
//         for(int i=0; i<n; i++){
//             int num = nums[i];
//             if(record[num] == 1){
//                 res[0] = num;
//             }
//             record[num]++;
//         }
//         for(int i=1; i<n+1; i++){
//             if(record[i] == 0){
//                 res[1] = i;
//             }
//         }
//         return res;
//     }
// }


class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                a = nums[i];
                b = i == 0 ? 1 : nums[i - 1] + 1;
            }
        }
        return new int[]{a, b};
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
