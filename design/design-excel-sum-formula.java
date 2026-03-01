class Excel {

    int[][] excel;
    Map<Integer, Map<Integer, Integer>> formulas;// formulas 存储：当前格 ID -> {引用格 ID : 出现次数}
    int cols;
    public Excel(int height, char width) {
        cols = width - 'A' + 1;
        excel = new int[height+1][cols];
        formulas = new HashMap<>();
    }
    
    public void set(int row, char column, int val) {
        int c = column - 'A';
        int id = row * cols + c;
        formulas.remove(id); 
        updateValue(row, c, val);
     
    }
    
    public int get(int row, char column) {
        return excel[row ][column - 'A'];
    }
    
    public int sum(int row, char column, String[] numbers) {
      
        Map<Integer, Integer> currentFormula = new HashMap<>();
        // 1. 预解析公式字符串到 Map 中（记录 ID 和出现次数）
        for (String num : numbers) {
            if (num.contains(":")) {//A1:B2
                String[] parts = num.split(":");  // parts[0] = "A1", parts[1] = "B2"

                char c1 = parts[0].charAt(0);  //'A'
                int  r1 = Integer.parseInt(parts[0].substring(1));// 1

                char c2 = parts[1].charAt(0);  // 'C'
                int  r2 = Integer.parseInt(parts[1].substring(1)); // 3

                 // 遍历矩形内每一格
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1 - 'A'; j <= c2-'A'; j++) {
                        int srcId = i * cols + j;  
                        currentFormula.put(srcId,  currentFormula.getOrDefault(srcId, 0) + 1);
                    }
                }
            }
            else{//"A1"
                int c3 = num.charAt(0) - 'A';
                int  r3 = Integer.parseInt(num.substring(1));
                int srcId = r3  * cols + c3; 
                currentFormula.put(srcId,  currentFormula.getOrDefault(srcId, 0) + 1);
            }
        }

        int c = column - 'A';
        int id = row * cols + c;

        formulas.put(id, currentFormula);
        int sum  = calculateFormula(currentFormula);
        updateValue(row, c, sum);
        return sum;


    }

    private void updateValue(int row, int col, int val) {//
        excel[row][col] = val;
        int currentId = row * cols + col;

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : formulas.entrySet()) {
            int formulaCellId = entry.getKey();//rely id
            Map<Integer, Integer> refs = entry.getValue();//relied id: times

            if (refs.containsKey(currentId)) {
                int relyR = formulaCellId / cols;
                int relyC = formulaCellId % cols;
                int newVal = calculateFormula(refs);

                updateValue(relyR, relyC, newVal);

            }
        }
    }

    private int calculateFormula(Map<Integer, Integer> refs) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : refs.entrySet()) {
            int id = entry.getKey();// 引用格的 ID
            int count = entry.getValue();
            int r = id/cols, c = id%cols;

            sum += excel[r][c] * count;
        }
        return sum;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */





