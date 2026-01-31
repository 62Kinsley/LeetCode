//考 PriorityQueue的题  215 692

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         //1.hashmap record the freq

//         Map<Integer,Integer> map = new HashMap<>();
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         //2. heap to get the fre

//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));


//         for(int key : map.keySet()){//[1,2,3]
//             maxHeap.add(key);
//         }

//         //3.get the k  most frequent elements
//         int[] res = new int[k];
//         for(int i= 0; i<k; i++){
//             res[i] = maxHeap.poll();
//         }

//         return res;
//     }
// }
//Time Complexity :- O(n+nlogn+klogn)=O(nlogn)  （因为 k ≤ n，所以 k log n 被包含在 n log n 中），第四步：大O记号简化
// 根据大O记号的定义，当有两项相加时，保留增长速度更快的项：
// n 的增长速度：线性
// n log n 的增长速度：超线性
// 因为 n log n 比 n 增长得更快，所以：
// O(n + n log n) = O(n log n)

//Space Complexity :HashMap map 存储每个元素及其频率：最多有 n 个不同元素 → O(n)
// PriorityQueue maxHeap 也最多存储 n 个元素 → O(n)
// 结果数组 res 大小为 k → O(k)
// ✅ 总空间复杂度：O(n)


//o(n) time complexity
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // 1. 统计频率
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         for (int num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//         }

//         // 2. 建立桶，桶的index是频率
//         List<Integer>[] bucket = new ArrayList[nums.length + 1];
//         for (int key : freqMap.keySet()) {
//             int freq = freqMap.get(key);
//             if (bucket[freq] == null) {
//                 bucket[freq] = new ArrayList<>();
//             }
//             bucket[freq].add(key);
//         }

//         // 3. 从后往前取前k个
//         List<Integer> res = new ArrayList<>();
//         for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
//             if (bucket[i] != null) {
//                 res.addAll(bucket[i]);
//             }
//         }

//         // 4. 转为数组返回
//         return res.stream().mapToInt(i -> i).toArray();
//     }
// }


//bucket:  [<integer>,<integer>,<integer>]
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);//1:1
        }

        List<Integer>[] bucket = new ArrayList[n+1];//这里的长度记得一定是n+1！
   
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);//1:《3》 2:<2> 3:<1>
        }

        List<Integer> res = new ArrayList<>();
        for(int i=n; i>0; i--){//1
            if(bucket[i] != null && res.size() < k){
                res.addAll(bucket[i]);//1
            }
        }

        int[] ans = new int[k];
        int index = 0;
        for(int j=0; j<k; j++) {
                ans[index++] = res.get(j);
        }

        return ans;

    }
}
