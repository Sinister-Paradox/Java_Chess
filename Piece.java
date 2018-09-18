public abstract class Piece {

    public static final int WHITE = 1;
    public static final int BLACK = 0;

    protected int row;
    protected int col;
    protected final int color;
    protected final String key;

    public Piece(int row, int col, int color, String key){
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

    public int oppositeColor(){
        if(this.color == Piece.BLACK)
            return Piece.WHITE;
        else
            return Piece.BLACK;
    }

}
