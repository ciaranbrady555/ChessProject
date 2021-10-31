import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*
	This class can be used as a starting point for creating your Chess game project. The only piece that 
	has been coded is a white pawn...a lot done, more to do!
*/
 
public class ChessProject extends JFrame implements MouseListener, MouseMotionListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
	int startX;
	int startY;
	int initialX;
	int initialY;
	JPanel panels;
	JLabel pieces;
	boolean wturn=true;
 
    public ChessProject(){
        Dimension boardSize = new Dimension(600, 600);


 
        //  Use a Layered Pane for this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane 
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
 
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );
 
            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.white : Color.gray );
            else
                square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
        }
 
        // Setting up the Initial Chess board.
		for(int i=8;i < 16; i++){			
       		pieces = new JLabel( new ImageIcon("WhitePawn.png") );
			panels = (JPanel)chessBoard.getComponent(i);
	        panels.add(pieces);	        
		}
		pieces = new JLabel( new ImageIcon("WhiteRook.png") );
		panels = (JPanel)chessBoard.getComponent(0);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteKnight.png") );
		panels = (JPanel)chessBoard.getComponent(1);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteKnight.png") );
		panels = (JPanel)chessBoard.getComponent(6);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteBishup.png") );
		panels = (JPanel)chessBoard.getComponent(2);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteBishup.png") );
		panels = (JPanel)chessBoard.getComponent(5);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteKing.png") );
		panels = (JPanel)chessBoard.getComponent(3);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
		panels = (JPanel)chessBoard.getComponent(4);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("WhiteRook.png") );
		panels = (JPanel)chessBoard.getComponent(7);
	    panels.add(pieces);
		for(int i=48;i < 56; i++){			
       		pieces = new JLabel( new ImageIcon("BlackPawn.png") );
			panels = (JPanel)chessBoard.getComponent(i);
	        panels.add(pieces);	        
		}
		pieces = new JLabel( new ImageIcon("BlackRook.png") );
		panels = (JPanel)chessBoard.getComponent(56);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackKnight.png") );
		panels = (JPanel)chessBoard.getComponent(57);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackKnight.png") );
		panels = (JPanel)chessBoard.getComponent(62);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackBishup.png") );
		panels = (JPanel)chessBoard.getComponent(58);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackBishup.png") );
		panels = (JPanel)chessBoard.getComponent(61);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackKing.png") );
		panels = (JPanel)chessBoard.getComponent(59);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackQueen.png") );
		panels = (JPanel)chessBoard.getComponent(60);
	    panels.add(pieces);
		pieces = new JLabel( new ImageIcon("BlackRook.png") );
		panels = (JPanel)chessBoard.getComponent(63);
	    panels.add(pieces);		
    }

	private void turns(){
		if(wturn){
			//change it to false
		}else{
			//change it to true
		}
	}
	
	private void winCheck(){
		
	}

	private Boolean piecePresent(int x, int y){
		Component c = chessBoard.findComponentAt(x, y);
		if(c instanceof JPanel){
			return false;
		}
		else{
			return true;
		}
	}
	
	private Boolean checkIfBlack(int newX, int newY){
		Boolean oponent;
		Component c1 = chessBoard.findComponentAt(newX, newY);
		JLabel awaitingPiece = (JLabel)c1;
		String tmp1 = awaitingPiece.getIcon().toString();			
		if(((tmp1.contains("Black")))){
			oponent = true;
		}
		else{
			oponent = false; 
		}		
		return oponent;
	}	

	private Boolean checkIfWhite(int newX, int newY){
		Boolean oponent;
		Component c1 = chessBoard.findComponentAt(newX, newY);
		JLabel awaitingPiece = (JLabel)c1;
		String tmp1 = awaitingPiece.getIcon().toString();			
		if(((tmp1.contains("White")))){
			oponent = true;
		}
		else{
			oponent = false; 
		}		
		return oponent;
	}	

    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        if (c instanceof JPanel) 
			return;
 
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel)c;
		initialX = e.getX();
		initialY = e.getY();
		startX = (e.getX()/75);
		startY = (e.getY()/75);
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		
		
    }
   
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
         chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
     }
     
    public void mouseReleased(MouseEvent e) {

        if(chessPiece == null) return;
 
        chessPiece.setVisible(false);
		Boolean success =false;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		String tmp = chessPiece.getIcon().toString();
		String pieceName = tmp.substring(0, (tmp.length()-4));
		Boolean validMove = false;

		int newY = e.getY()/75;
		int newX = e.getX()/75;	
		int yMove =Math.abs(startY-newY);
		int xMove = Math.abs(startX-newX);
		int distance = Math.abs(startX-newX);
		
		System.out.println("------------------------------------");
		System.out.println("piece being moved "+ pieceName);
		System.out.println("starts @" + "( " + startX + ", "+startY+" )");
		System.out.println("the xMove is "+ xMove);
		System.out.println("the yMove is "+ yMove);
		System.out.println("lands @ " + "( "+newX+" , "+newY+" )");
		System.out.println("white turn?" + wturn);
		System.out.println("----------------------------------------");


		
		//turn movement restriction
		//doesn't work rn cause no real turn switching and you place it in a piece code like the blocked check
	/*	if(wturn){
			if(pieceName.contains("Black")){
				validMove=false;
			}
		}else{
			if(pieceName.contains("White")){
				validMove=false;
			}
		} */




		//king
		// movement 100%
		// Moving out of check 0%
		// checking for Check 0%
		if(pieceName.contains("King")){
			Boolean check = false;
			if(((startX == (newX))&&((yMove)==1))||((startY==(newY))&&((xMove)==1)||((startX == (newX))&&((yMove)==-1))||((startY==(newY))&&((xMove)==-1)))||(yMove == xMove && yMove== 1)){
				//if(distance)	
					//for loop
						// if (piece present)
							//check colour
								//check y/n

				// not sure how to check the attacks spaces feels like a huge amount of code
				// 
				//repeat for other movements

					
				

					if(check){
						validMove=false;
					}else if(piecePresent(e.getX(), e.getY())){
							if(pieceName.contains("White")){
								if(checkIfBlack(e.getX(),e.getY())){
									validMove = true;
								}else{validMove=false;}
							}else{
								if(checkIfWhite(e.getX(),e.getY())){
									validMove=true;
								}else{validMove=false;}
							}
						}else{validMove=true;}

					/*	if(wturn){
							if(pieceName.contains("Black")){
								validMove=false;
							}
						}else{
							if(pieceName.contains("White")){
								validMove=false;
							}
						} 	*/	
			}
		}
	
		
		//queen
		if(pieceName.contains("Queen")){
			boolean blocked=false;
			if((Math.abs(startX-newX)!=0)&&(Math.abs(startY-newY) == 0) || (Math.abs(newX-startX) == 0)&&(Math.abs(newY-startY) !=0)){
				if(Math.abs(startX-newX)!=0){
					if(startX-newX > 0){
						for(int i=0;i<xMove;i++){
							if(piecePresent(initialX-(i*75), e.getY())){
								blocked=true;
								break;
							}
							else{blocked=false;}
						}	
					}else{
						for(int i=0;i<xMove;i++){
							if(piecePresent(initialX+(i*75), e.getY())){
								blocked=true;
								break;
							}else{blocked=false;}
						}
					}
				}else{
					if(startY-newY>0){
						for(int i=0;i<yMove;i++){
							if(piecePresent(e.getX(),initialY-(i*75))){
								blocked=true;
								break;
							}else{blocked=false;}
						}
					}else{
						for(int i=0;i<yMove;i++){
							if(piecePresent(e.getX(),initialY+(i*75))){
								blocked=true;
								break;
							}else{blocked=false;}
						}
				}
			}

				
				if(blocked){
					validMove=false;
				}else if(piecePresent(e.getX(), e.getY())){
						if(pieceName.contains("White")){
							if(checkIfBlack(e.getX(),e.getY())){
								validMove = true;
							}else{validMove=false;}
						}else{
							if(checkIfWhite(e.getX(),e.getY())){
								validMove=true;
							}else{validMove=false;}
						}
					}else{validMove=true;}

			}else if(Math.abs(startX-newX)==Math.abs(startY-newY)){
				if((startX-newX<0)&&(startY-newY<0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX+(i*75)) , (initialY+(i*75)))){
							blocked=true;
						}
					}
				}else if ((startX-newX < 0) && (startY-newY>0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX+(i*75)) , (initialY-(i*75)))){
							blocked=true;
						}
					}
				}else if((startX-newX > 0) && (startY-newY > 0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX-(i*75)) , (initialY-(i*75)))){
							blocked=true;
						}
					}
				}else if((startX-newX > 0 ) && (startY-newY < 0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX-(i*75)) , (initialY+(i*75)))){
							blocked=true;
						}
					}
				}else{blocked=false;}
			

			if(blocked){
				validMove=false;
			}else if(piecePresent(e.getX(), e.getY())){
					if(pieceName.contains("White")){
						if(checkIfBlack(e.getX(),e.getY())){
							validMove = true;
						}else{validMove=false;}
					}else{
						if(checkIfWhite(e.getX(),e.getY())){
							validMove=true;
						}else{validMove=false;}
					}
				}else{validMove=true;} 
			}
		}
		
		
		
		//rook finished
		if(pieceName.contains("Rook")){
			boolean blocked = false;
			if((xMove!=0)&&(yMove == 0) || (xMove == 0)&&(yMove !=0)){
				if(xMove!=0){
					if(startX-newX > 0){
						for(int i=0;i<xMove;i++){
							if(piecePresent(initialX-(i*75), e.getY())){
								blocked=true;
								break;
							}
							else{blocked=false;}
						}	
					}else{
						for(int i=0;i<xMove;i++){
							if(piecePresent(initialX+(i*75), e.getY())){
								blocked=true;
								break;
							}else{blocked=false;}
						}
					}
				}else{
					if(startY-newY>0){
						for(int i=0;i<yMove;i++){
							if(piecePresent(e.getX(),initialY-(i*75))){
								blocked=true;
								break;
							}else{blocked=false;}
						}
					}else{
						for(int i=0;i<yMove;i++){
							if(piecePresent(e.getX(),initialY+(i*75))){
								blocked=true;
								break;
							}else{blocked=false;}
						}
				}
			}

				
				if(blocked){
					validMove=false;
				}else if(piecePresent(e.getX(), e.getY())){
						if(pieceName.contains("White")){
							if(checkIfBlack(e.getX(),e.getY())){
								validMove = true;
							}else{validMove=false;}
						}else{
							if(checkIfWhite(e.getX(),e.getY())){
								validMove=true;
							}else{validMove=false;}
						}
					}else{validMove=true;}
				}
			



		/*	if(startX==(newX)||startY==(newY)){	
				if(!piecePresent(e.getX(), e.getY())){
					validMove=true;
					
				}
				else{
					validMove=false;
				}
			}
			else{
				validMove=false;
			}*/
		}
	

		//Bishops finished
		if(pieceName.contains("Bishup")){
			Boolean blocked=false;
			if(xMove==yMove){
				if((startX-newX<0)&&(startY-newY<0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX+(i*75)) , (initialY+(i*75)))){
							blocked=true;
						}
					}
				}else if ((startX-newX < 0) && (yMove>0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX+(i*75)) , (initialY-(i*75)))){
							blocked=true;
						}
					}
				}else if((startX-newX > 0) && (startY-newY > 0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX-(i*75)) , (initialY-(i*75)))){
							blocked=true;
						}
					}
				}else if((startX-newX > 0 ) && (startY-newY < 0)){
					for(int i=0; i < distance; i++){
						if(piecePresent((initialX-(i*75)) , (initialY+(i*75)))){
							blocked=true;
						}
					}
				}else{blocked=false;}
			

			if(blocked){
				validMove=false;
			}else if(piecePresent(e.getX(), e.getY())){
					if(pieceName.contains("White")){
						if(checkIfBlack(e.getX(),e.getY())){
							validMove = true;
						}else{validMove=false;}
					}else{
						if(checkIfWhite(e.getX(),e.getY())){
							validMove=true;
						}else{validMove=false;}
					}
				}else{validMove=true;} 
			}
		}

		
		

		//knight finished
		if(pieceName.contains("Knight")){
		//	if(newX<0||newX>7||newY<0||newX>7){
			//	validMove=false;
		//	}else{
				if((newX==startX+1)&&(newY==startY+2)||(newX==startX-1)&&(newY==startY+2)||(newX==startX+2)&&(newY==startY+1)||(newX==startX-2)&&(newY==startY+1)||(newX==startX+1)
				&&(newY==startY-2)||(newX==startX-1)&&(newY==startY-2)||(newX==startX+2)&&(newY==startY-1)||(newX==startX-2)&&(newY==startY-1)){
					if(piecePresent(e.getX(), e.getY())){
						if(pieceName.contains("White")){
							if(checkIfBlack(e.getX(), e.getY())){ 
								validMove=true;
							}else{validMove=false;}
						}else if(pieceName.contains("Black")){
							if(checkIfWhite(e.getX(), e.getY())){
								validMove=true;
							}else{validMove=false;}
						}else{validMove=false;}
					}else{validMove=true;}	
				}else{validMove=false;}
			}	
	//	}



		//pawns finished
		if(pieceName.equals("BlackPawn")){
			//first turn - working
			if(startY == 6){
				if((startX == (newX))&&((((newY)-startY)==-1)||((newY)-startY)==-2)){
					if((((newY)-startY)==-2)){
						if((!piecePresent(e.getX(), (e.getY()))) &&(!piecePresent(e.getX(), (e.getY()+75)))){
							validMove = true;					
						}
						else{validMove=false;}							
					}
					else if((((newY)-startY)==-1)){
						if((!piecePresent(e.getX(), (e.getY()))))
						{validMove = true;}
						else{validMove=false;}
					}
					else{validMove=false;}
				}
				else if((((newY)-startY)==-1)&&(newX==startX-1)||(newX==startX+1)){
					if(!piecePresent(e.getX(), e.getY())){
						validMove=false;
					}else if(checkIfWhite(e.getX(), e.getY())){
						validMove=true;
					}else{validMove=false;}
				}
				else{validMove = false;}
			}
			else if((((newY)-startY)== -1)){   // any move after first			
				if((startX-1 >=0)||(startX +1 <=7))
				{
					if((piecePresent(e.getX(), (e.getY())))&&((((newX == (startX+1)&&(startX+1<=7)))||((newX == (startX-1))&&(startX-1 >=0)))))
					{
						if(checkIfWhite(e.getX(), e.getY())){
							validMove = true;
							if(startY == 1){
								success = true;
							}						
						}
						else{
							validMove = false;
						}
					}
					else{
						if(!piecePresent(e.getX(), (e.getY()))){
							if((startX == (newX))&&((newY)-startY)==-1){
								if(startY == 1){
									success = true;
								}
								validMove = true;
							}
							else{
								validMove = false;
							}				
						}
						else{
							validMove = false;	
						}
					}
				}
				else{
					validMove = false;
				}				
			}
		}
		//------------------------------//   

		if(pieceName.equals("WhitePawn")){ //197
			//movement
			if(startY == 1){
				if((startX == (newX))&&((((newY)-startY)==1)||((newY)-startY)==2)){
					if((((newY)-startY)==2)){
						if((!piecePresent(e.getX(), (e.getY()))) &&(!piecePresent(e.getX(), (e.getY()-75)))){
							validMove = true;					
						}
						else{validMove=false;}							
					}
					else if((((newY)-startY)==1)){
						if((!piecePresent(e.getX(), (e.getY()))))
						{validMove = true;}
						else{validMove=false;}
					}
					else{validMove=false;}
				}
				else if((((newY)-startY)==1)&&(newX==startX-1)||(newX==startX+1)){
					if(!piecePresent(e.getX(), e.getY())){
						validMove=false;
					}else if(checkIfBlack(e.getX(), e.getY())){
						validMove=true;
					}else{validMove=false;}
				}
				else{validMove = false;}
			}
			else if((((newY)-startY)==1)){   // any move after first			
				if((startX-1 >=0)||(startX +1 <=7))
				{
					if((piecePresent(e.getX(), (e.getY())))&&((((newX == (startX+1)&&(startX+1<=7)))||((newX == (startX-1))&&(startX-1 >=0)))))
					{
						if(checkIfBlack(e.getX(), e.getY())){
							validMove = true;
							if(startY == 6){
								success = true;
							}						
						}
						else{validMove = false;}
					}
					else{
						if(!piecePresent(e.getX(), (e.getY()))){
							if((startX == (newX))&&((newY)-startY)==1){
								if(startY == 6){
									success = true;
								}
								validMove = true;
							}
							else{validMove = false;}				
						}else{validMove = false;}
					}
				}else{validMove = false;}				
			}			
		}
		//
		if(!validMove){		
			int location=0;
			if(startY ==0){
				location = startX;
			}
			else{
				location  = (startY*8)+startX;
			}
			String pieceLocation = pieceName+".png"; 
			pieces = new JLabel( new ImageIcon(pieceLocation) );
			panels = (JPanel)chessBoard.getComponent(location);
		    panels.add(pieces);			
		}
		else{
			if(success && pieceName.contains("White")){
				int location = 56 + (e.getX()/75);
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
					pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);			
				}
				else{
					Container parent = (Container)c;
	            	pieces = new JLabel( new ImageIcon("WhiteQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);	            	
				}
			}else if(success && pieceName.contains("Black")){
				int location = (e.getX()/75);
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
					pieces = new JLabel( new ImageIcon("BlackQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);			
				}
				else{
					Container parent = (Container)c;
	            	pieces = new JLabel( new ImageIcon("BlackQueen.png") );
					parent = (JPanel)chessBoard.getComponent(location);
			    	parent.add(pieces);	            	
				}
			}else{
				if (c instanceof JLabel){
	            	Container parent = c.getParent();
	            	parent.remove(0);
	            	parent.add( chessPiece );
	        	}
	        	else {
	            	Container parent = (Container)c;
	            	parent.add( chessPiece );
	        	}
	    		chessPiece.setVisible(true);									
			}
		}



	}
    
 
    public void mouseClicked(MouseEvent e) {
	
    }
    public void mouseMoved(MouseEvent e) {
   }
    public void mouseEntered(MouseEvent e){
	
    }
    public void mouseExited(MouseEvent e) {
	
    }
 	
	/*
		Main method that gets the ball moving.
	*/
    public static void main(String[] args) {
        JFrame frame = new ChessProject();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }
}


