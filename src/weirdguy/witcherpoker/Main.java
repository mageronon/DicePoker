package weirdguy.witcherpoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import acm.io.IODialog;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

	private static final ActionListener ActionListener = null;
	
	private Graphics graph;
	private Cells cells;
	private int a = 0;

	public void init() {
		this.setSize(1000, 400);
		
		this.graph = new Graphics(this.getGCanvas());
		JButton But = new JButton("ReRoll");
//		JButton But = new JButton("Second part");
	
		add(But, SOUTH);
		addActionListeners();

//		add(But1 , NORTH);
//		addActionListeners();
		
	}
	
	public void run() {
		
		this.graph.spawnDices();
	}

	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 2; i++){
			for(int k = 0; k < 5; k++){
				if(this.graph.cells[i][k].selectedCell){
					this.graph.cells[i][k].reRoll();
				}else{
					this.graph.cells[i][k].drawDice();
				}
//				this.graph.cells[i][k].winner();
//				System.out.println(i + "" + k);	
			}
		}
		
		for(int i = 0; i < 2; i++) {
			chooseWinner(i);
		}
		
	}
	
	public void chooseWinner(int pl){
		int qMax = 0;
		int[] counts = new int[6];
		
		for (int i = 0; i < this.graph.cells[pl].length; i++) {
            if (this.graph.cells[pl][i].q == 1) {
                counts[0]++;
            } else if (this.graph.cells[pl][i].q == 2) {
                counts[1]++;
            } else if (this.graph.cells[pl][i].q == 3) {
                counts[2]++;
            } else if (this.graph.cells[pl][i].q == 4) {
                counts[3]++;
            } else if (this.graph.cells[pl][i].q == 5) {
                counts[4]++;
            } else if (this.graph.cells[pl][i].q == 6) {
                counts[5]++;
            }
        }
		
		
		String resValue = " ";
		
		int fiveOf = 0;
		int sixOf = 1;
		
		for(int i = 0; i <this.graph.cells[pl].length; i++){
				
					if(this.graph.cells[pl][i].q == 1 ){
						fiveOf++;
					}
					if(this.graph.cells[pl][i].q == 2 ){
						fiveOf++;
					}
					if(this.graph.cells[pl][i].q == 3 ){
						fiveOf++;
					}
					if(this.graph.cells[pl][i].q == 4 ){
						fiveOf++;
					}
					if(this.graph.cells[pl][i].q == 5 ){
						fiveOf++;
					}
				
		}
		
		for(int i = 0; i <this.graph.cells[pl].length; i++){
			
				
				if(this.graph.cells[pl][i].q == 6 ){
					sixOf++;
				}
				if(this.graph.cells[pl][i].q == 2 ){
					sixOf++;
				}
				if(this.graph.cells[pl][i].q == 3 ){
					sixOf++;
				}
				if(this.graph.cells[pl][i].q == 4 ){
					sixOf++;
				}
				if(this.graph.cells[pl][i].q == 5 ){
					sixOf++;
				}	
			
	}
		int k = 0;
		for (int i = 0; i < counts.length; i++) {
			
            if (counts[i] == 5) {
                resValue = "Five of a kind ";
                k = 9;
                break;
            } else if (counts[i] == 4) {
                resValue = "Four of a kind ";
                k = 8;
                break;
            } else if (counts[i] == 3) {
                resValue = "Three of a Kind ";
                k = 4;
                for (int j = i; j < counts.length; j++) {
                    if (counts[j]==2) {
                        resValue = "Full House ";
                        k = 7;
                        break;
                    }
                    for (int d = i + 1; d < counts.length; d++) {
                        if (counts[d]==2) {
                            resValue = "Full House ";
                            k = 7;
                            break;
                        }
                    }
                }
                break;
            } else if (counts[i] == 2) {
                 resValue = "One Pair ";
                 k = 2;
                 for (int j = i; j < counts.length; j++) {
                     if (counts[j] == 3) {
                         resValue = "Full House ";
                         k = 7;
                         break;
                     }
                 }
                 for (int d = i + 1; d < counts.length; d++) {
                     if (counts[d]==2) {
                         resValue = "Full House ";
                         k = 7;
                         break;
                     }
                 }
                for (int j = i + 1; j < counts.length; j++) {
                    if (counts[j] == 2) {
                        resValue = "Two Pairs ";
                        k = 3;
                        break;
                    }
                }
               break;
            } else {
            	if(fiveOf == 5){
        			resValue="Five High Straight ";
        			 k = 5;
        		}else if(sixOf == 6){
        			resValue=" Six High Straight ";
        			 k = 6;
        		}else{
                resValue = "Highest Card ";
                k = 1;
        		}
            }
        }
		
		System.out.println(resValue);
		System.out.println(k);
		System.out.println(fiveOf);

	
		
//		IODialog dialog = new IODialog();
//		dialog.println(resValue);
	}
}
	
