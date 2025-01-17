package view;


import model.ChessPiece;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent只绘制象棋
 */
public class ChessComponent extends JComponent {

    private boolean selected;

    private ChessPiece chessPiece;

    public ChessComponent(int size, ChessPiece chessPiece) {
        this.selected = false;
        setSize(size, size);
        setLocation(0,0);
        setVisible(true);
        this.chessPiece = chessPiece;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Helvetica", Font.PLAIN, getWidth() / 2);
        g2.setFont(font);
        g2.setColor(this.chessPiece.getColor());
        g2.drawString(this.chessPiece.getName() , getWidth() / 4, getHeight() * 5 / 8); // FIXME: Use library to find the correct offset.
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.gray);
            g.drawOval(0, 0, getWidth(), getHeight());
        }
    }
}
