class Solution {
    public int firstUniqChar(String s) {
        
        int n = s.length();
        int res = -1;
        int[] arr = new int[26];

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(arr[c-'a'] == 1){
                res = i;
                break;
            }
        }

        return res;
    }
}