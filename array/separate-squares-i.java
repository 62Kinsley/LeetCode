class Solution {
    public double separateSquares(int[][] squares) {
            //浮点数二分不能用 ±1!!!!!
        double low = Double.MAX_VALUE,  high = 0; 
        
        for(int[] square: squares){
            int y = square[1];
            int l = square[2];
            low = Math.min(y, low); 
            high = Math.max(y+l, high);   
        }

        while(high - low > 1e-7){
        
            double mid = low + (high-low)/2.0;

            if(check(squares, mid)){
                high = mid;
            }else{//above > below
                low = mid;
            }
            
        }

        return low;
        
    }

    public boolean check(int[][] squares, double target){

        double above = 0, below = 0;

        for(int[] square : squares){
           
            int y = square[1];
            int l = square[2];

            if(y+l <= target){
                below += (double)l*l;
            }
            else if(y >= target){
                above += (double)l*l;
            }

            else{
                below += (double)l*(target-y);
                above += (double)l*(y+l-target);
            }
        }

        return above <= below;

        
    }
}