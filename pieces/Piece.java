package pieces;
import chess.*;

public abstract class Piece {

    // Piece representations
    public static final int WHITE = 1;
    public static final int BLACK = 0;

    int row;
    int col;
    final int color;
    private final String key;

    Piece(int row, int col, int color, String key){
        this.row = row;
        this.col = col;
        this.color = color;
        this.key = key;
    }

    public abstract boolean move(int row, int col, Square[][] board);

    public abstract boolean attack(int row, int col, Square[][] board);

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getCol(){
        return col;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getColor(){
        return this.color;
    }

    public String getKey(){
        return this.key;
    }

    public int oppositeColor(){
        if(this.color == Piece.BLACK)
            return Piece.WHITE;
        return Piece.BLACK;
    }

}
