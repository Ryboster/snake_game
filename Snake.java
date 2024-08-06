import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Snake extends Frame implements WindowListener, KeyListener {

    // Get Constants

    int[] SCREEN_DIMENSIONS = getScreenDimensions();
    int[] WINDOW_SIZE = {SCREEN_DIMENSIONS[0] /2 , SCREEN_DIMENSIONS[1] /2};

    int[] WINDOW_POSITION = {SCREEN_DIMENSIONS[0] /2 - (WINDOW_SIZE[0] /2),  // Center window within screen
                           SCREEN_DIMENSIONS[1] /2 - (WINDOW_SIZE[0] / 3)};
    int[] BOARD_SIZE = {WINDOW_SIZE[0] /4, WINDOW_SIZE[0] /4};
    int[] BOARD_POSITION = {(WINDOW_SIZE[0] / 2) - BOARD_SIZE[0] /2,        // Center board within window
                                   BOARD_SIZE[1] - BOARD_SIZE[1] / 10};
    int[] CELL_SIZE = {BOARD_SIZE[0] / 12, BOARD_SIZE[1] / 12}; // The classic game of snake had a board of size of 12x12 cells

    int[] playerPosition = {6,6};

    public static void main(String[] args) {
        // Entrypoint
        
        Snake window = new Snake("Snek: The game");
        
        Canvas canvas = window.getCanvas();

        for (int i = 0; i != window.BOARD_POSITION.length; i ++) {
            System.out.println("SCREEN_DIMENSIONS: " + String.valueOf(window.SCREEN_DIMENSIONS[i]));
            System.out.println("WINDOW_POSITION:  " + String.valueOf(window.WINDOW_POSITION[i]));
        }

        
        window.add(canvas);
        canvas.repaint();
        window.setVisible(true);
        window.validate();
        window.requestFocus();
        
        boolean status = window.getGameStatus();

        while (status != true) {
            //window.playGame();
            status = window.getGameStatus();
            canvas.repaint();
            System.out.println(window.playerPosition[0]);

        }


    }

    public Canvas getCanvas(){
        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                g.drawRect(0,0, BOARD_SIZE[0], BOARD_SIZE[1]);
                g.fillRect(playerPosition[0] * CELL_SIZE[0], playerPosition[1] * CELL_SIZE[1], CELL_SIZE[0], CELL_SIZE[1]);
                setLocation(BOARD_POSITION[0], BOARD_POSITION[1]);

        }};
        return canvas;
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
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                playerPosition[0] --;
                break;
            case KeyEvent.VK_RIGHT:
                playerPosition[0] ++;
                break;
            case KeyEvent.VK_UP:
                playerPosition[1] --;
                break;
            case KeyEvent.VK_DOWN:
                playerPosition[1] ++;
                break;
            
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
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
        return false;
    }

    //public void playGame() {
    //    while(true) {
    //        
//
//
//
    //        try {
    //            Thread.sleep(1000);
    //        } catch(Exception e) {
    //            System.out.println(e);
    //        }
    //    }
    //}

}