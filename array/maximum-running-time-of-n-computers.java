// class Solution {
//     public long maxRunTime(int n, int[] batteries) {
        
//     }

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }
        
        // 二分查找的范围
        long left = 0, right = sum / n;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            // 所有电池能提供的最大有效电量
            long valid_power = 0;
            for (int b : batteries) {
                valid_power += Math.min(b, mid);
            }

            if (valid_power >= (long) n * mid) {
                // mid 可行，尝试更大的时间
                left = mid + 1;
            } else {
                // mid 太大，需要减小目标
                right = mid - 1;
            }
        }

        // 循环结束时，left 指向 right + 1
        return right;
    }
}

