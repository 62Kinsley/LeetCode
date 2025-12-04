class Solution {
    public int maxSumDivThree(int[] nums) {
        //1.cal the sum of nums
        //sum % 3 = ?
        //contains 余数，就去掉，没有得 return 0

        int sum = 0;
        // int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            sum += num;
            set.add(num);//23
        }

        if(sum % 3 == 0){
            return sum;
        } 
        int mod = sum % 3; //2
        int carry = sum / 3;//7
        if(set.contains(mod)){
            return sum - mod;
        }

        for(int i=carry-1; i>0; i--){
            int need = sum - i*3;
            if(set.contains(need)){
                return i*3;
            }
        }
        return 0;


    }
}