//https://leetcode.cn/problems/regular-expression-matching/solutions/24543/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
// class Solution {
//     public boolean isMatch(String s, String p) {
//         int m = s.length();
//         int n = p.length();
//         boolean[][] dp =new boolean[m+1][n+1];
//         //首先给了 *，明白 * 的含义是 匹配零个或多个前面的那一个元素，
//         //所以要考虑他前面的元素 p[j-2]。* 跟着他前一个字符走，前一个能匹配上 s[i-1]，* 才能有用，
//         //前一个都不能匹配上 s[i-1]，* 也无能为力，只能让前一个字符消失，也就是匹配 0 次前一个字符。
//         dp[0][0] = true;
//         //dp[i][j] 指s的前i个字符串和p的前j个字符串能否匹配

//         //当i=0，表示s是空字符串，初始化首行
//         for(int j=2; j<n+1; j++){
//             dp[0][j] = p.charAt(j-1)=='*' && dp[0][j-2];
//         }
//         //要想看两个字符串是否匹配 其实无非就三种情况
//         //1. p[j-1] == s[i-1]   2.p[j-1]='.' 3.p[j-1]='*'  那总结下来无非就是两大类== 和 ！='*
//         for(int i = 1; i <= m; i++) {
//             for(int j = 1; j <= n; j++) {
//                 if(p.charAt(j-1) != '*'){//那就有p.charAt(j-1)==s.charAt(i-1)或者p.charAt(j-1)=='.'这两种情况
//                     if(p.charAt(j-1) == s.charAt(i-1)|| p.charAt(j-1) == '.'){
//                         dp[i][j] = dp[i-1][j-1];
//                     }    
//                 }else{
//                     //*"前面一个数字的存在（但*继续没有， *还是在j-1的位置） (1)
//                     if(p.charAt(j-2) != s.charAt(i-1) ) {// 模式串*的前一个字符不能够跟文本串的末位匹配, "*"和前面一个数字消失,（0）次 
//                         if(dp[i][j-2]){//"*"和前面一个数字消失的情况（aab 和 aabc* 就是这种情况
//                             dp[i][j]= dp[i][j-2];
//                         } 
//                     }
//                     if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
//                         dp[i][j] = dp[i][j-2]|| dp[i][j-1] || dp[i-1][j];
//                         //前面是"*"和前面一个数字消失的情况（aab 和 aab.*/aabb*就是第一种情况）， 中间那个是*让前面数字出现一次的情况， 后米那个是出现>1次的情况
//                         //这三个情况都要顾及，因为上面考虑的是p.charAt(j-2) != s.charAt(i-1)的情况，那只能是消失，因为没得选
//                         //但是p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'的时候，三种情况都有可能是true，所以都要考虑
//                         //
//                     } 
                   
//                 }
//             }
//         }    
//         return dp[m][n];
//     }
// }


class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp =new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i=1; i<=m; i++){
            dp[i][0] = false;
        }

        for(int j=2; j<=n; j++){
            if(p.charAt(j-1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
            
        }
  
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) == s.charAt(i-1)){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
                    }else if(p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }else{// p.charAt(j-2) != s.charAt(i-1)  这个一定要放在最后！！！
                        dp[i][j] = dp[i][j-2];
                    }
                    
                }
            }
        }

        return dp[m][n];
    }
}
