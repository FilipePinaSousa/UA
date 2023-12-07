// To represent a snake
package snakegame;
import java.util.LinkedList;

import snakegame.cell.CellType;

public class snake {

	private LinkedList<cell> snakePartList
		= new LinkedList<>();
	private cell head;

	public snake(cell initPos)
	{
		head = initPos;
		snakePartList.add(head);
		head.setCellType(CellType.SNAKE_NODE);
	}

	public void grow() { snakePartList.add(head); }

	public void move(cell nextcell)
	{
		System.out.println("Snake is moving to "
						+ nextcell.getRow() + " "
						+ nextcell.getCol());
		cell tail = snakePartList.removeLast();
		tail.setCellType(CellType.EMPTY);

		head = nextcell;
		head.setCellType(CellType.SNAKE_NODE);
		snakePartList.addFirst(head);
	}

	public boolean checkCrash(cell nextcell)
	{
		System.out.println("Going to check for Crash");
		for (cell cell : snakePartList) {
			if (cell == nextcell) {
				return true;
			}
		}

		return false;
	}

	public LinkedList<cell> getSnakePartList()
	{
		return snakePartList;
	}

	public void
	setSnakePartList(LinkedList<cell> snakePartList)
	{
		this.snakePartList = snakePartList;
	}

	public cell getHead() { return head; }

	public void setHead(cell head) { this.head = head; }
}
