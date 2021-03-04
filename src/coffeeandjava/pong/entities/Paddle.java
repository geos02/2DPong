package coffeeandjava.pong.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import coffeeandjava.pong.Game;

public class Paddle extends Entity {

	private Game game;
	private int width, height;
	private int speed;
	private int xMove;
	 
	
	public Paddle(Game game, int x, int y, int width,int height) {
		super(x, y);
		this.game = game;
		this.width = width;
		this.height = height;
		speed = Entity.DEFAULT_SPEED;
		xMove = 0;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}
	
	public void move() {
		x += xMove;
		// Reposicionar raqueta si toca los limites de la pantalla
		if(x + width >= game.getDisplay().getWidth())
			x = 640 - width;
		if(x <= 0)
			x = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

}
