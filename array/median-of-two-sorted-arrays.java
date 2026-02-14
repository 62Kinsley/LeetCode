//题目是求中位数，其实就是求第 k 小数的一种特殊情况，而求第 k 小数有一种算法。
//1.奇数/ 偶数
// 13/2=6

//1.在两个array之中 第k小个数字
//(13+1)/2 = 7(第七个小的数，非index) -> 要把前7个数找出来， 找到了3个（1，2，3）,又找到两个（2，3），又找到1个                   
// nums1:    [1,1,4      ,9]                                
// nums2: [1,2,3,120,  [5,6,7,8,9]      
// 7/2 = 3 个小的，在nums2里找到了                              
// (7-3) = 4 -> 4/2=2
// (4-2) = 2 -> 2/2 = 1
// （2-1） = 1 return nums2[1]


class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        //1.check the total length of nums1+nums2
        //find the kth largest element beteewn nums1+nums2:
        //if odd -> (length+1)/2  even-> length/2 and (length/2 + 1)
        int len1 = nums1.length, len2 = nums2.length;
        if((len1+len2) % 2 == 0){

            int k1 = getKth(nums1, nums2, (len1+len2)/2, 0, 0);
            int k2 = getKth(nums1, nums2, (len1+len2)/2+1, 0, 0);
            return (k1+k2)/2.0;
        }else{
            int k = getKth(nums1, nums2, (len1+len2+1)/2, 0, 0);
            return k/1.0;
        }

    }

    public int getKth(int[] nums1, int[] nums2, int k, int i, int j ){

          //i到边界了，就在nums2里找      
        if(i >= nums1.length){
            return nums2[j+k-1];//这里要注意，从j开始算！
        }

        if(j >= nums2.length){
            return nums1[i+k-1];//同理
        }

        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }

        
        int mid = k/2;
        int len1 = nums1.length - i;
        int len2 = nums2.length - j;

        int step1 = Math.min(len1, mid);
        int step2 = Math.min(len2, mid);

        if(nums1[i+step1-1] <= nums2[j+step2-1]){
            return getKth(nums1, nums2, k-step1, i+step1, j);
        }else{
            return getKth(nums1, nums2, k-step2, i, j+step2);
        }
    }
}



