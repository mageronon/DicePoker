package weirdguy.witcherpoker;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import acm.graphics.GCanvas;
import acm.graphics.GFillable;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

public class Cells extends GRect implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GFillable myObject;
	
	private static boolean shouldDrawCross = true;	
	private boolean isFree;
	private int my_i, my_j;	
	
	private Graphics game;
	private GCanvas canvas;

	public Cells(double x, double y, double width, double height, int i, int j) {
		super(x, y, width, height);		
		this.setColor(Color.BLUE);
		this.setVisible(false);
		isFree = true;
		my_i = i;
		my_j = j;
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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
	
	
}