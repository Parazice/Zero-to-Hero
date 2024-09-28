package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */

public class MainMenu extends JPanel {
    ImageComponent bg = new ImageComponent("mrbeast anime op.jpeg",1280, 720, 0, 0);
    public MainMenu(Game game) {
        //Make logo & Adjust MainMenu Panel.
        this.setLayout(new GridLayout(2,1));
        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(373, 1, 534, 400);
        ImageComponent logo = new ImageComponent("Logo.png", 534, 400, 0, 0);
        logoPanel.add(logo);
        logoPanel.setOpaque(false);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Make small JPanel to contain buttons.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(373, 400, 300, 200);
        buttonPanel.setOpaque(false);
        BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(box);
        buttonPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        buttonPanel.setPreferredSize(new Dimension(1280,200));
        
        //Make buttons
        JButton start = new JButton("   Start   ");
        start.addActionListener(e -> game.switchToTraining());
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setPreferredSize(new Dimension(1280,100));
        start.setFont(new Font("Skia",Font.PLAIN,48));  
        JButton exit = new JButton("    Exit    ");
        exit.setFont(new Font("Skia",Font.PLAIN,48));
        exit.addActionListener(e -> System.exit(0));
        exit.setPreferredSize(new Dimension(1280,100));
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Add components into panels.
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(start);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(exit);
        buttonPanel.add(Box.createVerticalGlue());
        this.add(logoPanel);
        this.add(buttonPanel);
    }
    
    //Method to draw bg.
    @Override
    protected void paintComponent(Graphics g) {
        //Delete bg.
        super.paintComponent(g);
        // Draw bg.
        bg.paintComponent(g);
    }
}