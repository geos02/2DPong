package coffeeandjava.pong.ui;

import java.awt.Font;
import java.awt.Graphics;

import coffeeandjava.pong.Handler;

public class UI {

	private int score;
	private int best;
	private Font uiFont;
	private Handler handler;
	
	public UI(Handler handler, int score) {
		this.uiFont = new Font("Times New Roman", Font.PLAIN, 25);
		this.score = score;
		this.best = 0;
		this.handler = handler;
	}
	
	public void increaseScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void setBest(int best) {
		this.best = best;
	}
	
	public int getBest() {
		return best;
	}
	
	public void render(Graphics g) {
		g.setFont(uiFont);
		g.drawString("Score: " + score, handler.getWidth() - 130, 40);
		g.drawString("Best: " + best, handler.getWidth() -130, 80);
	}
}
