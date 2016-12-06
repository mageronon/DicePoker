package mageronon.witcherpoker;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import acm.graphics.GCanvas;
import acm.graphics.GFillable;
import acm.graphics.GOval;

import acm.graphics.GRect;

public class Cells extends GRect implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Random rand;
	
	private static boolean shouldDrawCross = true;	
	private boolean isFree;
	

	private int max = 6 , min = 1;
	private Graphics game;
	private GCanvas canvas;
    private int num = 0;
    public int i, j;
    public boolean selectedCell; 
	private Graphics graphics;
	protected int q;
	protected int h;
	public Cells(double x, double y, double width, double height, int i, int j , GCanvas canvas) {
		super(x, y, width, height);		
		this.setColor(Color.BLUE);
		this.setVisible(false);
		this.canvas = canvas;
		isFree = true;
		this.i = i;
		this.j = j;
		rand = new Random();
		addMouseListener(this);
		rollDices();
		this.q = q;
		num++;
		selectedCell = false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		selectedCell = true;
//		System.out.println(j);	
//		System.out.println(i);	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setVisible(true);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setVisible(false);		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	public void setCanvas(GCanvas canvas) {
		this.canvas = canvas;
		
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
		
	}
	public void reRoll(){
		
		int x = canvas.getX();
		int y = canvas.getY();

		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();
		
		int cellWidth = canvasWidth/5;
		int cellHeight = canvasHeight/2;
		
		GRect rect = new GRect(x + (cellWidth * j - 1), y + (cellHeight * i - 1), cellWidth - 1, cellHeight - 1);
		rect.setColor(Color.BLACK);
		rect.setFillColor(Color.WHITE);
		rect.setFilled(true);
		
		if(num == 1 && isFree ){
			canvas.add(rect);
			
			num ++;
			rollDices();
			selectedCell = false;
			isFree = false;
		}
				
			
	
	}
	public void winner(){
		
				System.out.println(h);
			
			
		
	}
	private void Nothing(){
		int a;
		if(i==0){
			for(j = 0; j < 5; j++){
				a = q ;
				System.out.println(a);

			}
		}else if(i == 1){
			int b;
			for(j = 0; j < 5; j++){
				b = q;
				System.out.println(b);
			}
		}
		
	}
	private void Pair(){
		
	}
	private void TwoPairs(){
	
	}
	private void ThreeOfAKind(){
			
	}
	private void FiveHighStraight (){
		
	}
	private void SixHighStraight (){
	
	}
	private void FullHouse(){
	
	}
	private void FourOfKaind(){
	
	}
	private void FiveOfAKind(){
	
	}
	public void rollDices(){
		
		q = rand.nextInt(max - min + 1) + min ;
		drawDice();
		
	}
	
	protected void drawDice() {
		if(q == 1){
			draw1();
		}
		if(q == 2){
			draw2();
		}
		if(q == 3){
			draw3();
		}
		if(q == 4){
			draw4();
		}
		if(q == 5){
			draw5();
		}
		if(q == 6){
			draw6();
		}
	}

	private void draw1(){
	
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		
		GOval oval = new GOval(x + width/3 + 2, y + height/3 + 2, width/3 - 2, height/3 - 2);
		oval.setColor(Color.BLACK);
		oval.setFilled(true);
		canvas.add(oval);	
		
	}
	
	private void draw2(){
		int i = 2;
		
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		for(int k = 1; k <= 3; k = k + 2){
		GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (k-1)*height/3 + 2, width/3 - 2, height/3 - 2);
		oval.setColor(Color.BLACK);
		oval.setFilled(true);
		canvas.add(oval);	
		}
	}
	
	private void draw3(){
	
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		for(int i = 1; i <= 3; i ++){
			GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (i-1)*height/3 + 2, width/3 - 2, height/3 - 2);
			oval.setColor(Color.BLACK);
			oval.setFilled(true);
			canvas.add(oval);
		}
	}
	
	private void draw4(){
		
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		for(int i = 1; i <= 3; i = i + 2){
			for(int k = 1; k <= 3; k = k + 2){
				GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (k-1)*height/3 + 2, width/3 - 2, height/3 - 2);
				oval.setColor(Color.BLACK);
				oval.setFilled(true);
				canvas.add(oval);
			}
		}
	}
	
	private void draw5(){
		
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		
		for(int i = 1; i <= 3; i = i + 2){
			for(int k = 1; k <= 3; k = k + 2){
				GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (k-1)*height/3 + 2, width/3 - 2, height/3 - 2);
				oval.setColor(Color.BLACK);
				oval.setFilled(true);
				canvas.add(oval);
			}
		}	
		int i = 2, k = 2;
		
		GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (k-1)*height/3 + 2, width/3 - 2, height/3 - 2);
		oval.setColor(Color.BLACK);
		oval.setFilled(true);
		canvas.add(oval);
		
	}
	
	private void draw6(){
		
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		for(int i = 1;i <= 3; i = i + 2){
			for(int k = 1;k <= 3; k++){
				GOval oval = new GOval(x + (i-1)*width/3 + 2, y + (k-1)*height/3 + 2, width/3 - 2, height/3 - 2);
				oval.setColor(Color.BLACK);
				oval.setFilled(true);
				canvas.add(oval);	
			}
		}
	}
	
	
}

