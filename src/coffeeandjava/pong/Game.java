package coffeeandjava.pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import coffeeandjava.pong.display.Display;
import coffeeandjava.pong.input.KeyManager;
import coffeeandjava.pong.states.GameState;
import coffeeandjava.pong.states.MenuState;
import coffeeandjava.pong.states.State;
import coffeeandjava.pong.ui.ScoreManager;
import coffeeandjava.pong.ui.UI;

public class Game implements Runnable {

	private Display display;
	private String title;
	private int width, height;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// Input
	private KeyManager keyManager;
	
	// Game States
	public MenuState menuState;
	public GameState gameState;
	
	// Handler
	private Handler handler;
	
	// UI
	private UI ui;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init() {
		
		handler = new Handler(this);
		ui = new UI(handler,0);
		ui.setBest(ScoreManager.loadScore());
		keyManager = new KeyManager();
		
		menuState = new MenuState(this);
		gameState = new GameState(this);
		State.setState(menuState);
		
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
	}
	
	private void tick() {
		
		keyManager.tick();
		
		if(State.getState() != null) 
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw
		if(State.getState() != null) 
			State.getState().render(g);
		// End Drawing
		bs.show();
		g.dispose();
		 
	}
	
	@Override
	public void run() {
		
		init();
		
		// limit fps
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0; // elapsed time
		long ticks = 0;
		
		while(running) {
	
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			while(delta >= 1) {
				
				tick();
				render();
				ticks++;
				delta--;
	
			}
			
			
			if(timer >= 1000000000) {
				display.getFrame().setTitle("2D Pong - FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public UI getUI() {
		return ui;
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(null, "GAME OVER!!");
		gameState = new GameState(this);
		ScoreManager.saveScore(getUI().getScore());
		System.exit(1);
	}
	
	public synchronized void stop() {
		if(running == false)
			return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public Display getDisplay() {
		return display;
	}
}
