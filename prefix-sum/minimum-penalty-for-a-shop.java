class Solution {
    public int bestClosingTime(String customers) {
        //
        int times = customers.length();
    
        // 4: 0+0+1+0
        //    Y Y N Y
        // 3: 0+0+1+1
        // 2: 0+0+0 +1
        // 1: 0+

        // List<Integer>[] penalty = new ArrayList[times+1];//penalty:<time>
        int count = 0;
        
        int res = times;
        for(char c :customers.toCharArray() ){
            if(c == 'N'){
                count++;
            }
        }
        int minPenalty = count;


        for(int i=times-1; i>=0; i--){//现在是关门状态
            char c = customers.charAt(i);
            if(c == 'Y'){//如果有人来，那罚款就比刚刚开门的时候多
                count++;
            }
            if (c == 'N'){//如果没有人来，因为刚刚是开门，没人来就要扣款， 现在是关门，没人来就没关系，所以不用扣款，把刚刚的扣款减掉
                count--;
            }

           if(count <= minPenalty){
                res = i;
                minPenalty = count;
           }
        }
        
        return res;
    }
}