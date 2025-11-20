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

//         return res;

//     }

//     public int xSum(int[] nums, int start, int k, int x) {

//         //[1,1,2,2,3,4,2,3]
//            0 1 2 3 4 5 6
//         //[0 2 2 1 1 0 0]
//         int[] freq = new int[51];
//         for(int i=start; i<= start+k-1; i++){
//             sum += nums[i];
//             if (freq[nums[i]] == 0) {
//                 distinctCount++;
//             }
//             freq[nums[i]]++;
//         }
//         // an array has less than x distinct elements
//         if (distinctCount < x) {
//             return sum;
//         }

//         sum = 0;

//         for (int pick = 0; pick < x; pick++) {
//             int bestFreq = -1;
//             int bestVal = -1;

//             for (int val = 50; val >= 1; val--) {
//                 if (freq[val] > bestFreq) {
//                     bestFreq = freq[val];
//                     bestVal = val;
//                 }
//             }

//             if (bestVal != -1) {
//                 sum += bestVal * bestFreq;
//                 freq[bestVal] = 0;
//             }
//         }
        

//     }

// }

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        final var n = nums.length;
        final var m = n - k + 1;
        final var ans = new int[m];
        for (var i = 0; i < m; i++) {
            ans[i] = xsum(nums, i, k, x);
        }
        return ans;
    }

    private int xsum(int[] arr, int i, int k, int x) {
        var freq = new int[51];
        for (int j = i; j < i + k; j++) {
            freq[arr[j]]++;
        }

        var maxHeap = new PriorityQueue<Integer>(k, (a, b) -> {
            if (freq[a] == freq[b]) {
                return b - a;
            }
            return freq[b] - freq[a];
        });
        for (int z = 0; z < freq.length; z++) {
            if (freq[z] > 0) {
                maxHeap.offer(z);
            }
        }
        var ans = 0;
        while (x-- > 0 && !maxHeap.isEmpty()) {
            var alpha = maxHeap.poll();
            ans += alpha * freq[alpha];
        }
        return ans;
    }
}


