class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		long ans = 0;
		int[] arr = new int[100010];
		for(int i=0;i<nums1.length;i++) {
			arr[Math.abs(nums1[i]-nums2[i])]++;
		}
		int k = k1+k2;
		int i=100000;
		for(;i>=1;i--) {
			if(arr[i] == 0) continue;
			if(k>arr[i]) {
				arr[i-1] += arr[i];
                                k -= arr[i];    //一开始忘记了
				//arr[i] = 0
			}else if(k == arr[i]) {
                               arr[i-1] += arr[i]; //一开始忘记了
				i--;
                                k = 0;
				break;
			}else {
				arr[i-1] += k;
				arr[i] -= k;
				break;
			}
		}
		for(;i>=1;i--) {
			if(arr[i] == 0) continue;
			ans += (long)i*i*arr[i];
		}
		return ans;
    }
}


// 5 3
// 4 2 = 16+ 4
// 3 3 = 9 + 9 = 18

// [1,4,10,12] > k1 = |gap1|     gap1- gap2   gap1 > gap2  缩小到gap2的距离就行   gap1绝对值和gap绝对值相差越小越好
// [5,8, 6, 9] > k2  = |gap2|                 gap1 < gap2   缩小到gap1的距离就行
// 4  4  4  3

// sum1 > k1 +  ｜nums1｜   gap1- gap2      gap1 > gap2   gap1越小越好（+） gap2越大越好（0） 
// sum2 <k2  -   |nums2| 

// sum1 < k1 -   ｜nums1｜ gap1- gap2   gap1 < gap2    gap1越大越好（0） gap2越小越好（0）
// sum2 >k2  +    |nums2| 
//                                                 -2    -5
// sum1 < k1 == -2   ｜nums1｜    gap1- gap2       gap1 > gap2   gap1绝对值和gap绝对值相差越小越好
// sum2 <k2  == -3    |nums2| 

// |-2| |-3|


// 4:3
// 3:1
