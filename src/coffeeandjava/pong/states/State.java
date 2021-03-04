package coffeeandjava.pong.states;

import java.awt.Graphics;

import coffeeandjava.pong.Game;

public abstract class State {
	
	public static State currentState;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	// CLASS
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
