class Solution {
    public int[] findErrorNums(int[] nums) {
        //[1,2,3,4,2,6]
        int[] res = new int[2];
        int n = nums.length;
        int[] record = new int[n+1];
        //[0,1,1,0,1]
        //[1,1]
        for(int i=0; i<n; i++){
            int num = nums[i];
            if(record[num] == 1){
                res[0] = num;
            }
            record[num]++;
        }
        for(int i=1; i<n+1; i++){
            if(record[i] == 0){
                res[1] = i;
            }
        }
        return res;
    }
}