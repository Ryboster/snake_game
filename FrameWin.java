import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameWin extends Frame implements WindowListener {

    public static void main(String[] args) {
        FrameWin frame = new FrameWin("My Frame");
        frame.setVisible(true);
    }

    //Sample 01: Constructor
    public FrameWin(String FrameTitle){
        //Sample 02: Set Layout and Title
        super(FrameTitle);
        setLayout(new FlowLayout());

        Label L1 = new Label("Label 1");
        Label L2 = new Label("Label 2");
        add(L1);
        add(L2);

        setSize(400, 300);
        setLocation(100,100);
    }



    @Override
    public void windowDeactivated(WindowEvent event) {
        
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
        
    }

    @Override
    public void windowOpened(WindowEvent event) {

    }

//    @Override
//    public void windowOpening(WindowEvent event) {
//        
//    }


}

// Dhamodaran, Sivaraman