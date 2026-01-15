class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {

        //dp[i][j] represent maximum dot product between non-empty subsequences of nums1[0]-nums1[i] and nums2[0]-nums2[j]
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++){
            dp[i][0] = Integer.MIN_VALUE;
        }

        for(int j=0; j<=len2; j++){
            dp[0][j] = Integer.MIN_VALUE;
        }


        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                dp[i][j] =   Math.max(
                    Math.max(dp[i-1][j-1], 0)+nums1[i-1]*nums2[j-1], 
                    Math.max(dp[i][j-1], dp[i-1][j])
                );
            }
        }
        
        return dp[len1][len2];
        

        
    }
}