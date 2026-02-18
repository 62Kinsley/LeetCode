class Spreadsheet {

    int[][] grid;
    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char[] charArray = cell.toCharArray();
        int col = charArray[0] - 'A';
        int row = 0;
        for(int i=1; i<charArray.length; i++){
            row = row*10 + (charArray[i] - '0');
        }
        row -= 1;
        grid[row][col] = value;
        
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        String expr = formula.substring(1);//=5+7 -> 5+7
        String[] parts = expr.split("\\+");

        return parse(parts[0]) + parse(parts[1]);
    }

    private int parse(String s){
        if (Character.isLetter(s.charAt(0))) {
            int col = s.charAt(0) - 'A';
            int row = Integer.parseInt(s.substring(1)) - 1;
            return grid[row][col];
        }
        return Integer.parseInt(s);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */