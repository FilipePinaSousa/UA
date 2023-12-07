// To represent a cell of display board
package snakegame;
public class cell {

	private final int row, col;
	private CellType cellType;
    // Enum for different cell types
 
    public enum CellType {
 
    EMPTY,
    FOOD,
    SNAKE_NODE;
}

	public cell(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	public CellType getCellType() { return cellType; }

	public void setCellType(CellType cellType)
	{
		this.cellType = cellType;
	}

	public int getRow() { return row; }

	public int getCol() { return col; }
}
