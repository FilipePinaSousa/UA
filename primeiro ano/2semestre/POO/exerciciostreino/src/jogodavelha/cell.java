package jogodavelha;

public class cell {
   

    private final int row;
    private final int col;
    private CellType cellType;

    public enum CellType {
        VAZIA,
        X,
        O
    }

    public cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellType = CellType.VAZIA;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
