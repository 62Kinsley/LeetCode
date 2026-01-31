// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//         for (int num : nums) {
//             minHeap.add(num);
//             if (minHeap.size() > k) {
//                 minHeap.poll();  // 把最小的弹出
//             }
//         }

//         return minHeap.peek(); // 剩下的就是前 k 大中的最小值（第 k 大）
//     }
// }

//time:n space:n

//quickselect
//  class Solution {
// 
//     private final static Random RANDOM = new Random(System.currentTimeMillis());

//     public int findKthLargest(int[] nums, int k) {
//         int n = nums.length;
//         int left = 0;
//         int right = n - 1;
//         int target = n - k;
//         while (true) {
//             int pivot = partition(nums, left, right);

//             if (pivot == target) {
//                 return nums[pivot];
//             } else if (pivot < target) {
//                 left = pivot+ 1;
//             } else {
//                 right = pivot - 1;
//             }
//         }
//     }

//     private int partition(int[] nums, int left, int right) {
//         // nums[left + 1..le) <= pivot，nums(ge..right] >= pivot;
//         int pivot = nums[left];//0
//         int l = left + 1;
//         int r = right;
//         while (true) {
//             while (l <= r && nums[l] < pivot) {
//                 l++;
//             }
//             while (l <= r && nums[r] > pivot) {
//                 r--;
//             }
//             if (l > r) {
//                 break;
//             }
//             swap(nums, l, r);//因为前面的指针都移动到不能再移动了，这时候说明l指向的元素比pivot要大， r指向的要比pivot小，所以可以交换
//             l++;
//             r--;
//         }
//         swap(nums, left, r);
//         return r;
//     }

//     private void swap(int[] nums, int index1, int index2) {
//         int temp = nums[index1];
//         nums[index1] = nums[index2];
//         nums[index2] = temp;
//     }

// }


// divide conquer
// class Solution {
//     private int quickSelect(List<Integer> nums, int k) {
//         // 随机选择基准数
//         Random rand = new Random();
//         int pivot = nums.get(rand.nextInt(nums.size()));
//         // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
//         List<Integer> big = new ArrayList<>();
//         List<Integer> equal = new ArrayList<>();
//         List<Integer> small = new ArrayList<>();
//          for (int num : nums) {
//             if (num > pivot) {
//                 big.add(num);
//             } else if (num < pivot) {
//                 small.add(num);
//             } else {
//                 equal.add(num);
//             }
//         }
//         // 第 k 大元素在 big 中，递归划分
//         if (k <= big.size()){
//             return quickSelect(big, k);
//         }
           
//         // 第 k 大元素在 small 中，递归划分
//         if (nums.size() - small.size() < k)
//             return quickSelect(small, k - nums.size() + small.size());

//         // 第 k 大元素在 equal 中，直接返回 pivot
//         return pivot;
//     }
    
//     public int findKthLargest(int[] nums, int k) {
//         List<Integer> numList = new ArrayList<>();
//         for (int num : nums) {
//             numList.add(num);
//         }
//         return quickSelect(numList, k);
//     }
// }

class Solution{
    public int findKthLargest(int[] nums, int k){
         List<Integer> list = new ArrayList<>();
         for(int num : nums){
            list.add(num);
         }
         return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> nums, int k){
        Random r = new Random();
        int randomIndex = r.nextInt(nums.size());
        int pivot = nums.get(randomIndex);

        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for(int num: nums){
            if(num > pivot){
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }

        if(big.size() >= k){
            return quickSelect(big, k);
        }

        if(big.size()+ equal.size() < k){
            return quickSelect(small, k-(big.size()+ equal.size()));
        }

        return pivot;
    }
}
