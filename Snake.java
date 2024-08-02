import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.event.WindowListener;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;


public class Snake extends Frame implements WindowListener, KeyListener {
    
    // Starting point
    public static void main(String[] args) {

        int[] dimensions = getScreenDimensions();
        int[] windowSize = {dimensions[0]/2, dimensions[1]/2};
        int[] offsetPosition = {windowSize[0] - (windowSize[0] /2),
                                windowSize[1] - (windowSize[1] / 2)};

        int[] boardSize = {windowSize[0] /2, windowSize[0] /2};
        int[] entitySize = {boardSize[0] / 12, boardSize[1] / 12};

        Snake frame = new Snake("Snek: the game", windowSize, offsetPosition);
        
        frame.requestFocus();
        

        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                g.drawRect(0,0, boardSize[0], boardSize[1]);
                g.fillRect(entitySize[0], entitySize[1], entitySize[0], entitySize[1]);
                setLocation(windowSize[0] /4 ,windowSize[1] / 8);
        }};

        frame.add(canvas);
        canvas.repaint();
        frame.setVisible(true);
        frame.validate();

    }

    // Actual game bit

    public Snake(String FrameTitle, int[] windowSize, int[] offsetPosition){
        //Sample 02: Set Layout and Title
        super(FrameTitle);
        setLayout(new BorderLayout());
        
        

        setSize(windowSize[0], windowSize[1] + (windowSize[1] / 8));
        setLocation(offsetPosition[0], offsetPosition[1]);

        Panel panel = new Panel(new FlowLayout());
        Button button = new Button("New Game");

        panel.add(button);

        add(panel, BorderLayout.SOUTH);
        
        addWindowListener(this);
        addKeyListener(this);
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
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    public static int[] getScreenDimensions() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int[] dimensions = new int[2];
        dimensions[0] = (int)size.getWidth();
        dimensions[1] = (int)size.getHeight();
        return dimensions;
    }

    public static void startGame() {
        while(true) {


        }
    }
}

//

// Geeksforgeeks (2024) Java AWT Tutorial. Available at: https://www.geeksforgeeks.org/java-awt-tutorial/ (Accessed: 29th July 2024).
// Dhamodaran, Sivaraman. (2023) Java Examples: Awt Frame Window. Available at: https://owlcation.com/stem/Java-Examples-Awt-Frame-Window (Accessed: 29th July 2024).
// https://www.geeksforgeeks.org/java-awt-button/
// Geeksforgeeks (2020) Java Program to Print Screen Resolution. Available at: https://www.geeksforgeeks.org/java-program-to-print-screen-resolution/ (Accessed: 2nd August 2024).
// Geeksforgeeks (2024) Break Statement in Java. Available at: https://www.geeksforgeeks.org/break-statement-in-java/ (Accessed: 2nd August 2024).
