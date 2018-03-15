
public class ComputerPlayer implements Player {
    private ChompGame game; 
    private Strategy strat; 
    
    public ComputerPlayer(ChompGame game) {
        this.game = game; 
    }
    
    public void setStrategy(Strategy strat) {
        this.strat = strat; 
    }
    
    public void makeMove() {
        game.applyMove(strat.pickMove(game));
        Chomp.hasMoved(); 
    }
    
    public String getPrompt() {
        return " The computer is selecting a move."; 
    } 
    
    public String getWinMessage() {
        return " The computer won!";
    }
}
