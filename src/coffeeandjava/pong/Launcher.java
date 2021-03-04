package coffeeandjava.pong;

public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game("2D Pong", 640, 480);
		game.start();
	}

}
