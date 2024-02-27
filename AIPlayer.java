public class AIPlayer extends Player
{
	private String name;
	private Player opponent;
	
	public AIPlayer(String name, Player opponent)
	{
		this.name = name;
		this.opponent = opponent;		
	}
	
	public double minValue(TicTacToe a)
	{
		if( a.checkWin(this) )
		{
			return 1.0;
		}
		else if( a.checkLose(this) ) 
		{
			return -1.0;
		}
		else if( a.checkDraw() )
		{
			return 0.0;
		}
		else 
		{
			TicTacToe[] possibleMoves = a.possibleMoves(opponent);
			double[] maxValues = new double[possibleMoves.length];
			for( int i=0; i<possibleMoves.length; i++ )
			{
				maxValues[i] = maxValue(possibleMoves[i]);
			}
			int lowest = 0;
			for( int i=1; i<possibleMoves.length; i++ ) 
			{
				if( maxValues[i] < maxValues[lowest] ) 
				{
					lowest = i;
				}
			}
			return maxValues[lowest];
		}
	}
	
	public double maxValue(TicTacToe a)
	{
		if( a.checkWin(this) )
		{
			return 1.0;
		}
		else if( a.checkLose(this) ) 
		{
			return -1.0;
		}
		else if( a.checkDraw() )
		{
			return 0.0;
		}
		else 
		{
			TicTacToe[] possibleMoves = a.possibleMoves(this);
			double[] minValues = new double[possibleMoves.length];
			for( int i=0; i<possibleMoves.length; i++ )
			{
				minValues[i] = minValue(possibleMoves[i]);
			}
			int highest = 0;
			for( int i=1; i<possibleMoves.length; i++ ) 
			{
				if( minValues[i] > minValues[highest] ) 
				{
					highest = i;
				}
			}
			return minValues[highest];
		}
	}
	
	@Override
	public TicTacToe chooseMove(TicTacToe a) {
		TicTacToe[] possibleMoves = a.possibleMoves(this);
		double[] minValues = new double[possibleMoves.length];
		for( int i=0; i<possibleMoves.length; i++ )
		{
			minValues[i] = minValue(possibleMoves[i]);
		}
		int highest = 0;
		for( int i=1; i<possibleMoves.length; i++ ) 
		{
			if( minValues[i] > minValues[highest] ) 
			{
				highest = i;
			}
		}
		return possibleMoves[highest];
	}
	
	public String toString() {
		return name + " (AI)";
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
    
}