package coffeeandjava.pong.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings({ "unused" })
public class Display {

	private JFrame window;
	private Canvas canvas;
	
	private int width, height;
	private String title;
	
	
	public Display(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay() {
		window = new JFrame();
		window.setSize(width, height);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setBackground(Color.BLACK);
		canvas.setFocusable(false);
		
		window.add(canvas);
		window.pack();
		
		window.setVisible(true);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public JFrame getFrame() {
		return window;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}
