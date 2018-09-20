package chess;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {

    private static final String TITLE = "Chess";
    public static final int SIZE = 8;
    private Square[][] grid;

    private boolean pieceSelected = false;
    private Square selected = null;

    private int turn = Piece.WHITE;

    Board(){
        setTitle(TITLE);
        GridLayout layout = new GridLayout(SIZE, SIZE);
        setLayout(layout);

        // Create 8x8 grid layout, populated with squares
        grid = new Square[SIZE][SIZE];
        for(int i = 0;i<SIZE;i++){
            for(int j = 0;j<SIZE;j++) {
                Square temp = new Square(i, j);
                temp.setBackground(Color.WHITE);
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Square source =(Square) e.getSource();
                        if(!pieceSelected && source.hasPiece() && source.getPiece().getColor() == turn){
                            source.setBackground(Color.PINK);
                            pieceSelected = true;
                            selected = source;
                        }
                        else if(pieceSelected && source == selected){
                            source.setBackground(Color.WHITE);
                            selected = null;
                            pieceSelected = false;
                        }
                        else if(pieceSelected){
                            boolean movable;

                            // If square contains enemy piece
                            if (source.hasPiece() && source.getPiece().oppositeColor() == selected.getPiece().getColor()){
                                movable = selected.getPiece().attack(source.getRow(), source.getCol(), grid);
                            }
                            else if(source.hasPiece() && source.getPiece().getColor() == selected.getPiece().getColor()){
                                movable = false;
                            }
                            else {
                                movable = selected.getPiece().move(source.getRow(), source.getCol(), grid);
                            }
                            System.out.println(movable);
                            if(movable){

                                source.setPiece(selected.getPiece());
                                selected.deletePiece();

                                source.getPiece().setCol(source.getCol());
                                source.getPiece().setRow(source.getRow());

                                System.out.println(selected.getPiece());
                                System.out.println(source.getPiece());

                                selected.setBackground(Color.WHITE);
                                if(source.getPiece().getColor() == Piece.BLACK)
                                    source.setForeground(Color.RED);
                                else
                                    source.setForeground(Color.BLACK);
                                selected.setText("");

                                selected = null;
                                pieceSelected = false;

                                turn = source.getPiece().oppositeColor();

                            }

                        }
                    }
                });
                grid[i][j] = temp;
                add(temp);
            }
        }
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setPiece(int row, int col, int color, Piece piece){
        grid[row][col].setPiece(piece);
        if(color == Piece.BLACK)
            grid[row][col].setForeground(Color.RED);
        else
            grid[row][col].setForeground(Color.BLACK);
    }

    void init(){
        for(int i = 0;i<8;i++) {
            Pawn p = new Pawn(1, i, Piece.BLACK);
            setPiece(1,i,Piece.BLACK, p);
        }

        for(int i = 0;i<8;i++) {
            Pawn p = new Pawn(6, i, Piece.WHITE);
            setPiece(6,i,Piece.WHITE, p);
        }
        King k1 = new King(0,4,Piece.BLACK);
        King k2 = new King(7,4,Piece.WHITE);
        setPiece(0,4,Piece.BLACK, k1);
        setPiece(7,4,Piece.WHITE, k2);

        Knight n1 = new Knight(0,1, Piece.BLACK);
        Knight n2 = new Knight(0,6, Piece.BLACK);
        Knight n3 = new Knight(7,1, Piece.WHITE);
        Knight n4 = new Knight(7,6, Piece.WHITE);
        setPiece(0,1,Piece.BLACK, n1);
        setPiece(0,6,Piece.BLACK, n2);
        setPiece(7,1,Piece.WHITE, n3);
        setPiece(7,6,Piece.WHITE, n4);

        Rook r1 = new Rook(0,7, Piece.BLACK);
        Rook r2 = new Rook(0,0, Piece.BLACK);
        Rook r3 = new Rook(7,7, Piece.WHITE);
        Rook r4 = new Rook(7,0, Piece.WHITE);
        setPiece(0,7,Piece.BLACK, r1);
        setPiece(0,0,Piece.BLACK, r2);
        setPiece(7,7,Piece.WHITE, r3);
        setPiece(7,0,Piece.WHITE, r4);

        Bishop b1 = new Bishop(0,2,Piece.BLACK);
        Bishop b2 = new Bishop(0,5,Piece.BLACK);
        Bishop b3 = new Bishop(7,2,Piece.WHITE);
        Bishop b4 = new Bishop(7,5,Piece.WHITE);
        setPiece(0,2,Piece.BLACK, b1);
        setPiece(0,5,Piece.BLACK, b2);
        setPiece(7,2,Piece.WHITE, b3);
        setPiece(7,5,Piece.WHITE, b4);

        Queen q1 = new Queen(0, 3, Piece.BLACK);
        Queen q2 = new Queen(7, 3, Piece.WHITE);
        setPiece(0,3,Piece.BLACK, q1);
        setPiece(7,3,Piece.WHITE, q2);
    }
}