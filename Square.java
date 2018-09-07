import javax.swing.*;
import java.awt.*;

public class Square extends JButton {

    private int row;
    private int col;
    private Piece piece;

    private static Dimension boxSize = new Dimension(50,50);

    public Square(int row, int col){
        this.row = row;
        this.col = col;
        setPreferredSize(boxSize);
    }

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

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        setText(piece.key);
    }

    public void deletePiece(){
        this.piece = null;
    }

    public boolean hasPiece(){
        if(this.piece != null){
            return true;
        }
        return false;
    }

}
