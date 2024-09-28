package zerotohero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Parazice
 */

public class Game {
    JFrame frame;
    MainMenu mainMenu;
    TrainingScreen trainingScreen;
    public Game() {
        frame = new JFrame("Zero to Hero");
        mainMenu = new MainMenu(this);
        frame.setVisible(true);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(mainMenu);
    }
    public static void main(String[] args) {
        new Game();
    }
    public void switchToTraining() {
        trainingScreen = new TrainingScreen(this);
        frame.remove(mainMenu);
        frame.add(trainingScreen);
        frame.revalidate();
        frame.repaint();
    }
}
