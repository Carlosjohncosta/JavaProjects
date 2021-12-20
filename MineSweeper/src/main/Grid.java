package main;
import processing.core.*;

public abstract class Grid extends PApplet{
	int width;
	int height;
	int size;
	int[][] grid;
	public PApplet main;
	
	Grid(PApplet main, int width, int height, int size) {
		this.width = width;
		this.height = height;
		this.size = size;
		this.main = main;
		reset();
	}
	
	void showGridLines(int darkness) {
		main.stroke(darkness);
		for (int x = 0; x < height; x++) {
			main.line(x * size, 0, x * size, height * size);
			main.line(0, x * size, width * size, x * size);
		}
	}
	
	abstract void reset();
	abstract void clickHandler(int x, int y, MouseEvent button);
}
