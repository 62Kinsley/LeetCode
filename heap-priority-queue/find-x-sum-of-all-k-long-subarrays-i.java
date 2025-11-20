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
    public int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < result.length; i++) {
            int left = i, right = i + k - 1;
            result[i] = findXSumofSubArray(nums, left, right, x);
        }

        return result;
    }

    private int findXSumofSubArray(int[] nums, int left, int right, int x) {
        int sum = 0, distinctCount = 0;
        int[] freq = new int[51]; 

        for (int i = left; i <= right; i++) {
            sum += nums[i];
            if (freq[nums[i]] == 0) {
                distinctCount++;
            }
            freq[nums[i]]++;
        }

        if (distinctCount < x) {
            return sum;
        }

        sum = 0;
        for (int pick = 0; pick < x; pick++) {
            int bestFreq = -1;
            int bestVal = -1;

            for (int val = 50; val >= 1; val--) {
                if (freq[val] > bestFreq) {
                    bestFreq = freq[val];
                    bestVal = val;
                }
            }

            if (bestVal != -1) {
                sum += bestVal * bestFreq;
                freq[bestVal] = 0;
            }
        }
        
        return sum;
    }
}