package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author paftipon
 */
public class GameOver extends JPanel{
    private ImageComponent bg = new ImageComponent("Boss BG.png",1280, 720, 0, 0);
    private JPanel mainPanel;
    private JLabel gameOver;
    private JButton retry;
    private JButton mainMenu;
    private Font headFont = new Font("Skia",Font.PLAIN,48);
    
    public GameOver(Game game) {
        //Create logo & Adjust MainMenu Panel.
        this.setLayout(new GridLayout(3,1));
        JPanel textPanel = new JPanel();
        textPanel.setBounds(373, 1, 534, 400);
        gameOver = new JLabel("Game Over");
        gameOver.setFont(new Font("Skia",Font.BOLD,72));
        gameOver.setForeground(Color.red);
        textPanel.add(gameOver);
        textPanel.setOpaque(false);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        //create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(373, 400, 300, 200);
        buttonPanel.setOpaque(false);
        BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(box);
        buttonPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        buttonPanel.setPreferredSize(new Dimension(1280,200));
        
        //Create buttons
        retry = new JButton("     Retry     ");
        retry.setAlignmentX(Component.CENTER_ALIGNMENT);
        retry.setPreferredSize(new Dimension(1280,100));
        retry.setFont(headFont);  
        mainMenu = new JButton("Main Menu");
        mainMenu.setFont(headFont);
        mainMenu.setPreferredSize(new Dimension(1280,100));
        mainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(retry);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(mainMenu);
        buttonPanel.add(Box.createVerticalGlue());
        
        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        
        this.add(mainPanel);
        this.add(textPanel);
        this.add(buttonPanel);
        
        retry.addActionListener(e-> {
           game.retry(); 
        });
        mainMenu.addActionListener(e-> {
           game.overToMenu();
        });
        
    }
    
    protected void paintComponent(Graphics g) {
        //Delete bg.
        super.paintComponent(g);
        // Draw bg.
        bg.paintComponent(g);
    }
}
