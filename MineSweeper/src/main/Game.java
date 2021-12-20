package main;
import processing.core.*;

public class Game extends Grid {
	GridStatus[][] hidden;
	int moves = 0;
	boolean lost = false;
	boolean won = false;
	GridStatus cycle = GridStatus.UNHIDDEN;
	Game(PApplet main, int width, int height, int size) {
		super(main, width, height, size);
		reset();
	}
	
	void display() {
		showGridLines(80);
		for (int y = 1; y <  height; y++) {
			for (int x = 1; x <  width; x++) {
				show(x, y);
			}
		}
		if (won) {
			main.frameRate(5);
			for (int y = 1; y <  height; y++) {
				for (int x = 1; x <  width; x++) {
					if (grid[x][y] == -1) {
						hidden[x][y] = cycle;
					}
				}
			}
			if (cycle == GridStatus.UNHIDDEN) {cycle = GridStatus.FLAGGED;} else {cycle = GridStatus.UNHIDDEN;}
		}
	}
	
	void show(int x, int y) {
		int currX = x-1;
		int currY = y-1;
		if (hidden[x][y] == GridStatus.UNHIDDEN) {
			if (grid[x][y] == -1) {
				main.fill(255, 0, 0);
				main.square(currX * size, currY * size, size);
			} else {
				main.fill(255);
				main.square(currX * size, currY * size, size);
				if(grid[x][y] > 0) {
					main.fill(0);
					main.text(Character.forDigit(grid[x][y], 10), 
							(currX * size) + (size / 5), 
							(float)(currY + 0.7) * size);
				}
			} 
		} else if (hidden[x][y] == GridStatus.HIDDEN){
			main.fill(128);
			main.square(currX * size, currY * size, size);
		} else {
			main.fill(0, 255, 0);
			main.square(currX * size, currY * size, size);
		}
	}
	
	void setBombs() {
		for (int y = 1; y <  height; y++) {
			for (int x = 1; x <  width; x++) {
				if (Math.floor(Math.random() * 17) == 0) {
					grid[x][y] = -1;
				}
			}
		}
		setMarkers();
	}
	
	private void setMarkers() {
		for(int y = 1; y < height; y++) {
			for(int x = 1; x < width; x++) {
				if (grid[x][y] == - 1) continue;
				int bombCount = 0;
				for (int y2 = -1; y2 < 2; y2++) {
					for (int x2 = -1; x2 < 2; x2++) {
						if(!(y2 == 0 && x2 == 0)) {
							if(grid[x + x2][y + y2] == -1) bombCount++;
						}
					}
				}
				grid[x][y] = bombCount;
			}
		}
	}
	
	private void showMultiple(int xClick, int yClick) {
		int radius = (int)Math.floor(2 + Math.random() * 5);
		for(int y = -radius; y <= radius; y++) {
			for (int x = -radius; x <= radius; x++) {
				if (yClick + y < 1 || yClick + y > height || xClick + x < 1 || xClick + x > height) continue;
				if (grid[xClick + x][yClick + y] != -1 && hidden[xClick + x][yClick + y] != GridStatus.FLAGGED) {
					hidden[xClick + x][yClick + y] = GridStatus.UNHIDDEN;
				}
			}
		}
	}
	
	void clickHandler(int x, int y, MouseEvent button) {
		if (lost == true || won == true) {reset(); main.frameRate(60); return;}
		
		if (button == MouseEvent.LEFT && hidden[x][y] != GridStatus.UNHIDDEN) {
			if (hidden[x][y] == GridStatus.FLAGGED) {
				hidden[x][y] = GridStatus.HIDDEN;
			} else {
				if (moves == 0 || Math.floor(Math.random() * 5) == 0) {
					showMultiple(x, y);
				} else {
					if (grid[x][y] == - 1) {
						showBombs();
						lost = true;
					} else {
					hidden[x][y] = GridStatus.UNHIDDEN;
					}		
				}
			}
		} else if(button == MouseEvent.RIGHT && hidden[x][y] != GridStatus.UNHIDDEN) {
			if (hidden[x][y] != GridStatus.FLAGGED) {
				hidden[x][y] = GridStatus.FLAGGED;
			} else {
				hidden[x][y] = GridStatus.HIDDEN;
			}
		}
		moves++;
		won = checkFinished();
	}
	
	boolean checkFinished() {
		for(int y = 1; y < height; y++) {
			for(int x = 1; x < width; x++) {
				if (grid[x][y] == - 1 && hidden[x][y] != GridStatus.FLAGGED) {
					return false;
				}
			}
		}
		return true;
	}
	
	void showBombs() {
		for (int y = 1; y < height; y++) {
			for (int x = 1; x < width; x++) {
				if (grid[x][y] == -1) hidden[x][y] = GridStatus.UNHIDDEN;
			}
		}
	}
	
	void reset() {
		lost = false; 
		won = false; 
		moves = 0;
		grid = new int[width + 2][height + 2];
		hidden = new GridStatus[width + 2][height + 2];
		for (int y = 0; y < height + 2; y++) {
			for (int x = 0; x < width + 2; x++) {
				grid[x][y] = 0;
				hidden[x][y] = GridStatus.HIDDEN;
			}
		}
		setBombs();
	}
	
}
