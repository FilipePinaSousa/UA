package snakegame;

import snakegame.cell.CellType;

// To represent Snake Game
public class game {

	public static final int DIRECTION_NONE
		= 0,
		DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1,
		DIRECTION_UP = 2, DIRECTION_DOWN = -2;
	private snake snake;
	private board board;
	private int direction;
	private boolean gameOver;

	public game(snake snake, board board)
	{
		this.snake = snake;
		this.board = board;
	}

	public snake getSnake() { return snake; }

	public void setSnake(snake snake)
	{
		this.snake = snake;
	}

	public board getboard() { return board; }

	public void setboard(board board)
	{
		this.board = board;
	}

	public boolean isGameOver() { return gameOver; }

	public void setGameOver(boolean gameOver)
	{
		this.gameOver = gameOver;
	}

	public int getDirection() { return direction; }

	public void setDirection(int direction)
	{
		this.direction = direction;
	}

	// We need to update the game at regular intervals,
	// and accept user input from the Keyboard.
	public void update()
	{
		System.out.println("Going to update the game");
		if (!gameOver) {
			if (direction != DIRECTION_NONE) {
				cell nextCell
					= getNextCell(snake.getHead());

				if (snake.checkCrash(nextCell)) {
					setDirection(DIRECTION_NONE);
					gameOver = true;
				}
				else {
					snake.move(nextCell);
					if (nextCell.getCellType()
						== CellType.FOOD) {
						snake.grow();
						board.generateFood();
					}
				}
			}
		}
	}

	private cell getNextCell(cell currentPosition)
	{
		System.out.println("Going to find next cell");
		int row = currentPosition.getRow();
		int col = currentPosition.getCol();

		if (direction == DIRECTION_RIGHT) {
			col++;
		}
		else if (direction == DIRECTION_LEFT) {
			col--;
		}
		else if (direction == DIRECTION_UP) {
			row--;
		}
		else if (direction == DIRECTION_DOWN) {
			row++;
		}

		cell nextCell = board.getcells()[row][col];

		return nextCell;
	}

	public static void main(String[] args)
	{

		System.out.println("Going to start game");

		cell initPos = new cell(0, 0);
		snake initSnake = new snake(initPos);
		board board = new board(10, 10);
		game newGame = new game(initSnake, board);
		newGame.gameOver = false;
		newGame.direction = DIRECTION_RIGHT;

		// We need to update the game at regular intervals,
		// and accept user input from the Keyboard.

		// here I have just called the different methods
		// to show the functionality
		for (int i = 0; i < 5; i++) {
			if (i == 2)
				newGame.board.generateFood();
			newGame.update();
			if (i == 3)
				newGame.direction = DIRECTION_RIGHT;
			if (newGame.gameOver == true)
				break;
		}
	}
}
