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

// class Excel {
//     int[][] excel;
//     Map<String, String[]> formulas;
//     Map<String, Integer> cache;  // ← 加缓存

//     public Excel(int height, char width) {
//         int col = width - 'A';
//         excel = new int[height][col + 1];
//         formulas = new HashMap<>();
//         cache = new HashMap<>();
//     }

//     public void set(int row, char column, int val) {
//         String key = row + "," + (column - 'A');
//         formulas.remove(key);
//         excel[row - 1][column - 'A'] = val;
//         cache.clear();  // ← 值变了，清缓存
//     }

//     public int get(int row, char column) {
//         String key = row + "," + (column - 'A');
        
//         // 已经算过了，直接返回
//         if (cache.containsKey(key)) return cache.get(key);
        
//         int result;
//         if (formulas.containsKey(key)) {
//             result = calcSum(formulas.get(key));
//         } else {
//             result = excel[row - 1][column - 'A'];
//         }
        
//         cache.put(key, result);  // ← 存入缓存
//         return result;
//     }

//     public int sum(int row, char column, String[] numbers) {
//         String key = row + "," + (column - 'A');
//         formulas.put(key, numbers);
//         cache.clear();  // ← 公式变了，清缓存
//         return calcSum(numbers);
//     }

//     private int calcSum(String[] numbers) {
//         int sum = 0;
//         for (String num : numbers) {
//             if (num.contains(":")) {
//                 String[] parts = num.split(":");
//                 char c1 = parts[0].charAt(0);
//                 int r1 = Integer.parseInt(parts[0].substring(1));
//                 char c2 = parts[1].charAt(0);
//                 int r2 = Integer.parseInt(parts[1].substring(1));
//                 for (int r = r1; r <= r2; r++) {
//                     for (char c = c1; c <= c2; c++) {
//                         sum += get(r, c);
//                     }
//                 }
//             } else {
//                 char col = num.charAt(0);
//                 int r = Integer.parseInt(num.substring(1));
//                 sum += get(r, col);
//             }
//         }
//         return sum;
//     }


import java.util.*;

class Excel {
    // 存储每个格子的当前最终值
    private int[][] values;
    // 存储每个格子的公式（如果它是公式格的话）
    // Key: 单元格ID (row * width + col), Value: 该公式包含的所有引用范围
    private Map<Integer, List<String>> formulas;
    private int width;

    public Excel(int height, char widthChar) {
        this.width = widthChar - 'A' + 1;
        this.values = new int[height + 1][this.width];
        this.formulas = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        int r = row, c = column - 'A';
        int id = r * width + c;
        
        // 1. 如果之前是公式格，现在变数值了，删除公式记录
        formulas.remove(id);
        
        // 2. 更新当前值
        int diff = val - values[r][c];
        values[r][c] = val;
        
        // 3. 核心：主动触发依赖更新（或者简单起见，递归更新所有受影响的公式）
        updateDependentCells();
    }

    public int get(int row, char column) {
        // O(1) 速度，直接拿值
        return values[row][column - 'A'];
    }

    public int sum(int row, char column, String[] numbers) {
        int r = row, c = column - 'A';
        int id = r * width + c;
        
        // 1. 记录公式（存入 List 方便后续重复计算）
        formulas.put(id, Arrays.asList(numbers));
        
        // 2. 计算当前和并存入 values
        values[r][c] = calculateFormula(numbers);
        
        // 3. 同样需要更新那些依赖“当前这个求和格”的其他格子
        updateDependentCells();
        
        return values[r][c];
    }

    // 重新计算所有公式格（在 LeetCode 规模下，这种全量更新比复杂的拓扑排序更稳）
    private void updateDependentCells() {
        // 因为公式之间可能有套娃（A依赖B，B依赖C），我们需要多次遍历直到数据不再变化
        // 或者简单地按照公式定义的顺序递归计算
        // 这里的技巧是：只要有值变了，就可能触发连带反应
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Integer id : formulas.keySet()) {
                int r = id / width;
                int c = id % width;
                int newVal = calculateFormula(formulas.get(id).toArray(new String[0]));
                if (values[r][c] != newVal) {
                    values[r][c] = newVal;
                    changed = true;
                }
            }
        }
    }

    // 辅助方法：解析公式字符串并求和
    private int calculateFormula(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            if (s.contains(":")) {
                String[] parts = s.split(":");
                int r1 = Integer.parseInt(parts[0].substring(1));
                int c1 = parts[0].charAt(0) - 'A';
                int r2 = Integer.parseInt(parts[1].substring(1));
                int c2 = parts[1].charAt(0) - 'A';
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        sum += values[i][j];
                    }
                }
            } else {
                int r = Integer.parseInt(s.substring(1));
                int c = s.charAt(0) - 'A';
                sum += values[r][c];
            }
        }
        return sum;
    }
}