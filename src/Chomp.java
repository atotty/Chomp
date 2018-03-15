/**
 * A board game program with someone
 * playing against the computer
 */

public class Chomp {
  private static ChompGame game;
  private static Player players[];
  private static int currentPlayer;

  // Called by the player when its move is completed.
  public static void hasMoved() {
    game.drawBoard(); 
    currentPlayer = (currentPlayer + 1) % 2;
    Player p = players[currentPlayer];
    if (game.isWon()) {
      System.out.println(p.getWinMessage());
    }
    else {
      System.out.println(p.getPrompt());
      p.makeMove();
    }
  }


  public static void main(String[] args) {
    // Initialize variables
    game = new ChompGame();
    HumanPlayer human = new HumanPlayer(game);
    ComputerPlayer computer = new ComputerPlayer(game);
    computer.setStrategy(new Chomp4by7Strategy());

    players = new Player[2];
    players[0] = human;
    players[1] = computer;
    currentPlayer = 0;
    
    // Start game
    game.drawBoard();
    System.out.println(" You go first... ");
    players[currentPlayer].makeMove();

    while (!game.isWon()) {
        players[currentPlayer].makeMove();
    }
  }
}

