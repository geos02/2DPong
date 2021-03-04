package coffeeandjava.pong.entities;

import java.awt.Graphics;

public abstract class Entity {
	
	protected int x, y;
	public static final int DEFAULT_SPEED = 4;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
