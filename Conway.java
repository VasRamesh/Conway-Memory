package conway;


public class Conway {
	private int rows, cols; 
	private boolean[][] conwayBoard; 

	/**
	 * Constructs a new Conway board rows X columns in size with each cell's alive
	 * status false.
	 * 
	 * @param rows the number of rows
	 * @param cols the number of columns
	 */
	public Conway(int rows, int cols) {

	
		this.rows = rows; 
		this.cols = cols; 
		boolean[][] conwayBoard = new boolean [rows][cols]; 
		for(int i = 0; i < conwayBoard.length; i++) {
			for(int j = 0; j < conwayBoard[0].length; j++) {
				conwayBoard[i][j] = false; 
			}
		}
		this.conwayBoard = conwayBoard; 


	}

	/**
	 * @return the number of rows
	 */
	public int getRows() {

		return this.rows; 

	}

	/**
	 * @return the number of columns
	 */
	public int getColumns() {

		return this.cols; 

	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * 
	 * @param isAlive if true, the cell is alive; if false, the cell is dead
	 * @param row
	 * @param col
	 */
	public void setAlive(boolean isAlive, int row, int col) {

		if (isAlive == true) {
			this.conwayBoard[row][col] = true; 
		}
		else {
			this.conwayBoard[row][col] = false; 
		}

	}

	/**
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive.
	 *         If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col) {

		if (row < 0 || row >= this.rows) {
			return false; 
		}
		if (col < 0 || col >= this.cols) {
			return false; 
		}
		else {
			return this.conwayBoard[row][col]; 
		}

	}
	public boolean checkBounds(int row, int col) {
		if (row < 0 || row >= this.rows) {
			return false; 
		}
		if (col < 0 || col >= this.cols) {
			return false;
		}
		else {
			return true; 
		}
	}

	/**
	 * Make every cell not alive
	 */
	public void clear() {

		for(int i = 0; i < this.conwayBoard.length; i++) {
			for(int j = 0; j < this.conwayBoard[0].length; j++) {
				this.conwayBoard[i][j] = false; 
			}
		}

	}

	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 * n n n
	 * n c n
	 * n n n
	 * 
	 * Above, if c represents the cell at (row, col), each n is
	 * a neighbor of c, according to the above definition.
	 * The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col) {

		int aliveCounter = 0; 
		if (checkBounds(row-1,col-1) == true) {
			if (this.conwayBoard[row-1][col-1] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row-1,col) == true) {
			if (this.conwayBoard[row-1][col] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row-1,col+1) == true) {
			if (this.conwayBoard[row-1][col+1] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row,col+1) == true) {
			if (this.conwayBoard[row][col+1] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row+1,col+1) == true) {
			if (this.conwayBoard[row+1][col+1] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row+1,col) == true) {
			if (this.conwayBoard[row+1][col] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row+1,col-1) == true) {
			if (this.conwayBoard[row+1][col-1] == true) {
				aliveCounter++; 
			}
		}
		if (checkBounds(row,col-1) == true) {
			if (this.conwayBoard[row][col-1] == true) {
				aliveCounter++; 
			}
		}
		return aliveCounter; 

	}

	/**
	 * Executes a generation of life. Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step() {
		boolean[][] placeHolders = new boolean [getRows()][getColumns()]; 
		for(int r = 0; r < conwayBoard.length; r ++) {
			for( int c = 0; c < conwayBoard[0].length; c++) {
				if (countLivingNeighbors(r,c) < 2) {
					placeHolders[r][c] = false; 
				}
				if (countLivingNeighbors(r,c) > 3) {
					placeHolders[r][c] = false; 
				}
				if (countLivingNeighbors(r,c) == 3) {
					placeHolders[r][c] = true; 
				}
				if (countLivingNeighbors(r,c) == 2 && this.conwayBoard[r][c] == true) {
					placeHolders[r][c] = true; 
				}
				if (this.conwayBoard[r][c] == false && countLivingNeighbors(r,c) == 3) {
					placeHolders[r][c] = true; 
				} 
			}
		}
		for(int r = 0; r < conwayBoard.length; r ++) {
			for( int c = 0; c < conwayBoard[0].length; c++) {
				this.conwayBoard[r][c] = placeHolders[r][c]; 
			}
		}
		
		

	

	}
	
}