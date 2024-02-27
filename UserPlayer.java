import java.util.Scanner;
public class UserPlayer extends Player
{
    private String name;
    private Scanner input;

    public UserPlayer(Scanner input, String name)
    {
        this.name = name;
        this.input = input;
    }

    @Override
    public String toString()
    {
        return name;
    }

	@Override
	public TicTacToe chooseMove(TicTacToe a) {
		System.out.println(a);
		System.out.println();
		
		// get possible moves from this board
		TicTacToe[] possibleMoves = a.possibleMoves(this);
		TicTacToe possibleMove = null;
		
		// ask the user to choose a move
		boolean choose = true;
		while( choose )
		{
			System.out.println("Choose a move (1-" + (possibleMoves.length) + "): ");
			for( int i=0; i<possibleMoves.length; i++ )
			{
				System.out.println((i+1) + ")\n" + possibleMoves[i]);
				System.out.println();
			}
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			if( choice < 1 || choice > possibleMoves.length )
			{
				System.out.println("Enter a valid move number!\n");
				continue;
			}
			possibleMove = possibleMoves[ choice-1 ];
			choose = false;
		}
		return possibleMove;
	}
	

}