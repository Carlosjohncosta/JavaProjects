package main;
import processing.core.*;

public class Main extends PApplet{
	int width = 25;
	int height = 25;
	int size = 30;
	Game game = new Game(this, width, height, size);
	PFont f;
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
	public void settings() {
		size((width - 1) * size, (height - 1) * size);
	}
	
	public void setup() {
		background(255);
		f = createFont("Georgia", size);
		textFont(f);
	}
	
	public void mouseReleased() {
		if (mouseButton == LEFT) {
			game.clickHandler((mouseX / size) + 1, (mouseY / size) + 1, MouseEvent.LEFT);
		} else if (mouseButton == RIGHT) {
			game.clickHandler((mouseX / size) + 1, (mouseY / size) + 1, MouseEvent.RIGHT);
		}
	}
	
	public void draw() {
		game.display();
	}
}
