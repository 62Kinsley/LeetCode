// class Excel {

//     int[][] excel;
//     Map<String,  String[]> formulas;
//     Map<String, Integer> cache; 
//     public Excel(int height, char width) {
//         int col = width - 'A';
//         excel = new int[height][col+1];
//         formulas = new HashMap<>();
//         cache = new HashMap<>();
        
//     }
    
//     public void set(int row, char column, int val) {
//         String key = row + "," + (column - 'A');
//         formulas.remove(key);
//         excel[row - 1][column - 'A'] = val;
//         cache.clear();
//     }
    
//     public int get(int row, char column) {
//         String key = row + "," + (column - 'A');
//         if (cache.containsKey(key)) return cache.get(key);

//         if(formulas.containsKey(key)){
//             String[] numbers = formulas.get(key);
//             return calcSum(numbers);
//         }
//         return excel[row - 1][column - 'A'];
//     }
    
//     public int sum(int row, char column, String[] numbers) {
//         String key = row + "," + (column - 'A');
//         formulas.put(key, numbers);
//         return calcSum(numbers);
//     }

//     private int calcSum( String[] numbers) {
//         int sum = 0;
//         for (String num : numbers) {
//             if (num.contains(":")) {//A1:B2
//                 String[] parts = num.split(":");  // parts[0] = "A1", parts[1] = "B2"
//                 char c1 = parts[0].charAt(0);  //'A'
//                 int  r1 = Integer.parseInt(parts[0].substring(1));// 1
//                 char c2 = parts[1].charAt(0);  // 'C'
//                 int  r2 = Integer.parseInt(parts[1].substring(1)); // 3

//                  // 遍历矩形内每一格
//                 for (int r = r1; r <= r2; r++) {
//                     for (char c = c1; c <= c2; c++) {
//                         sum += get(r, c);  // 递归调用get！
//                     }
//                 }
//             }
//             else{//"A1"
//                 char col = num.charAt(0);
//                 int  row = Integer.parseInt(num.substring(1));
//                 sum += get(row, col);
//             }
//         }
//         return sum;
//     }
// }

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */

class Excel {
    int[][] excel;
    Map<String, String[]> formulas;
    Map<String, Integer> cache;  // ← 加缓存

    public Excel(int height, char width) {
        int col = width - 'A';
        excel = new int[height][col + 1];
        formulas = new HashMap<>();
        cache = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        String key = row + "," + (column - 'A');
        formulas.remove(key);
        excel[row - 1][column - 'A'] = val;
        cache.clear();  // ← 值变了，清缓存
    }

    public int get(int row, char column) {
        String key = row + "," + (column - 'A');
        
        // 已经算过了，直接返回
        if (cache.containsKey(key)) return cache.get(key);
        
        int result;
        if (formulas.containsKey(key)) {
            result = calcSum(formulas.get(key));
        } else {
            result = excel[row - 1][column - 'A'];
        }
        
        cache.put(key, result);  // ← 存入缓存
        return result;
    }

    public int sum(int row, char column, String[] numbers) {
        String key = row + "," + (column - 'A');
        formulas.put(key, numbers);
        cache.clear();  // ← 公式变了，清缓存
        return calcSum(numbers);
    }

    private int calcSum(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            if (num.contains(":")) {
                String[] parts = num.split(":");
                char c1 = parts[0].charAt(0);
                int r1 = Integer.parseInt(parts[0].substring(1));
                char c2 = parts[1].charAt(0);
                int r2 = Integer.parseInt(parts[1].substring(1));
                for (int r = r1; r <= r2; r++) {
                    for (char c = c1; c <= c2; c++) {
                        sum += get(r, c);
                    }
                }
            } else {
                char col = num.charAt(0);
                int r = Integer.parseInt(num.substring(1));
                sum += get(r, col);
            }
        }
        return sum;
    }
}