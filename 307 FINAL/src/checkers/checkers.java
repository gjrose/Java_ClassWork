package checkers;

import java.awt.*;       
import java.awt.event.*;
import java.applet.*;
import java.util.Random;
import java.util.Vector;

	public class checkers extends Applet{ //  Handles applet layout
		
	   public void init(){
		  super.init();
		  resize(428,492);	//set the applet size
		  setLayout(null);
	      setBackground(new Color(0,150,150));  //Felt-like background
	      
	      CheckersCanvas board = new CheckersCanvas();
	      add(board);

	      board.newGameButton.setBackground(Color.lightGray); //Button addition/coloring
	      add(board.newGameButton);
	      board.quitButton.setBackground(Color.lightGray);
	      add(board.quitButton);
	      board.message.setForeground(Color.black);
	      board.message.setFont(new Font("SansSerif", Font.BOLD, 16));
	      add(board.message);
	      
	      board.setBounds(50,20,328,328);				//Set the position and size of each component 
	      board.quitButton.setBounds(115, 450, 200, 30);
	      board.newGameButton.setBounds(115, 400, 200, 30);
	      board.message.setBounds(115, 350, 200, 30);
	} //End class checkers

	public class CheckersCanvas extends Canvas implements ActionListener, MouseListener{
	  Label message;   // Displays messages to the user "RED: Move." etc...
	  Button quitButton;   //Quit 
	  Button newGameButton;  //Start
	   
	   CheckersData board;  //The data for the checkers board 
	   boolean gameInProgress; //Game currently in progress check
	   int currentPlayer;      //Turn determination
	   Random rnd = new Random();
	   int selectedRow, selectedCol;  //Currently selected square coordinates        
	   CheckersMove[] legalMoves;  //Contains legal moves for current player
	   
	   public CheckersCanvas(){ // Constructor - Create buttons, label, board and start initial game
	      setBackground(Color.black);
	      addMouseListener(this); //Listen for mouse clicks
	      setFont(new  Font("SansSerif", Font.BOLD, 16));
	      quitButton = new Button("Quit");
	      quitButton.addActionListener(this); //Listen for quit click
	      newGameButton = new Button("New Game");
	      newGameButton.addActionListener(this); //Listen for new game click
	      message = new Label("",Label.CENTER);
	      board = new CheckersData();
	      doNewGame();
	   }
	   
	   public void actionPerformed(ActionEvent evt){  //Respond to click on one of the two buttons.
	      Object src = evt.getSource();
	      if (src == newGameButton)
	         doNewGame(); 
	      else if (src == quitButton)
	         doQuit();
	   }
	   
	   public void doNewGame(){ //Start new game
		  int player = rnd.nextInt(2); //Random first player determination
	      board.setUpBoard();   //Set up pieces
	      if(player == 0){
	      currentPlayer = CheckersData.red;   //RED moves first
	      legalMoves = board.getLegalMoves(CheckersData.red);  //Get RED's legal moves
	      message.setText("Red: Move.");
	    }
	      else{
	      currentPlayer = CheckersData.black;   //BLACK moves first
		  legalMoves = board.getLegalMoves(CheckersData.black);  //Get BLACK's legal moves
		  message.setText("Black: Move.");
	    }
	      gameInProgress = true;
	      newGameButton.setEnabled(false);
	      quitButton.setEnabled(true);
	      repaint();
	  }

	   public void doQuit(){ //Current player quits, opponent wins
	       if (gameInProgress == false){
	          message.setText("No game in progress!");
	          return;
	       }
	       if (currentPlayer == CheckersData.red)
	          gameOver("RED quits. BLACK WINS!");
	       else
	          gameOver("BLACK quits. RED WINS!");  
	   }
	   
	  public void gameOver(String str){ //The game ends, str is displayed as a message
	      message.setText(str);
	      newGameButton.setEnabled(true); 
	      quitButton.setEnabled(false);
	      gameInProgress = false;
	   }
	      
	   public void executeClickSquare(int row, int col){ //Called by mousePressed() when a player clicks on a square, if move possible, mark row and column as selected
	      for (int i = 0; i < legalMoves.length; i++)
	         if (legalMoves[i].fromRow == row && legalMoves[i].fromCol == col){
	            selectedRow = row;
	            selectedCol = col;
	            if (currentPlayer == CheckersData.red)
	               message.setText("RED: Move.");
	            else
	               message.setText("BLACK: Move.");
	               repaint();
	            return;
	         }
	      if (selectedRow < 0){ //If no piece has been selected to be moved, show an error message and return
	          message.setText("Click to move.");
	          return;
	      }
	      for (int i = 0; i < legalMoves.length; i++)
	         if (legalMoves[i].fromRow == selectedRow && legalMoves[i].fromCol == selectedCol
	                 && legalMoves[i].toRow == row && legalMoves[i].toCol == col){ //If clicked on a square where the selected piece can be moved, then make the move and return
	            executeMakeMove(legalMoves[i]);
	            return;
	         }
	      message.setText("Click to move.");
	   } 
	   
	   public void executeMakeMove(CheckersMove move){ //Make the move, and then either end or continue the game as appropriate
	      board.makeMove(move);

	      if (move.isJump()){ //Check for double jumps
	         legalMoves = board.getLegalJumpsFrom(currentPlayer,move.toRow,move.toCol);
	         if (legalMoves != null){
	            if (currentPlayer == CheckersData.red)
	               message.setText("RED: Must jump.");
	            else
	               message.setText("BLACK: Must jump.");
	            selectedRow = move.toRow;  //Select only eligible piece
	            selectedCol = move.toCol;
	            repaint();
	            return;
	         }
	      }
	      if (currentPlayer == CheckersData.red){ //Switch player post-move
	    	 currentPlayer = CheckersData.black;
	         legalMoves = board.getLegalMoves(currentPlayer);
	         if (legalMoves == null)
	            gameOver("RED WINS!");
	         else if (legalMoves[0].isJump())
	            message.setText("BLACK: Must jump.");
	         else
	            message.setText("BLACK: Move.");
	      }
	      else{
	         currentPlayer = CheckersData.red;
	         legalMoves = board.getLegalMoves(currentPlayer);
	         if (legalMoves == null)
	            gameOver("BLACK WINS!");
	         else if (legalMoves[0].isJump())
	            message.setText("RED: Must jump.");
	         else
	            message.setText("RED: Move.");
	      }
	      selectedRow = -1; //No selected piece
	      
	      repaint(); //Board redrawn to reflect new positions
	      
	   }  //end executeMakeMove
	   
	   public void update(Graphics g){
	      paint(g); //Completely redraws the canvas
	   }
	   
	   public void paint(Graphics g){//Draw board, pieces, and legal moves highlights 

	      g.setColor(new Color(128,64,0)); //Border
	      g.drawRect(0,0,getSize().width-1,getSize().height-1);
	      g.drawRect(2,2,getSize().width-6,getSize().height-6);
	      
	      for (int row = 0; row < 8; row++){ //Squares and pieces
	         for (int col = 0; col < 8; col++){
	             if ( row % 2 == col % 2 )
	                g.setColor(Color.lightGray);
	             else
	                g.setColor(Color.gray);
	             g.fillRect(4 + col*40, 4 + row*40, 40, 40);
	             switch (board.pieceAt(row,col)){
	                case CheckersData.red:
	                   g.setColor(Color.red);
	                   g.fillOval(8 + col*40, 8 + row*40, 32, 32);
	                   break;
	                case CheckersData.black:
	                   g.setColor(Color.black);
	                   g.fillOval(8 + col*40, 8 + row*40, 32, 32);
	                   break;
	                case CheckersData.redKing:
	                   g.setColor(Color.red);
	                   g.fillOval(8 + col*40, 8 + row*40, 32, 32);
	                   g.setColor(new Color(250,190,0));
	                   g.drawString("K", 18 + col*40, 30 + row*40);
	                   break;
	                case CheckersData.blackKing:
	                   g.setColor(Color.black);
	                   g.fillOval(8 + col*40, 8 + row*40, 32, 32);
	                   g.setColor(new Color(250,190,0));
	                   g.drawString("K", 18 + col*40, 30 + row*40);
	                   break;
	             }
	         }
	      }
	      if (gameInProgress){
	         g.setColor(Color.cyan);  //Draw a cyan border movement eligible pieces
	         for (int i = 0; i < legalMoves.length; i++){
	            g.drawRect(4 + legalMoves[i].fromCol*40, 4 + legalMoves[i].fromRow*40, 38, 38);
	         }
	         if (selectedRow >= 0){ //White border selected piece
	            g.setColor(Color.white);
	            g.drawRect(4 + selectedCol*40, 4 + selectedRow*40, 38, 38);
	            g.drawRect(6 + selectedCol*40, 6 + selectedRow*40, 34, 34);
	            g.setColor(Color.blue); //Eligible movement highlight
	            for (int i = 0; i < legalMoves.length; i++){
	               if (legalMoves[i].fromCol == selectedCol && legalMoves[i].fromRow == selectedRow)
	                  g.drawRect(4 + legalMoves[i].toCol*40, 4 + legalMoves[i].toRow*40, 38, 38);
	            }
	         }
	      }
	   }  // end paint()

	   public void mousePressed(MouseEvent evt){ //Click handling
	      if (gameInProgress == false)
	         message.setText("Click New Game!");
	      else{
	         int col = (evt.getX() - 4) / 40;
	         int row = (evt.getY() - 4) / 40;
	         if (col >= 0 && col < 8 && row >= 0 && row < 8) 
	            executeClickSquare(row,col);
	      }
	   }
	   public void mouseReleased(MouseEvent evt){ }
	   public void mouseClicked(MouseEvent evt){ }
	   public void mouseEntered(MouseEvent evt){ }
	   public void mouseExited(MouseEvent evt){ }
	}  // end class CheckersCanvas

	public class CheckersMove{ //Object represents a move, holds current and destination position
	   int fromRow, fromCol;  //Current position
	   int toRow, toCol;      //Destination position
	   CheckersMove(int r1, int c1, int r2, int c2) {
	      fromRow = r1;
	      fromCol = c1;
	      toRow = r2;
	      toCol = c2;
	   }
	   boolean isJump(){ //If jump move two rows
	      return (fromRow - toRow == 2 || fromRow - toRow == -2);
	   }
	}  // end class CheckersMove.

	public class CheckersData{ //Object holds data about the game, which piece is on each square
	   public static final int  //Contents of squares of board
	           empty = 0,
	           red = 1,
	           redKing = 2,
	           black = 3,
	           blackKing = 4;
	   private int[][] board;  //board[r][c] is the contents of row r, column c.  
	   public CheckersData(){
		  board = new int[8][8];
	      setUpBoard();
	   }
	   
	   public void setUpBoard(){ //Set up board with default piece positions
	      for (int row = 0; row < 8; row++){
	         for (int col = 0; col < 8; col++){
	            if ( row % 2 == col % 2 ){
	               if (row < 3)
	                  board[row][col] = black;
	               else if (row > 4)
	                  board[row][col] = red;
	               else
	                  board[row][col] = empty;
	            }
	         }
	      }
	   }
	   
	   public void setPieceAt(int row, int col, int piece){ // Set the contents of the square in the specified row and column
	       board[row][col] = piece;
	   }
	   
	   public int pieceAt(int row, int col){ //Returns the contents of the square in the specified row and column
	       return board[row][col];
	   }
	   
	   public void makeMove(CheckersMove move){ //Perform the specified move
	      makeMove(move.fromRow, move.fromCol, move.toRow, move.toCol);
	   }
	   
	   public void makeMove(int fromRow, int fromCol, int toRow, int toCol){ //Perform the move from (fromRow,fromCol) to (toRow,toCol),  wipe piece on jump, king upon reaching opposite side
	      board[toRow][toCol] = board[fromRow][fromCol];
	      board[fromRow][fromCol] = empty;
	      if (fromRow - toRow == 2 || fromRow - toRow == -2) {//Jump handling
	         int jumpRow = (fromRow + toRow) / 2; 
	         int jumpCol = (fromCol + toCol) / 2; 
	         board[jumpRow][jumpCol] = empty;
	      }
	      if (toRow == 0 && board[toRow][toCol] == red) //King handling
	         board[toRow][toCol] = redKing;
	      if (toRow == 7 && board[toRow][toCol] == black)
	         board[toRow][toCol] = blackKing;
	   }
	   
	   public CheckersMove[] getLegalMoves(int player){
	      int playerKing;  
	      if (player == red)
	         playerKing = redKing;
	      else
	         playerKing = blackKing;

	      Vector moves = new Vector();  //Moves stored in this vector 

	      for (int row = 0; row < 8; row++){ //Check for possible jumps in each direction from square, if possible add to moves vector
	         for (int col = 0; col < 8; col++){
	            if (board[row][col] == player || board[row][col] == playerKing){
	               if (canJump(player, row, col, row+1, col+1, row+2, col+2))
	                  moves.addElement(new CheckersMove(row, col, row+2, col+2));
	               if (canJump(player, row, col, row-1, col+1, row-2, col+2))
	                  moves.addElement(new CheckersMove(row, col, row-2, col+2));
	               if (canJump(player, row, col, row+1, col-1, row+2, col-2))
	                  moves.addElement(new CheckersMove(row, col, row+2, col-2));
	               if (canJump(player, row, col, row-1, col-1, row-2, col-2))
	                  moves.addElement(new CheckersMove(row, col, row-2, col-2));
	            }
	         }
	      }
	      if (moves.size() == 0){ //Check for possible non-jumps in each direction from square, if possible add to moves vector
	         for (int row = 0; row < 8; row++){
	            for (int col = 0; col < 8; col++) {
	               if (board[row][col] == player || board[row][col] == playerKing){
	                  if (canMove(player,row,col,row+1,col+1))
	                     moves.addElement(new CheckersMove(row,col,row+1,col+1));
	                  if (canMove(player,row,col,row-1,col+1))
	                     moves.addElement(new CheckersMove(row,col,row-1,col+1));
	                  if (canMove(player,row,col,row+1,col-1))
	                     moves.addElement(new CheckersMove(row,col,row+1,col-1));
	                  if (canMove(player,row,col,row-1,col-1))
	                     moves.addElement(new CheckersMove(row,col,row-1,col-1));
	               }
	            }
	         }
	      }
	      if (moves.size() == 0) //No legal moves
		         return null;
	      else { //Copy the legal moves from the vector into the array, return the array
	         CheckersMove[] moveArray = new CheckersMove[moves.size()];
	         for (int i = 0; i < moves.size(); i++)
	            moveArray[i] = (CheckersMove)moves.elementAt(i);
	         return moveArray;
	      }
	   }  // end getLegalMoves

	   public CheckersMove[] getLegalJumpsFrom(int player, int row, int col){ //Return array of jumps player can execute
	      int playerKing;
	      if (player == red)
	         playerKing = redKing;
	      else
	         playerKing = blackKing;
	      Vector moves = new Vector();  //Legal jumps vector
	      if (board[row][col] == player || board[row][col] == playerKing){
	         if (canJump(player, row, col, row+1, col+1, row+2, col+2))
	            moves.addElement(new CheckersMove(row, col, row+2, col+2));
	         if (canJump(player, row, col, row-1, col+1, row-2, col+2))
	            moves.addElement(new CheckersMove(row, col, row-2, col+2));
	         if (canJump(player, row, col, row+1, col-1, row+2, col-2))
	            moves.addElement(new CheckersMove(row, col, row+2, col-2));
	         if (canJump(player, row, col, row-1, col-1, row-2, col-2))
	            moves.addElement(new CheckersMove(row, col, row-2, col-2));
	      }
	      if (moves.size() == 0) //No jumps
	         return null;
	      else {
		         CheckersMove[] moveArray = new CheckersMove[moves.size()];
		         for (int i = 0; i < moves.size(); i++)
		            moveArray[i] = (CheckersMove)moves.elementAt(i);
		         return moveArray;  //return moves for execution
		      }
	   } //end getLegalJumpsFrom
	   
	   public boolean canMove(int player, int r1, int c1, int r2, int c2){ //Move determination, whether the player can move from (r1,c1) to (r2,c2)  
	      if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
	         return false;  //(r2,c2) is off the board
	         
	      if (board[r2][c2] != empty)
	         return false;  //(r2,c2) already contains a piece

	      if (player == red){
	         if (board[r1][c1] == red && r2 > r1)
	             return false;  //Regular red piece can only move down
	          return true;  //Move is legal
	      }
	      else{
	         if (board[r1][c1] == black && r2 < r1)
	             return false;  //Regular black piece can only move up
	          return true;  //Move is legal
	      }
	   }  //end canMove()

	   public boolean canJump(int player, int r1, int c1, int r2, int c2, int r3, int c3){ //Jump determination, whether the player can jump from (r1,c1) to (r3,c3)
		  if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
		         return false;  //(r3,c3) is off the board
		         
	      if (board[r3][c3] != empty)
	         return false;  //(r3,c3) already contains a piece
	      
	      if (player == red){
	         if (board[r1][c1] == red && r3 > r1)
	            return false;  //Regular red piece can only move up
	         if (board[r2][c2] != black && board[r2][c2] != blackKing)
	            return false;  //No black piece to jump
	         return true;  //Legal jump
	      }
	      else{
	         if (board[r1][c1] == black && r3 < r1)
	            return false;  //Regular black piece can only move down
	         if (board[r2][c2] != red && board[r2][c2] != redKing)
	            return false;  //There is no red piece to jump
	         return true;  //Legal jump
	      }
	   }  //end canJump()
	}	
} //end class CheckersData