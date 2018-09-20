package pieces;

import chess.*;

public class Pawn extends Piece {

    private static final String key = "P";

    public Pawn(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean move(int row, int col, Square[][] board){
        if(this.color == Piece.BLACK){
            if(this.row == 1){
                return (row == 2 || row == 3) && col == this.col;
            }
            else if(this.row < 7){
                return row == this.row + 1 && col == this.col;
            }
        }
        else if(this.getColor() == Piece.WHITE){
            if(this.row == 6){
                return (row == 5 || row == 4) && col == this.col;
            }
            else if(this.row > 0){
                return row == this.row - 1 && col == this.col;
            }
        }
        return false;
    }

    public boolean attack(int row, int col, Square[][] board){
        if(this.color == Piece.BLACK){
            return row == this.row + 1 && (col == this.col - 1 || col == this.col + 1);
        }
        else if(this.color == Piece.WHITE){
            return row == this.row - 1 && (col == this.col - 1 || col == this.col + 1);
        }
        return false;
    }
}
