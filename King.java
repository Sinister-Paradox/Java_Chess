public class King extends Piece{

    public static final String key = "K";

    public King(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean attack(int row, int col) {
        if(Math.abs(this.row - row) > 1 || Math.abs(this.col - col) > 1)
            return false;
        else if (this.row == row && this.col == col)
            return false;
        return true;
    }

    public boolean move(int row, int col){
        if(Math.abs(this.row - row) > 1 || Math.abs(this.col - col) > 1)
            return false;
        else if (this.row == row && this.col == col)
            return false;
        return true;
    }
}
