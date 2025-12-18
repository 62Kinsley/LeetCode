

 class Solution {
    public int arraySign(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                ans += 1;
            }
        }
        return ans % 2 == 0? 1 : -1;
    }
}