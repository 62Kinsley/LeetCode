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
        int n = nums.length;
        int[] ans = new int[Math.max(0, n - k + 1)];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = computeXSum(freq, x);

        for (int i = k; i < n; i++) {
            int add = nums[i];
            int rem = nums[i - k];

            freq.put(add, freq.getOrDefault(add, 0) + 1);
            int fr = freq.get(rem) - 1;
            if (fr == 0) freq.remove(rem);
            else freq.put(rem, fr);

            ans[i - k + 1] = computeXSum(freq, x);
        }

        return ans;
    }

    private int computeXSum(Map<Integer, Integer> freq, int x) {
        List<int[]> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            items.add(new int[]{e.getKey(), e.getValue()});
        }
        items.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });
        long sum = 0;
        int take = Math.min(x, items.size());
        for (int i = 0; i < take; i++) {
            sum += 1L * items.get(i)[0] * items.get(i)[1];
        }
        return (int) sum;
    }
}