class Solution {
    public int findMaxLength(int[] nums) {
        //这道题的巧思就在与把0换成-1，这样很巧妙的处理了就算nums过长，也可以在map里找到对应的index
        int n = nums.length;
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                arr[i] = -1;
            }

            if(nums[i] == 1){
                 arr[i] = 1;
            }
        }

        //  0  1 2 3 4 5 6  7  8
        // [-1,1,1,1,1,1,-1,-1,-1]
        // [-1,0,1,2,3,4,3,  2  1]
        
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);//sum, index

        int sum = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                res = Math.max(res, i- map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return res;


    }
}