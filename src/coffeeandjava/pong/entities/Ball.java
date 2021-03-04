package coffeeandjava.pong.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import coffeeandjava.pong.Game;
import coffeeandjava.pong.audio.Sound;


public class Ball extends Entity {
	
	private float xMove, yMove;
	private int xDir, yDir;
	private int width, height;
	private Paddle paddle;
	private Game game;
	private Sound ballSound;
	private Sound gameOverSound;
	
	public Ball(Paddle p,int x, int y, int width, int height,Game game) {
		super(x, y);
		this.paddle = p;
		this.width = width;
		this.height = height;
		this.game = game;
		xMove = 3;
		yMove = 3;
		xDir = 1;
		yDir = 1;
		ballSound = new Sound();
		ballSound.loadSoundFromFile(getClass().getClassLoader().getResource("beep.wav"));
		gameOverSound = new Sound();
		gameOverSound.loadSoundFromFile(getClass().getClassLoader().getResource("game_over.wav"));
	}

	@Override
	public void tick() {
		
		if((x + width) >= 640)
			xDir = -1;
		if(x <= 0)
			xDir = 1;
		if(y + height >= 480)
			yDir = -1;
		if(y <= 0)
			yDir = 1;
		if(y + height >= game.getDisplay().getHeight()) {
			gameOverSound.play();
			game.gameOver();
			
		}
		if(collision()) {
			
			ballSound.play();
			game.getUI().increaseScore();
			yMove += 0.1f;
			xMove += 0.1f;
			yDir = -1;
		}
		
		x += xMove * xDir;
		y += yMove * yDir;
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
	public boolean collision() {
		return paddle.getBounds().intersects(getBounds());
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		g2.fill(new Ellipse2D.Double(x, y, width, height));
	}

}
