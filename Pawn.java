public class Pawn extends Piece {

    public static final String key = "P";

    public Pawn(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean move(int row, int col){
        if(this.color == Piece.BLACK){
            if(this.row == 1){
                if((row == 2 || row == 3) && col == this.col) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(this.row < 7){
                if(row == this.row + 1 && col == this.col) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else if(this.color == Piece.WHITE){
            if(this.row == 6){
                if((row == 5 || row == 4) && col == this.col) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(this.row > 0){
                if(row == this.row - 1 && col == this.col) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public boolean attack(int row, int col){
        if(this.color == Piece.BLACK){
            if(row == this.row + 1 && (col == this.col - 1 || col == this.col + 1)) {
                return true;
            }
        }
        else if(this.color == Piece.WHITE){
            if(row == this.row - 1 && (col == this.col - 1 || col == this.col + 1)) {
                return true;
            }
        }
        return false;
    }
}
