class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char res = '\0';
        //1.iterate the s: it position +1
        //2..iterate
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            arr[c - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(arr[i] == -1){
                res = (char) (i+'a');
                break;
            }
        }

        return res;
        
    }
}