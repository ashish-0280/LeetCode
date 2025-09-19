class Spreadsheet {
    int sheet[][];
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char ch = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        sheet[row-1][ch-'A'] = value;
    }
    
    public void resetCell(String cell) {
        char ch = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        sheet[row-1][ch-'A'] = 0;
    }
    
    public int getValue(String formula) {
        String s = formula.substring(1);
        String arr[] = s.split("\\+"); int val1; int val2;
        if(Character.isAlphabetic(arr[0].charAt(0))){
            char ch = arr[0].charAt(0);
            int row = Integer.parseInt(arr[0].substring(1));
            val1 = sheet[row-1][ch-'A'];
        } else {
            val1 = Integer.parseInt(arr[0]);
        }
        if(Character.isAlphabetic(arr[1].charAt(0))){
            char ch = arr[1].charAt(0);
            int row = Integer.parseInt(arr[1].substring(1));
            val2 = sheet[row-1][ch-'A'];
        } else {
            val2 = Integer.parseInt(arr[1]);
        }
        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */