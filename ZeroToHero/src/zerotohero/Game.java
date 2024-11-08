package zerotohero;
import javax.swing.*;
import javax.swing.UIManager;

/**
 *
 * @author Parazice
 */

public class Game {
    JFrame frame;
    private MainMenu mainMenu;
    private TrainingScreen trainingScreen;
    private SkillScreen skillScreen;
    private BattleScreen battleScreen;
    private GameOver gameOver;
    private Victory victory;
    private HardBattle hard;
    private HardVictory hardVictory;
    public Game() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
    public void switchToBattle() {
        battleScreen = new BattleScreen(this);
        frame.remove(trainingScreen);
        frame.add(battleScreen);
        frame.revalidate();
        frame.repaint();
    }
    public void toOver() {
        gameOver = new GameOver(this);
        frame.remove(battleScreen);
        frame.add(gameOver);
        frame.revalidate();
        frame.repaint();
    }
    public void retry() {
        battleScreen = new BattleScreen(this);
        frame.remove(gameOver);
        frame.add(battleScreen);
        frame.revalidate();
        frame.repaint();
    }
    public void overToMenu() {
        mainMenu = new MainMenu(this);
        frame.remove(gameOver);
        frame.add(mainMenu);
        frame.revalidate();
        frame.repaint();
    }
    public void toWin() {
        victory = new Victory(this);
        frame.remove(battleScreen);
        frame.add(victory);
        frame.revalidate();
        frame.repaint();
    }
    public void winToMenu() {
        mainMenu = new MainMenu(this);
        frame.remove(victory);
        frame.add(mainMenu);
        frame.revalidate();
        frame.repaint();
    }
    public void hardMode() {
        hard = new HardBattle(this);
        frame.remove(victory);
        frame.add(hard);
        frame.revalidate();
        frame.repaint();
    }
    public void hardToOver() {
        gameOver = new GameOver(this);
        frame.remove(hard);
        frame.add(gameOver);
        frame.revalidate();
        frame.repaint();
    }
    public void hardToWin() {
        hardVictory = new HardVictory(this);
        frame.remove(hard);
        frame.add(hardVictory);
        frame.revalidate();
        frame.repaint();
    }
    public void hardToMenu() {
        mainMenu = new MainMenu(this);
        frame.remove(hardVictory);
        frame.add(mainMenu);
        frame.revalidate();
        frame.repaint();
    }
}