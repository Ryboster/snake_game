package board;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Board {

    public Canvas getBoard(int[] BOARD_SIZE, int[] playerPosition, int[] BOARD_POSITION) {

        int[] CELL_SIZE = {BOARD_SIZE[0] / 12, BOARD_SIZE[1] / 12};
        
        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                g.drawRect(0,0, BOARD_SIZE[0], BOARD_SIZE[1]);
                g.fillRect(playerPosition[0] * CELL_SIZE[0], playerPosition[1] * CELL_SIZE[1], CELL_SIZE[0], CELL_SIZE[1]);
                setLocation(BOARD_POSITION[0], BOARD_POSITION[1]);
            }
        };
        return canvas;

    }
}