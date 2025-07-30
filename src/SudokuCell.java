public class SudokuCell {
    private int row;
    private int col;
    private int value;
    private boolean isFixed;

    public SudokuCell(int row, int col, int value, boolean isFixed) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.isFixed = isFixed;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getValue() { return value; }
    public boolean isFixed() { return isFixed; }

    public void setValue(int value) {
        if (!isFixed) {
            this.value = value;
        }
    }
}
