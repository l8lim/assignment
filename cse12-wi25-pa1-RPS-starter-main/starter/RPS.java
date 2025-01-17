import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     *
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            System.arraycopy(args, 0, moves, 0, args.length);
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);

        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
                System.out.println(PROMPT_MOVE);

        String input = in.nextLine();
        while(!input.equals("q"))
        {
            
            if(game.isValidMove(input))
            {
            String cpuMove = game.genCPUMove();
            game.playRPS(input, cpuMove);
            }
            else
            {
                System.out.println(INVALID_INPUT);
            }
                System.out.println(PROMPT_MOVE);
                input = in.nextLine();
        }
        game.displayStats();

        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work! And don't forget Javadoc.

        in.close();
    }

    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        if(isValidMove(playerMove))
        {
            int indexPlayer = 0;
            int indexCpu = 0;
            for(int i = 0; i < possibleMoves.length; i++)
            {
                if(possibleMoves[i].equals(playerMove))
                {
                    indexPlayer = i;
                }
                if(possibleMoves[i].equals(cpuMove))
                {
                    indexCpu = i;
                }

            }

            int dif = indexPlayer-indexCpu;
            if(dif == 1)
            {
                return PLAYER_WIN_OUTCOME;
            }
            else if(dif == -1)
            {
                return CPU_WIN_OUTCOME;
            }
            else if(indexPlayer == 0)
            {
                if(indexCpu == possibleMoves.length - 1)
                {
                    return PLAYER_WIN_OUTCOME;
                }
                else
                {
                    return TIE_OUTCOME;
                }
            }
            else {
                return TIE_OUTCOME;
            }
        }
        return INVALID_INPUT_OUTCOME;
          // replace this when you implement the method
    }
}
