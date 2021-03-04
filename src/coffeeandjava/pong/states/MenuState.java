package coffeeandjava.pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import coffeeandjava.pong.Game;

public class MenuState extends State {

	
	public MenuState(Game game) {
		super(game);
	}
	
	@Override
	public void tick() {
		if(game.getKeyManager().space)
			State.setState(game.gameState);
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman",Font.PLAIN, 25));
		g.drawString("Menu", game.getDisplay().getWidth() / 2 - 20, game.getDisplay().getHeight() / 2);
		g.drawString("Press Space to Start!", game.getDisplay().getWidth()/3 + 20, game.getDisplay().getHeight() / 2 + 50);
		g.setFont(new Font("Times New Roman",Font.PLAIN, 20));
		g.drawString("Pong v1.0.0. made by Coffee&Java", game.getDisplay().getWidth() - 310, game.getDisplay().getHeight() - 20);
	}

}
