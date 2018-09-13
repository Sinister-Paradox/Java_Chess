import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {

    private static final String TITLE = "Chess";
    private static final int SIZE = 8;
    Square[][] grid;

    private boolean pieceSelected = false;
    Square selected = null;

    int turn = Piece.WHITE;

    public Board(){
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
                        if(!pieceSelected && source.hasPiece() && source.getPiece().color == turn){
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
                            boolean movable = false;

                            // If square contains enemy piece
                            if (source.hasPiece() && source.getPiece().oppositeColor() == selected.getPiece().color){
                                movable = selected.getPiece().attack(source.getRow(), source.getCol());
                            }
                            else if(source.hasPiece() && source.getPiece().color == selected.getPiece().color){
                                movable = false;
                            }
                            else {
                                movable = selected.getPiece().move(source.getRow(), source.getCol());
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

    void init(){
        for(int i = 0;i<8;i++) {
            Pawn p = new Pawn(1, i, Piece.BLACK);
            grid[1][i].setPiece(p);
        }

        for(int i = 0;i<8;i++) {
            Pawn p = new Pawn(6, i, Piece.WHITE);
            grid[6][i].setPiece(p);
        }
        King k1 = new King(0,4,Piece.BLACK);
        King k2 = new King(7,4,Piece.WHITE);
        grid[0][4].setPiece(k1);
        grid[7][4].setPiece(k2);

        Knight n1 = new Knight(0,1, Piece.BLACK);
        Knight n2 = new Knight(0,6, Piece.BLACK);
        Knight n3 = new Knight(7,1, Piece.WHITE);
        Knight n4 = new Knight(7,6, Piece.WHITE);
        grid[0][1].setPiece(n1);
        grid[0][6].setPiece(n2);
        grid[7][1].setPiece(n3);
        grid[7][6].setPiece(n4);
    }
}