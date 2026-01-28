// 这道题要区分substring（连续的）和subsequence的概念
// 要考虑好while（set.contains(cur)）怎么放 放哪里
// class Solution{
//     public int lengthOfLongestSubstring(String s){
            
//         HashSet<Character> set = new HashSet<>();

//         int l=0, n = s.length();
//         int res = 0;

//         for(int r=0; r<n; r++){

//             while(set.contains(s.charAt(r))){
//                 set.remove(s.charAt(l));
//                 l++;
//             }

//             set.add(s.charAt(r));
//             res = Math.max(res, r-l+1);
            
//         }

//         return res;
//     }
// }
//时间复杂度：O(n)
//space: O(1)
//bc
//   r
//abcabcbb
//l
class Solution{
    public int lengthOfLongestSubstring(String s){

        int l=0;
        int res=0;
        Set<Character> set = new HashSet<>();

        for(int r= 0; r < s.length(); r++){

            char c = s.charAt(r);

            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            res = Math.max(res, r-l+1);

        }
        return res;

    }
}
 
 //sliding window and hashset

// class Solution{
//     public int lengthOfLongestSubstring(String s){
//         int l=0, r=0;
//         Set<Character> set = new HashSet<>();
//         int res = 0;
//         while(r < s.length()){

//             char right = s.charAt(r);
//             while(l<=r && set.contains(right)){
//                 char left = s.charAt(l);
//                 set.remove(left);
//                 l++;
//             }
//             set.add(right);
//             res = Math.max(r-l+1, res);
//             r++;
//         }

//         return res;
//     }
// }
