// class Solution {
//     public String frequencySort(String s) {
//         //1.caculate the fre of every characrt : hash arry
//         [3,6,4,6,7......,9,100,30]
//         //2. buket to store the frq that have which char
//         //List<Character>[] = new ArrayList<>[];
//         [<b, a, H,>, ...., <j, F, l>...<>]
//         //StringBuilder to store the ans

//         int[] arr = new int[128];
//         for(char c: s.toCharArray()){
//             arr[c-'a']++;
//         }
        
//     }
// }

class Solution {
    public String frequencySort(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        // 构造 HashMap。Key：s 中的每个元素；Value：对应元素出现的次数（即频率）
        Map<Character, Integer> store = new HashMap<>();

        for (char c : s.toCharArray()) {
            // 填充 HashMap。如果当前 Key c 不存在，getOrDefault() 方法返回默认值 0；
            // 否则返回当前 Key c 对应的 Value。
            // 不管哪种情况最后都在 0 或者 Value 的基础上 +1。
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        // 构造一个桶的集合（即一系列桶），桶的个数为 s 的长度 +1，因为 buckets[0] 没有意义
        // 目的是将出现频率为 i 的字符放到第 i 个桶里（即 buckets[i]）
        List<Character>[] buckets = new List[s.length() + 1];

        for (char key : store.keySet()) {
            // 某个字符在 HashMap 中的 Value 是几就会被放到第几个桶里
            int value = store.get(key);

            if (buckets[value] == null) {
                // 如果某个桶还未放入过字符（即未初始化），则初始化其为一个数组
                buckets[value] = new ArrayList<Character>();
            }

            buckets[value].add(key); // 然后将字符放到桶中
        }

        StringBuilder res = new StringBuilder();

        for (int i = buckets.length - 1; i > 0; --i) {
            // 遍历每个桶
            if (buckets[i] != null) {
                // 如果桶里有字符
                for (char j : buckets[i]) {
                    // 遍历桶里的每个字符
                    for (int k = i; k > 0; --k) {
                        // 字符出现了几次就向 res 中添加几次该字符
                        res.append(j);
                    }
                }
            }
        }

        return res.toString();
    }
}
