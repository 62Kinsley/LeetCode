class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int res = 0;
        boolean[] sortedRow = new boolean[n];
    // col:0 1  2
    //     c a, d 
    //     b b, b
    //     a c  a

        for (int col = 0; col < m; col++) {
            boolean needDelete = false;

            for (int row = 0; row < n - 1; row++) {

                if(!sortedRow[row] && strs[row].charAt(col) > strs[row+1].charAt(col)){
                    needDelete = true;
                    break;
                }
            }

            if(needDelete){
                res++;
            }else{
                for(int row = 0; row < n - 1; row++){
                    if(!sortedRow[row] && strs[row].charAt(col) < strs[row+1].charAt(col)){
                        sortedRow[row] = true;
                    }
                    
                }
            }
        }

        return res;
       
    }
}