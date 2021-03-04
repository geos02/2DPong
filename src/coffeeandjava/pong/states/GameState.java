package coffeeandjava.pong.states;

import java.awt.Graphics;


import coffeeandjava.pong.Game;
import coffeeandjava.pong.entities.Ball;
import coffeeandjava.pong.entities.Paddle;

public class GameState extends State {

	private Ball ball;
	private Paddle paddle;
	
	public GameState(Game game) {
		super(game);
		paddle = new Paddle(game,280, 420, 100, 20);
		ball = new Ball(paddle,20, 20, 25,25,game);
		
	}
	
	@Override
	public void tick() {
		
		ball.tick();
		paddle.tick();
	}

	@Override
	public void render(Graphics g) {
		ball.render(g);
		paddle.render(g);
		game.getUI().render(g);
	}

}
