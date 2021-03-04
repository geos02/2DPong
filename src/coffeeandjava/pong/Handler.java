package coffeeandjava.pong;

import coffeeandjava.pong.input.KeyManager;
import coffeeandjava.pong.ui.UI;

public class Handler {

	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}

	
	public int getWidth() {
		return game.getDisplay().getWidth();
	}
	
	public int getHeight() {
		return game.getDisplay().getHeight();
	}
	
	public UI getUI() {
		return game.getUI();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public void gameOver() {
		game.gameOver();
	}
}

