public class Knight extends Piece{

    public static final String key = "N";

    public Knight(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean attack(int row, int col) {
        if(Math.abs(this.row - row) > 2 || Math.abs(this.col - col) > 2 || (this.row == row && this.col == col))
            return false;
        if(Math.abs(this.row - row) == Math.abs(this.col - col))
            return false;
        return true;
    }

    public boolean move(int row, int col){
        return attack(row, col);
    }
}