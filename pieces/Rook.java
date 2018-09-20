package pieces;
import chess.*;

public class Rook extends Piece {

    private static final String key = "R";

    public Rook(int row, int col, int color){
        super(row, col, color, key);
    }

    public boolean attack(int row, int col, Square[][] board) {
        boolean[][] moveList = new boolean[Board.SIZE][Board.SIZE];
        int x = this.row - 1;
        int y = this.col;
        while(x >= 0){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                x--;
            }
        }
        x = this.row + 1;
        y = this.col;
        while(x < Board.SIZE){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                x++;
            }
        }
        x = this.row;
        y = this.col - 1;
        while(y >= 0){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                y--;
            }
        }
        x = this.row;
        y = this.col + 1;
        while(y < Board.SIZE){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                y++;
            }
        }
        return moveList[row][col];
    }

    public boolean move(int row, int col, Square[][] board){
        boolean[][] moveList = new boolean[Board.SIZE][Board.SIZE];
        int x = this.row - 1;
        int y = this.col;
        while(x >= 0){
            if(board[x][y].hasPiece())
                break;
            else {
                moveList[x][y] = true;
                x--;
            }
        }
        x = this.row + 1;
        y = this.col;
        while(x < Board.SIZE){
            if(board[x][y].hasPiece())
                break;
            else {
                moveList[x][y] = true;
                x++;
            }
        }
        x = this.row;
        y = this.col - 1;
        while(y >= 0){
            if(board[x][y].hasPiece())
                break;
            else {
                moveList[x][y] = true;
                y--;
            }
        }
        x = this.row;
        y = this.col + 1;
        while(y < Board.SIZE){
            if(board[x][y].hasPiece())
                break;
            else {
                moveList[x][y] = true;
                y++;
            }
        }
        return moveList[row][col];
    }
}