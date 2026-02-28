// class Excel {

//     int[][] excel;
//     Map<Integer, List<String>> formulas;// formulas 存储：当前格 ID -> {引用格 ID : 出现次数}
//     int cols;
//     public Excel(int height, char width) {
//         col = width - 'A';
//         excel = new int[height][col+1];
//         formulas = new HashMap<>();
//     }
    
//     public void set(int row, char column, int val) {
//         int c = column - 'A';
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



import java.util.*;

import java.util.*;

class Excel {
    private int[][] excel;
    private int cols;
    // 存储公式：当前格ID -> 该公式引用的所有单元格ID及其出现次数
    private Map<Integer, Map<Integer, Integer>> formulas;

    public Excel(int height, char width) {
        this.cols = width - 'A' + 1;
        // 使用 height + 1 以匹配从 1 开始的行号
        this.excel = new int[height + 1][cols];
        this.formulas = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        int c = column - 'A';
        int id = row * cols + c;
        
        // 如果该格之前有公式，删除它
        formulas.remove(id);
        
        // 更新值并触发连锁反应
        updateValue(row, c, val);
    }

    public int get(int row, char column) {
        // O(1) 读取，这就是不超时的核心
        return excel[row][column - 'A'];
    }

    public int sum(int row, char column, String[] numbers) {
        int c = column - 'A';
        int id = row * cols + c;

        // 1. 预解析公式字符串到 Map 中（记录 ID 和出现次数）
        Map<Integer, Integer> currentFormula = new HashMap<>();
        for (String s : numbers) {
            if (s.contains(":")) {
                String[] parts = s.split(":");
                int r1 = Integer.parseInt(parts[0].substring(1)), c1 = parts[0].charAt(0) - 'A';
                int r2 = Integer.parseInt(parts[1].substring(1)), c2 = parts[1].charAt(0) - 'A';
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        int srcId = i * cols + j;
                        currentFormula.put(srcId, currentFormula.getOrDefault(srcId, 0) + 1);
                    }
                }
            } else {
                int r = Integer.parseInt(s.substring(1)), curC = s.charAt(0) - 'A';
                int srcId = r * cols + curC;
                currentFormula.put(srcId, currentFormula.getOrDefault(srcId, 0) + 1);
            }
        }

        // 2. 保存解析后的公式
        formulas.put(id, currentFormula);

        // 3. 计算当前总和并更新
        int val = calculateFormula(currentFormula);
        updateValue(row, c, val);
        return val;
    }

    // 递归更新函数：当一个格子的值变了，所有依赖它的公式格都要重算
    private void updateValue(int r, int c, int val) {
        excel[r][c] = val;
        
        int currentId = r * cols + c;
        // 遍历所有公式，看谁引用了当前变动的格
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : formulas.entrySet()) {
            int formulaCellId = entry.getKey();
            Map<Integer, Integer> refs = entry.getValue();
            
            if (refs.containsKey(currentId)) {
                // 这个公式格需要重新计算
                int nextR = formulaCellId / cols;
                int nextC = formulaCellId % cols;
                int newVal = calculateFormula(refs);
                // 递归更新（触发下游更新）
                updateValue(nextR, nextC, newVal);
            }
        }
    }

    // 根据解析好的引用关系计算求和
    private int calculateFormula(Map<Integer, Integer> refs) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : refs.entrySet()) {
            int id = entry.getKey();
            int count = entry.getValue();
            sum += excel[id / cols][id % cols] * count;
        }
        return sum;
    }
}

