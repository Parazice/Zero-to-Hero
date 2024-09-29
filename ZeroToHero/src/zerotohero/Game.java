package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */

public class Game {
    JFrame frame;
    MainMenu mainMenu;
    TrainingScreen trainingScreen;
    CombatScreen combatScreen;
    SkillScreen skillScreen;
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
    public void switchToCombat() {
        combatScreen = new CombatScreen(this);
        frame.remove(trainingScreen);
        frame.add(combatScreen);
        frame.revalidate();
        frame.repaint();
    }
    public void switchToSkills() {
        skillScreen = new SkillScreen(this);
        frame.remove(trainingScreen);
        frame.add(skillScreen);
        frame.revalidate();
        frame.repaint();
    }
    public void skillsToTraining() {
        trainingScreen = new TrainingScreen(this);
        frame.remove(skillScreen);
        frame.add(trainingScreen);
        frame.revalidate();
        frame.repaint();
    }
}