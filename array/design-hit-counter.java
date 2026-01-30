// class HitCounter {
    
//     private int[] times;
//     private int[] hits;
//     public HitCounter() {
//         map  = new HashMap<>();
//         count = 0;
//     }
    
//     public void hit(int timestamp) {
//         map.put(timestamp, count+1);//2, 1+1
//         count++;//1
        
//     }
    
//     public int getHits(int timestamp) {
//         if(timestamp <= 300){
//             return map.get(timestamp);
//         }else{
//             map.get()
//         }
//     }
// }
 class HitCounter {
        Queue<Integer> q = null;
        /** Initialize your data structure here. */
        public HitCounter() {
            q = new LinkedList<Integer>();
        }
        
        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            q.offer(timestamp);
        }
        
        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while(!q.isEmpty() && timestamp - q.peek() >= 300) {
                q.poll();
            }
            return q.size();
        }
    }
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */