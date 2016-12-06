package weirdguy.witcherpoker;

import java.awt.Color;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class Graphics {
	private static final GCanvas GCanvas = null;

	private GCanvas canvas;
	
	protected Cells[][] cells = new Cells[2][5];
	
	private int[][] boardState = new int[2][5];
	
	public Graphics(GCanvas canvas) {
		this.canvas = canvas;
	}

	public void spawnDices() {
		drawRect();
		
	}
	
	public void drawRect() {
	
		int x = canvas.getX();
		int y = canvas.getY();

		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();
		
		int cellWidth = canvasWidth/5;
		int cellHeight = canvasHeight/2;
		
		for(int i = 0; i < 2; i++){
			for(int k = 0; k < 5; k++){
				GRect rect = new GRect(x + (cellWidth* k - 1), y + (cellHeight * i - 1), cellWidth - 1, cellHeight - 1);
				rect.setColor(Color.BLACK);
				canvas.add(rect);
			}
		}
	for(int i = 0; i < 2; i++){
		
		for(int k = 0; k < 5; k++){
			cells[i][k] = new Cells(x + cellWidth*k - 1, y + cellHeight * i - 1, cellWidth - 1, cellHeight - 1, i, k, canvas);
			cells[i][k].setCanvas(canvas);
			
			cells[i][k].setGraphics(this);
			canvas.add(cells[i][k]);
			
		
		}
	}
	}
	private int weHave1(){
		if((boardState[0][0] == boardState[0][1])&&(boardState[0][1] == boardState[0][2])&&(boardState[0][2] == boardState[0][3])){
			return 5;	
		}
		if((boardState[1][0] == boardState[1][1])&&(boardState[1][1] == boardState[1][2])&&(boardState[1][2] == boardState[1][3])){
			return 5;	
		}
		
		return 0;
	}
}
