package weirdguy.witcherpoker;

import java.awt.Color;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class Graphics {
	
	private GCanvas canvas;
	
	public Graphics(GCanvas canvas) {
		this.canvas = canvas;
	}

	public void spawnDices() {
		for(int i = 0; i < 2; i++)
			for(int k = 0; k < 5; k++){
				drawRect(i, k);
			}
			
			
	}
	
	private void drawRect(int i, int k) {
		
		//System.out.println(canvas.getX() + (canvas.getWidth() / 5 * i));
		
		int x = canvas.getX();
		int y = canvas.getY();
		
		GRect rect = new GRect(x + (canvas.getWidth() / 5 * k), y + (canvas.getHeight() / 2 * i), canvas.getWidth() / 5, canvas.getHeight() / 2);
		rect.setColor(Color.BLACK);
		canvas.add(rect);
	}
}
