public abstract class Player
{
    public abstract TicTacToe chooseMove(TicTacToe a);

    public double boardValue(TicTacToe a) //TODO:
    {
        if (a.checkWin(this)) //Not sure if this works
        {
            return 1.0;
        }
        else if (a.checkLose(this))
        {
            return -1.0;
        }
        else 
        {
            return 0.0;
        }
    }
}