package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */

public class TrainingScreen extends JPanel{
    ImageComponent bg = new ImageComponent("mrbeast anime op.jpeg",1280, 720, 0, 0);
    public TrainingScreen(Game game) {
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("vtwi"));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //Delete bg.
        super.paintComponent(g);
        // Draw bg.
        bg.paintComponent(g);
    }
    
}

