package chess;

import pieces.Piece;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {

    private int row;
    private int col;
    private Piece piece;

    private static Dimension boxSize = new Dimension(100,100);

    Square(int row, int col){
        this.row = row;
        this.col = col;
        setPreferredSize(boxSize);
    }

    int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    int getCol(){
        return col;
    }

    public void setCol(int col){
        this.col = col;
    }

    Piece getPiece(){
        if(this.hasPiece())
            return piece;
        return null;
    }

    void setPiece(Piece piece){
        this.piece = piece;
        if(piece != null)
            setText(piece.getKey());
        else
            setText("");
    }

    void deletePiece(){
        this.piece = null;
    }

    public boolean hasPiece(){
        return this.piece != null;
    }

}
