// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         // 优先级队列，保存 [index1, index2]
//         PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));

//         // 把 nums1 的所有索引入队，nums2 的索引初始时都是 0
//         // 优化：最多入队 k 个就可以了，因为提示中 k 的范围较小，这样可以提高效率
//         for (int i = 0; i < Math.min(k, nums1.length); i++) {
//             heap.offer(new int[] {i, 0});//[0,0][1,0][2,0]

//         }

//         List<List<Integer>> ans = new ArrayList<>();

//         // 最多弹出 k 次
//         while (k > 0 && !heap.isEmpty()) {//k=1, [0,2][1,0][2,0]
//             int[] pos = heap.poll();//
//             int index1 = pos[0], index2 = pos[1];//0, 2

//             ans.add(Arrays.asList(nums1[index1], nums2[index2]));[1,6]

//             index2++;//index2在第18行定义了 3
//             // 将 index2 加 1 之后继续入队
//             if (index2 < nums2.length) {
//                 heap.offer(new int[]{index1, index2});//[0,2]
//             }
//             k--;//0
//         }

//         return ans;
//     }
// }


// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

//         //int[] 存的是int[]{index1，index}
//         PriorityQueue<int[]>  heap = new PriorityQueue<>((a,b) -> (nums1[a[0]]+ nums2[a[1]]) - (nums1[b[0]]+ nums2[b[1]]));

//         for(int i=0; i<Math.min(k, nums1.length); i++){
//             heap.add(new int[]{i, 0});
//         }
//         List<List<Integer>> res = new ArrayList<>();

//         while(k-- > 0 && !heap.isEmpty()){

//             int[] index = heap.poll();
//             int index1 = index[0], index2 = index[1];

//             List<Integer> path = new ArrayList<>();
//             res.add(Arrays.asList(nums1[index1], nums2[index2]));

//             if(++index2 < nums2.length){
//                 heap.add(new int[]{index1, index2});
//             }


//         }
    
//         return res;
//     }
// }

class Solution {
    int[] nums1, nums2;
    int n, m;
    public List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
        nums1 = n1; nums2 = n2;
        n = nums1.length; m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums1[0] + nums2[0], r = nums1[n - 1] + nums2[m - 1];
        while (l < r) {
            int mid = (int)(0L + l + r >> 1);
            if (check(mid, k)) r = mid;
            else l = mid + 1;
        }
        int x = r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] + nums2[j] < x) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]); temp.add(nums2[j]);
                    ans.add(temp);
                } else break;
            }
        }
        for (int i = 0; i < n && ans.size() < k; i++) {
            int a = nums1[i], b = x - a;
            int c = -1, d = -1;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = (int)(0L + l + r >> 1);
                if (nums2[mid] >= b) r = mid;
                else l = mid + 1;
            }
            if (nums2[r] != b) continue;
            c = r;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = (int)(0L + l + r + 1) >> 1;
                if (nums2[mid] <= b) l = mid;
                else r = mid - 1;
            }
            d = r;
            for (int p = c; p <= d && ans.size() < k; p++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(a); temp.add(b);
                ans.add(temp);
            }
        }
        return ans;
    }
    boolean check(int x, int k) {
        int ans = 0;
        for (int i = 0; i < n && ans < k; i++) {
            for (int j = 0; j < m && ans < k; j++) {
                if (nums1[i] + nums2[j] <= x) ans++;
                else break;
            }
        }
        return ans >= k;
    }
}

