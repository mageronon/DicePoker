package Game;


import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	private Graphics graph;
	private Logic logic;

	public void init() {
		this.setSize(1200, 600);
		
		this.graph = new Graphics(this.getGCanvas());
		this.logic = new Logic();
		
	}
	
	public void run() {
		
		this.graph.spawnDices();
		
	}

}
