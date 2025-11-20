// class Solution {
//     public int[] findXSum(int[] nums, int k, int x) {

//         //[1,1,2,2,3,4,2,3], k = 6, x = 2
//         // [6,10,12]
//         //1. hashmap store the freq for the first k element subarray
//         //1:2  2:2  3:1 4:1
//         //2.add the map to maxheap
//         //3.calculate the sum of the first k element*times
//         //sliding window, move the right point to next, left pointer also move to next

//         int[] res = new int[n-k+1];
//         for (int i = 0; i < m; i++) {
//             res[i] = xsum(nums, i, k, x);
//         }

//     }

//     public int xSum(int[] nums, int start, int k, int x) {

//         //[1,1,2,2,3,4,2,3]
//            0 1 2 3 4 5 6
//         //[0 2 2 1 1 0 0]
//         int[] record = new int[51];
//         for(int i=start; i<nums.length; i++){
//             int index = nums[i];
//             record[index]++;
//         }

//         PriorityQueue<Map<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> )

//     }

// }


class Solution {

    private int find(Map<Integer, Integer> freqMap, int x) {
        // Max-heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int sum = 0;
        // Get the top x most frequent elements
        while (x-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int freq = top[0];
            int num = top[1];
            // Add all occurrences of this number to sum
            sum += num * freq;
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);

            // Shrink the window if it exceeds size k
            while (l < r && (r - l + 1) > k) {
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                if (freqMap.get(nums[l]) == 0) {
                    freqMap.remove(nums[l]);
                }
                l++;
            }

            // If window size == k, compute the X-sum
            if ((r - l + 1) == k) {
                resultList.add(find(freqMap, x));
            }
        }

        // Convert List<Integer> → int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
