import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Game{
	public JFrame win;
        public char[][] board;
	public Timer timer;
	private Canvy canvas;

	public Game(char[][] brd){
		board = brd;
		win = new JFrame();
		win.setSize(600, 600);
		win.setTitle("Game of Life");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setBackground(Color.BLACK);
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		
	}

        public void timed(){
		ArrayList<Integer> t = new ArrayList<Integer>();
		int i = 1;
                while(i>0){
			int j = 0;
//			System.out.println("r");
			play();
//			System.out.println("er");
			long start = System.currentTimeMillis();
			long change = 0;
			while(change<200){
			//	t.add(j);
			//	j++;
				long end = System.currentTimeMillis();
				change = end-start;
			}
			i++;
		}
        }

	public int count (char[] arr, char c){
		int count = 0;
		for (int i = 0; i < arr.length; i++){
			if (arr[i]==(c))
				count++;
		}
		return count;
	}
	public char[] c(char[] i, int j, int k){
		return Arrays.copyOfRange(i,j,k);
	}
	public void howTo(){
//		System.out.println("enter hoto");
		int c1=0;
		int c2=0;
		int c3=0;
		char[][] temp = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++){
			temp[i] = Arrays.copyOf(board[i], board[i].length);
		}
		if (board.length == 1)
			temp[0][0] = ' ';
		else{
			int i = 0;
		//	System.out.println("length");
			while (i<board.length){
				int j = 0;
		//		System.out.println("while");
				while (j<board[0].length){
					if (i==0 && (j!=0 && j!= board[0].length-1)){
						c1 = count(c(board[i],j-1,j+2),'X')-1;
						c2 = 0;
						c3 = count(c(board[i+1],j-1,j+2),'X');
					}
					else if (i==board.length -1 && (j!=0 && j!=board[0].length - 1)){
						c1 = count(c(board[i],j-1,j+2),'X') - 1;
						c2 = count(c(board[i-1],j-1,j+2),'X');
						c3 = 0;
					}
					else if (i == 0 && (j==0||j==board[0].length - 1)){
						if (j==0){
							c1 = count(c(board[i],j,j+2),'X')-1;
							c2 = 0;
							c3 = count(c(board[i+1],j,j+2),'X');
						}
						else if (j==board[0].length - 1){
							c1 = count(c(board[i],j-1,j+1),'X') -1;
							c2 = 0;
							c3 = count(c(board[i+1],j-1,j+1),'X');
						}
					}
					else if (i==board.length-1 &&(j==0||j==board[0].length - 1)){
						if (j==0){
							c1 = count(c(board[i],j,j+2),'X')-1;
							c2 = count(c(board[i-1],j,j+2),'X');
							c3 = 0;
						}
						else if (j==board[0].length -1){
							c1 = count(c(board[i],j-1,j+1),'X') -1;
							c2 = count(c(board[i-1],j-1,j+1),'X');
							c3 = 0;
						}
					}
					else if (i!=0 && i!=board.length &&(j!=0 && j!=board[0].length -1)){
						c1 = count(c(board[i],j-1,j+2),'X') - 1;
						c2 = count(c(board[i-1],j-1,j+2),'X');
						c3 = count(c(board[i+1],j-1,j+2),'X');
					}
					else if (i!=0 && i!=board.length && (j==0||j==board[0].length - 1)){
						if (j==0){
							c1 = count(c(board[i],j,j+2),'X') - 1;
							c2 = count(c(board[i-1],j,j+2),'X');
							c3 = count(c(board[i+1],j,j+2),'X');	
						}
						else if (j==board[0].length - 1){
							c1 = count(c(board[i],j-1,j+1),'X') -1;
							c2 = count(c(board[i-1],j-1,j+1),'X');
							c3 = count(c(board[i+1],j-1,j+1),'X');
						}
					}

					if (board[i][j]==('X')){
						int neighbors = c1 + c2 + c3;
						if (neighbors<2)
							temp[i][j]=' ';
						else if (neighbors ==2 || neighbors ==3)
							temp[i][j] = 'X';
						else if (neighbors>3)
							temp[i][j] = ' ';
					
					}
					else if (board[i][j]==' '){
						int neighbors = c1+c2+c3+1;
						if (neighbors==3)
							temp[i][j]='X';
				
					}
			//		System.out.println("j");
					j++;

				}
			//	System.out.println("i");
				i++;
			}
		}
	//	System.out.println("for who?");
		board = temp;	
	//	System.out.println("Howto Success");
	}
	public void play(){
//		System.out.println("Play Success");
		canvas = new Canvy();
	//	System.out.println("fg");
		win.getContentPane().removeAll();
		win.getContentPane().add(canvas);
	//	System.out.println("add pass");
		win.getContentPane().repaint();
		win.getContentPane().revalidate();
	//	System.out.println("rev pass");
	//	System.out.println("rep pass");
		howTo();	
	//	System.out.println("Howto pass");
	}
		
	private class  Canvy extends Canvas{
	        public int x1;
	        public int x2;
	        public int ro = board.length;
	        public int col = board[0].length;
		public int width = 600;
		public int length = 600;
	        public int widthr = width/col;
	        public int lengthr = length/col;
	        @Override
	        public void paint(Graphics g){
//	                System.out.println("Anything?");
	                for (int row = 0; row<board.length;row++){
	                        for (int column = 0;column<board[0].length;column++){
	                                x1= width*column/col;
					x2 = length*row/ro;
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
//	                System.out.println("Canvas Painted");

	        }
	}

}


































