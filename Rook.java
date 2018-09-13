public class Rook extends Piece{

    public static final String key = "R";

    public Rook(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean attack(int row, int col) {
        return false;
    }

    public boolean move(int row, int col){
        return attack(row, col);
    }
}