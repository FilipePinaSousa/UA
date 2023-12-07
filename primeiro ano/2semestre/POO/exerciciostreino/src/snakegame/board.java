package snakegame;
import snakegame.cell.CellType;
public class board {

	final int ROW_COUNT, COL_COUNT;
	private cell[][] cells;

	public board(int rowCount, int columnCount)
	{
		ROW_COUNT = rowCount;
		COL_COUNT = columnCount;

		cells = new cell[ROW_COUNT][COL_COUNT];
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int column = 0; column < COL_COUNT;
				column++) {
				cells[row][column] = new cell(row, column);
			}
		}
	}

	public cell[][] getcells() { return cells; }

	public void setcells(cell[][] cells)
	{
		this.cells = cells;
	}

	public void generateFood()
	{
		System.out.println("Going to generate food");
		int row = 0, column = 0;
		while (true) {
			row = (int)(Math.random() * ROW_COUNT);
			column = (int)(Math.random() * COL_COUNT);
			if (cells[row][column].getCellType()
				!= CellType.SNAKE_NODE)
				break;
		}
		cells[row][column].setCellType(CellType.FOOD);
		System.out.println("Food is generated at: " + row
						+ " " + column);
	}
}
