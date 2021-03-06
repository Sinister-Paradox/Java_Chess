package pieces;

import chess.*;

public class Bishop extends Piece {

    private static final String key = "B";

    public Bishop(int row, int col, int color){
        super(row, col, color, key);
    }

    /*
    Function move, but goes one further to return true when on piece
     */
    public boolean attack(int row, int col, Square[][] board) {
        boolean[][] moveList = new boolean[Board.SIZE][Board.SIZE];
        int x = this.row - 1;
        int y = this.col - 1;
        while(x >= 0 && y >= 0){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                x--;
                y--;
            }
        }
        x = this.row + 1;
        y = this.col + 1;
        while(x < Board.SIZE && y < Board.SIZE){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                x++;
                y++;
            }
        }
        x = this.row + 1;
        y = this.col - 1;
        while(y >= 0 && x < Board.SIZE){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                y--;
                x++;
            }
        }
        x = this.row - 1;
        y = this.col + 1;
        while(y < Board.SIZE && x >= 0){
            if(board[x][y].hasPiece()) {
                moveList[x][y] = true;
                break;
            }
            else {
                moveList[x][y] = true;
                y++;
                x--;
            }
        }
        return moveList[row][col];
    }

    public boolean move(int row, int col, Square[][] board){
        boolean[][] moveList = new boolean[Board.SIZE][Board.SIZE];
        int x = this.row - 1;
        int y = this.col - 1;
        while(x >= 0 && y >= 0){
            if(board[x][y].hasPiece()) {
                break;
            }
            else {
                moveList[x][y] = true;
                x--;
                y--;
            }
        }
        x = this.row + 1;
        y = this.col + 1;
        while(x < Board.SIZE && y < Board.SIZE){
            if(board[x][y].hasPiece()) {
                break;
            }
            else {
                moveList[x][y] = true;
                x++;
                y++;
            }
        }
        x = this.row + 1;
        y = this.col - 1;
        while(y >= 0 && x < Board.SIZE){
            if(board[x][y].hasPiece()) {
                break;
            }
            else {
                moveList[x][y] = true;
                y--;
                x++;
            }
        }
        x = this.row - 1;
        y = this.col + 1;
        while(y < Board.SIZE && x >= 0){
            if(board[x][y].hasPiece()) {
                break;
            }
            else {
                moveList[x][y] = true;
                y++;
                x--;
            }
        }
        return moveList[row][col];
    }
}