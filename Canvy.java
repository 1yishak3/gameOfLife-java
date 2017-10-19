import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class  Canvy extends Canvas{
	public int x1;
	public int x2;
	public char[][] board;
	public int ro;
        public int col;
	public int widthr;
        public int lengthr;
	public int width;
	public int length;
	public Canvy(char[][] brd){
		board = brd;
		ro = board.length;
		col = board[0].length;
		width = 600;
		length = 600;
		widthr = width/col;
		lengthr = length/col;
		System.out.println("Canvas constructed");
	}
	public void rectEdges(int row, int column){
		x1 =  	width*column/col;
		x2 = 	length*row/ro;
	}
	@Override
	public void paint(Graphics g){
		System.out.println("Anything?");
		for (int row = 0; row<board.length;row++){
			for (int column = 0;column<board[0].length;column++){
				rectEdges(row,column);
				if (board[row][column]==('X')){
					g.setColor(Color.black);
					g.fillRect(x1,x2,widthr,lengthr);
				}
				else{
					g.setColor(Color.white);
					g.fillRect(x1,x2,widthr,lengthr);
				}
			}
		}
		System.out.println("Canvas Painted");
		
	}
}


