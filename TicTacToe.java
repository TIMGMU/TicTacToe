public class TicTacToe
{
    private char[][] board = new char[3][3];
    private Player x;
    private Player o;

    public TicTacToe(Player x, Player o)
    {
        this.x = x;
        this.o = o;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = '_';
            }
        }
    }

    public void setXPlayer(Player x)
    {
        this.x = x;
    }

    public Player getXPlayer()
    {
        return x;
    }

    public void setOPlayer(Player o)
    {
        this.o = o;
    }

    public Player getOPlayer()
    {
        return o;
    }

    public void setBoard(char[][] board)
    {
        this.board = board;
    }

    public char[][] getBoard()
    {
        return board;
    }

    public int countBlanks()
    {
        int counter  = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '_')
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    public char markerForPlayer(Player a)
    {
        char type = 0;
        if (a.equals(x))
        {
            type = 'X';
        }
        else if (a.equals(o))
        {
            type = 'O';
        }

        return type;
    }
    
    private boolean checkHorizontalWin(char c) 
    {
    	for (int i = 0; i < 3; i++)
    	{
    		if( board[i][0] == c && board[i][1] == c && board[i][2] == c )
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean checkVerticalWin(char c) 
    {
    	for (int j = 0; j < 3; j++)
    	{
    		if( board[0][j] == c && board[1][j] == c && board[2][j] == c )
    		{
    			return true;
    		}
    	}
    	return false;
    }	
    
    private boolean checkDiagonlWin(char c) 
    {
    	if( board[0][0] == c && board[1][1] == c && board[2][2] == c )
		{
			return true;
		}
    	if( board[0][2] == c && board[1][1] == c && board[2][0] == c )
		{
			return true;
		}
    	return false;
    }	
    

    public boolean checkWin(Player a)
    {
    	char mark = markerForPlayer(a);
        if( checkDiagonlWin(mark) || checkHorizontalWin(mark) || checkVerticalWin(mark) ) 
        {
        	return true;
        }
        return false;
    }

    public boolean checkLose(Player a)
    {
    	char markThis = markerForPlayer(a);
    	char markOther = markThis == 'X' ? '0' : 'X';
    	if( checkDiagonlWin(markOther) || checkHorizontalWin(markOther) || checkVerticalWin(markOther) ) 
        {
        	return true;
        }
    	return false;
    }

    public boolean checkDraw()
    {
        if( countBlanks()==0 && !checkWin(o) && !checkWin(x) ) 
        {
        	return true;
        }
        return false;
    }

    public String toString()
    {
        String completed = "";
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                completed = completed + board[i][j] + " ";
            }
            completed = completed + "\n";
        }
        return completed;
    }

    public TicTacToe[] possibleMoves(Player a)
    {
    	int numBlanks = countBlanks();
        TicTacToe[] arrayOfBoards = new TicTacToe[numBlanks];
        for (int k = 0; k < numBlanks; k++) 
        {
        	arrayOfBoards[k] = new TicTacToe(x, o);
        	for (int i = 0; i < 3; i++)
        	{
        		for (int j = 0; j < 3; j++)
        		{
        			arrayOfBoards[k].board[i][j] = this.board[i][j];
        		}
        	}
        }
        
        int k = 0;
        // CHECK: i-j is row-column order or column-row order?
        for (int i = 0; i < 3; i++)
        {
        	for (int j = 0; j < 3; j++)
        	{
        		if (this.board[i][j] == '_')
        		{
        			arrayOfBoards[k++].board[i][j] = markerForPlayer(a);
        		}
        	}
        }
        
//        for (int k = 0; k < countBlanks(); k++) //Iterate through all possible # moves
//        {
//        	arrayOfBoards[k] = new TicTacToe(x, o);
//        	// copy board
//        	for (int i = 0; i < 3; i++)
//        	{
//        		for (int j = 0; j < 3; j++)
//        		{
//        			arrayOfBoards[k].board[i][j] = this.board[i][j];
//        		}
//        	}
//        	
//        	// set the blank in the other 
//            for (int i = 0; i < 3; i++)
//            {
//                for (int j = 0; j < 3; j++)
//                {
//                    if (this.board[i][j] == '_')
//                    {
//                        this.board[i][j] = a.markerForPlayer();
//                        i = 4;
//                        j = 4;
//                        break;
//                    }
//                }
//
//            } 
//        }
        
        return arrayOfBoards;
    }
}