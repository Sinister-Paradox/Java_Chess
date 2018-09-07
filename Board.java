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

    public Board(){
        setTitle(TITLE);
        GridLayout layout = new GridLayout(SIZE, SIZE);
        setLayout(layout);

        // Create 8x8 grid layout, populated with squares
        grid = new Square[SIZE][SIZE];
        for(int i = 0;i<SIZE;i++){
            for(int j = 0;j<SIZE;j++) {
                Square temp = new Square(i, j);
                //temp.setBackground(Color.WHITE);
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Square source =(Square) e.getSource();
                        if(!pieceSelected && source.hasPiece()){
                            source.setBackground(Color.PINK);
                            pieceSelected = true;
                            selected = source;
                        }
                        else if(pieceSelected){
                            boolean movable = selected.getPiece().move(source.getRow(), source.getCol());
                            if(movable){
                                grid[source.getRow()][source.getCol()].setPiece(selected.getPiece());
                                //selected.deletePiece();
                                selected.setBackground(Color.WHITE);
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

    void play(){

    }

    void init(){
        Pawn p1 = new Pawn(1, 0, Piece.BLACK);
        grid[1][0].setPiece(p1);
        System.out.println(grid[1][0].getPiece().key);
    }



}
