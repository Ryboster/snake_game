import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import board.Board;

public class Snake extends Frame implements WindowListener, KeyListener {

    // Get Constants

    int[] SCREEN_DIMENSIONS = getScreenDimensions();
    int[] WINDOW_SIZE = {SCREEN_DIMENSIONS[0] /2 , SCREEN_DIMENSIONS[1] /2};

    int[] WINDOW_POSITION = {SCREEN_DIMENSIONS[0] /2 - (WINDOW_SIZE[0] /2),  // Center window within screen
                           SCREEN_DIMENSIONS[1] /2 - (WINDOW_SIZE[0] / 3)};

    int[] BOARD_SIZE = {WINDOW_SIZE[0] /4, WINDOW_SIZE[0] /4};
    int[] BOARD_POSITION = {(WINDOW_SIZE[0] / 2) - BOARD_SIZE[0] /2,        // Center board within window
                                   BOARD_SIZE[1] - BOARD_SIZE[1] / 10};

    int[] MAP_SIZE_IN_CELLS = {12, 12};
    int[] CELL_SIZE = {BOARD_SIZE[0] / MAP_SIZE_IN_CELLS[0], 
                        BOARD_SIZE[1] / MAP_SIZE_IN_CELLS[1]}; // The classic game of snake had a board of size of 12x12 cells


    int[] playerDirection = {0,0};
    int[] playerPosition = {6,6};
    int score = 0;

    public static void main(String[] args) {
        // Entrypoint
        
        Snake window = new Snake("Snek: The game");
        Board board = new Board();

        Canvas gameBoard = board.getBoard(window.BOARD_SIZE, window.playerPosition, window.BOARD_POSITION);

        window.add(gameBoard);

        

        window.setVisible(true);
        window.validate();
        window.requestFocus();
        
        boolean status = window.getGameStatus();

        while (status != true) {
            //window.playGame();
            status = window.getGameStatus();
            
            gameBoard.repaint();
            window.updatePlayerPosition();
            
            try {
                Thread.sleep(500);
            } catch(Exception e) {
                System.out.println(e);
            }
        }


    }

    // Class constructor
    public Snake (String FrameTitle) {
        
        
        //Sample 02: Set Layout and Title
        super(FrameTitle);
        
        
        SCREEN_DIMENSIONS = getScreenDimensions();
        setLayout(new BorderLayout());

        setSize(WINDOW_SIZE[0], WINDOW_SIZE[1] + (WINDOW_SIZE[1] / 8));
        setLocation(WINDOW_POSITION[0], WINDOW_POSITION[1]);

        Panel panel = new Panel(new FlowLayout());
        Button button = new Button("New Game");

        panel.add(button);

        add(panel, BorderLayout.SOUTH);
        
        addKeyListener(this);
        addWindowListener(this);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }   
        });

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                playerDirection[0] = -1;
                playerDirection[1] = 0;
                break;
            case KeyEvent.VK_RIGHT:
                playerDirection[0] = 1;
                playerDirection[1] = 0;                
                break;
            case KeyEvent.VK_UP:
                playerDirection[0] = 0;
                playerDirection[1] = -1;                
                break;
            case KeyEvent.VK_DOWN:
                playerDirection[0] = 0;
                playerDirection[1] = 1;                
                break;   
        }
    }

    public void updatePlayerPosition() {
        if (playerDirection[0] != 0) {
            playerPosition[0] += playerDirection[0];
            handleMapEdge(playerPosition[0] + playerDirection[0], 0);

        } else {
            playerPosition[1] += playerDirection[1];
            handleMapEdge(playerPosition[1] + playerDirection[1], 1);

        }
    }
    public void handleMapEdge(int sum, int index) {
        if (sum > MAP_SIZE_IN_CELLS[index]) {
            playerPosition[index] = 0;
        } else if (sum < 0) {
            playerPosition[index] = MAP_SIZE_IN_CELLS[index];
        }

    }

    @Override
    public void windowDeactivated(WindowEvent event) {
        //this.dispose();
    }

    @Override
    public void windowActivated(WindowEvent event) {

    }

    @Override
    public void windowDeiconified(WindowEvent event) {

    }

    @Override
    public void windowIconified(WindowEvent event) {

    }

    @Override
    public void windowClosed(WindowEvent event) {

    }

    @Override
    public void windowClosing(WindowEvent event) {
        System.out.println("Window closing");
        dispose();
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent event) {

    }

    

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    public int[] getScreenDimensions() {
        GraphicsConfiguration graphicsConfig = getGraphicsConfiguration();
        Rectangle bounds = graphicsConfig.getBounds();

        
        //Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int[] dimensions = new int[2];
        dimensions[0] = (int)bounds.width;
        dimensions[1] = (int)bounds.height;
        return dimensions;
    }
    
    public boolean getGameStatus() {
        if (score < 10) {
            return false;
        } else {
            return true;
        }
    }

}