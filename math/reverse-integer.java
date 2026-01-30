// class Solution {
//     public int reverse(int x) {
        
//         int res = 0;
        
//         while(x !=0){

//             int reminder = x % 10;//求余
           
//             // 溢出判断（正数情况）
//             if(res > Integer.MAX_VALUE / 10  || (res == Integer.MAX_VALUE / 10 && reminder > 7)){
//                 return 0;
//             }
//            // 溢出判断（负数情况）
//            if(res <  Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && reminder < -8)){
//                 return 0;
//            }

//             x = x /10;
//             res = res * 10 + reminder ;
//         }
//         return res;
        


//     }
// }

//：[-2147483648, 2147483647]: -2的31次方 <= x <= 2的31次方， - 1

class Solution{
    public int reverse(int x){
        int res = 0;
        
        while(x != 0){

            int mod = x% 10;
            
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && mod > 7)){
                return 0;
            }

            if(res < Integer.MIN_VALUE/10 ||  (res == Integer.MIN_VALUE/10 && mod < -8)){
                return 0;
            }

            x = x/10;
            res = res*10 + mod;
          
        }

        return res;
    }
}