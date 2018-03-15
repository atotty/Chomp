import java.util.Scanner; 

public class HumanPlayer implements Player {
    private ChompGame game; 
    private Scanner input; 
    
    public HumanPlayer(ChompGame game) {
        this.game = game; 
        input = new Scanner(System.in); 
    }
    
    public void makeMove() {
        System.out.print(" row: "); 
        int r = input.nextInt(); 
        System.out.print(" column: "); 
        int c = input.nextInt(); 
        
        while (!game.moveIsValid(r,c)) {
            System.out.println(" Invalid move. Try again: "); 
            System.out.print(" row: "); 
            r = input.nextInt(); 
            System.out.print(" column: "); 
            c = input.nextInt(); 
        }
        
        game.applyMove(new Location(r,c));
        Chomp.hasMoved();
    }
    
    public String getPrompt() {
        return " Input the coordinates of your move: "; 
    } 
    
    public String getWinMessage() {
        return " You won!";
    }
}
