
public class ChompGame extends CharMatrix {
    private char fill = '@';
    
    public ChompGame() {
        super(4,7);    
    }
    
    public void applyMove(Location loc) {
        if (!moveIsValid(loc.row, loc.col)) {
            throw new IllegalArgumentException("Invalid move"); 
        }
        else {
            clearRect(loc.row, loc.col, numRows()-1, numCols()-1);
        }
    }
    
    public boolean moveIsValid(int row, int col) {
        return (row<numRows() && col<numCols() ) && ( !isEmpty(row,col) ) ; 
    }
    
    public boolean isWon() {
        if (super.isEmpty(0,0))
            return true;
        return false;
    }
    
    public void drawBoard() {
        // Draw new board
        // Spacing
        System.out.println(); System.out.println(); 
        // Column headers
        System.out.print("\t"); 
        for (int i = 0; i < this.numCols(); i++) 
            System.out.print(i+"\t"); 
        System.out.println(); 
        System.out.println(); 
        
        for (int i = 0; i < this.numRows(); i++) {
            System.out.print(i+"\t"); 
            for (int j = 0; j < this.numCols(); j++) {
                if (i==0 && j==0) 
                    System.out.print("X\t"); 
                else if (!isEmpty(i,j))
                    System.out.print(this.fill+"\t"); 
                else
                    System.out.print("\t"); 
            }
            System.out.println();
            System.out.println();
        }

    }
}
