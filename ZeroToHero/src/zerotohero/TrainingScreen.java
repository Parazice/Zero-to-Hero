package zerotohero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Parazice
 */

public class TrainingScreen extends JPanel{
    ImageComponent bg = new ImageComponent("mrbeast anime op.jpeg",1280, 720, 0, 0);
    ImageComponent trainPanelBG = new ImageComponent("Training Panel.png",735,520,425,65);
    public TrainingScreen(Game game) {
        //Set screen layout.
        BoxLayout screenBox = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(screenBox);
        this.setOpaque(false);
        this.add(Box.createVerticalStrut(90));

        //Create main panel.
        JPanel mainPanel = new JPanel();
        BoxLayout panelBox = new BoxLayout(mainPanel,BoxLayout.X_AXIS);
        mainPanel.setLayout(panelBox);
        mainPanel.setOpaque(false);

        //Create and adjust hero image.
        JPanel heroPanel = new JPanel();
        heroPanel.setOpaque(false);
        ImageComponent heroImg = new ImageComponent("Hero.png", 400, 500);
        heroPanel.setPreferredSize(new Dimension(0,600));
        heroPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        heroPanel.add(heroImg);
        mainPanel.add(heroPanel);

        //Create training menu panel.
        JPanel trainingPanel = new JPanel();
        trainingPanel.setOpaque(false);
        trainingPanel.setPreferredSize(new Dimension(250,600));
        trainingPanel.setLayout(new GridLayout(3,1));

        //Create up half panel and stats labels.
        JPanel statsText = new JPanel();
        statsText.setOpaque(false);
        statsText.setLayout(new GridLayout(3,2));
        JLabel strLabel = new JLabel("Strength : 10");
        JLabel enLabel= new JLabel("Endurance : 10");
        JLabel agiLabel = new JLabel("Agility : 10");
        JLabel maLabel = new JLabel("Magic : 10");
        strLabel.setFont(new Font("Skia",Font.PLAIN,36));
        enLabel.setFont(new Font("Skia",Font.PLAIN,36));
        agiLabel.setFont(new Font("Skia",Font.PLAIN,36));
        maLabel.setFont(new Font("Skia",Font.PLAIN,36));
        strLabel.setForeground(Color.white);
        enLabel.setForeground(Color.white);
        agiLabel.setForeground(Color.white);
        maLabel.setForeground(Color.white);
        statsText.add(strLabel);
        statsText.add(enLabel);
        statsText.add(agiLabel);
        statsText.add(maLabel);
        JLabel staminaText = new JLabel("Stamina : 100");
        staminaText.setFont(new Font("Skia",Font.PLAIN,36));
        staminaText.setForeground(Color.white);
        JLabel daysText = new JLabel("Days remaining : 15");
        daysText.setFont(new Font("Skia",Font.PLAIN,36));
        daysText.setForeground(Color.red);
        statsText.add(staminaText);
        statsText.add(daysText);
        trainingPanel.add(statsText);

        //Create down half panel & stamina bar.
        JPanel downHalfPanel = new JPanel();
        JProgressBar staminaBar = new JProgressBar(0,100);
        BoxLayout staminaBox = new BoxLayout(downHalfPanel,BoxLayout.Y_AXIS);
        Color staYellow = new Color(255, 203, 15);
        downHalfPanel.setOpaque(false);
        downHalfPanel.setLayout(staminaBox);
        staminaBar.setPreferredSize(new Dimension(200,10));
        staminaBar.setForeground(staYellow);
        staminaBar.setValue(100);
        downHalfPanel.add(staminaBar);
        trainingPanel.add(downHalfPanel);

        //Create button panel & buttons.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        buttonPanel.setOpaque(false);
        JButton strButton = new JButton("Strength");
        JButton enButton= new JButton("Endurance");
        JButton agiButton = new JButton("Agility");
        JButton maButton = new JButton("Magic");
        Color strRed = new Color(255, 74, 74);
        Color enYellow = new Color(255, 240, 74);
        Color agiGreen = new Color(137, 255, 74);
        Color maBlue = new Color(74, 189, 255);
        strButton.setFont(new Font("Skia",Font.PLAIN,36));
        enButton.setFont(new Font("Skia",Font.PLAIN,36));
        agiButton.setFont(new Font("Skia",Font.PLAIN,36));
        maButton.setFont(new Font("Skia",Font.PLAIN,36));
        strButton.setBackground(strRed);
        enButton.setBackground(enYellow);
        agiButton.setBackground(agiGreen);
        maButton.setBackground(maBlue);
        buttonPanel.add(strButton);
        buttonPanel.add(enButton);
        buttonPanel.add(agiButton);
        buttonPanel.add(maButton);
        downHalfPanel.add(Box.createVerticalStrut(50));
        downHalfPanel.add(buttonPanel); 
        downHalfPanel.add(Box.createVerticalStrut(35));
        
        //Create bottom buttons and panel.
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        JButton nextdayButton = new JButton("Next Day");
        nextdayButton.setFont(new Font("Skia",Font.PLAIN,36));
        JButton cancelButton = new JButton("  Cancel  ");
        cancelButton.setFont(new Font("Skia",Font.PLAIN,36));
        JButton skillsButton = new JButton("Skills");
        skillsButton.setFont(new Font("Skia",Font.PLAIN,36));
        bottomPanel.add(skillsButton);
        bottomPanel.add(Box.createHorizontalStrut(191));
        bottomPanel.add(cancelButton);
        bottomPanel.add(Box.createHorizontalStrut(0));
        bottomPanel.add(nextdayButton);
        trainingPanel.add(bottomPanel); 

        mainPanel.add(trainingPanel);
        mainPanel.add(Box.createHorizontalStrut(125));
        this.add(mainPanel);

        //Functiioning all buttons.
        Hero hero = new Hero();
        dayCounter days = new dayCounter();

        //str
        strButton.addActionListener(e -> { 
            hero.tempStr += 15;
            strLabel.setText(String.format("Strength : %.0f + %.0f", hero.str, hero.tempStr));
            hero.tempSta += 25;
            staminaText.setText(String.format("Stamina : %.0f - %.0f", hero.sta, hero.tempSta));
            staminaBar.setValue((int)(hero.sta - hero.tempSta));
            if (hero.sta - hero.tempSta < 25) {
                strButton.setEnabled(false);
                enButton.setEnabled(false);
                agiButton.setEnabled(false);
                maButton.setEnabled(false);
            }
        });
        enButton.addActionListener(e -> { //en
            hero.tempEn += 15;
            enLabel.setText(String.format("Endurance : %.0f + %.0f", hero.en, hero.tempEn));
            hero.tempSta += 25;
            staminaText.setText(String.format("Stamina : %.0f - %.0f", hero.sta, hero.tempSta));
            staminaBar.setValue((int)(hero.sta - hero.tempSta));
            if (hero.sta - hero.tempSta < 25) {
                strButton.setEnabled(false);
                enButton.setEnabled(false);
                agiButton.setEnabled(false);
                maButton.setEnabled(false);
            }
        });

        //agi
        agiButton.addActionListener(e -> { 
            hero.tempAgi += 15;
            agiLabel.setText(String.format("Agility : %.0f + %.0f", hero.en, hero.tempAgi));
            hero.tempSta += 25;
            staminaText.setText(String.format("Stamina : %.0f - %.0f", hero.sta, hero.tempSta));
            staminaBar.setValue((int)(hero.sta - hero.tempSta));
            if (hero.sta - hero.tempSta < 25) {
                strButton.setEnabled(false);
                enButton.setEnabled(false);
                agiButton.setEnabled(false);
                maButton.setEnabled(false);
            }
        });

        //magic
        maButton.addActionListener(e -> {
            hero.tempMagic += 15;
            maLabel.setText(String.format("Magic : %.0f + %.0f", hero.en, hero.tempMagic));
            hero.tempSta += 25;
            staminaText.setText(String.format("Stamina : %.0f - %.0f", hero.sta, hero.tempSta));
            staminaBar.setValue((int)(hero.sta - hero.tempSta));
            if (hero.sta - hero.tempSta < 25) {
                strButton.setEnabled(false);
                enButton.setEnabled(false);
                agiButton.setEnabled(false);
                maButton.setEnabled(false);
            }
        });

        //cancel
        cancelButton.addActionListener(e -> { 
            strLabel.setText(String.format("Strength : %.0f", hero.str));
            enLabel.setText(String.format("Endurance : %.0f", hero.en));
            agiLabel.setText(String.format("Agility : %.0f", hero.agi));
            maLabel.setText(String.format("Magic : %.0f", hero.magic));
            staminaText.setText(String.format("Stamina : %.0f", hero.sta));
            strButton.setEnabled(true);
            enButton.setEnabled(true);
            agiButton.setEnabled(true);
            maButton.setEnabled(true);
            staminaBar.setValue((int)hero.sta);
            hero.tempStr = 0;
            hero.tempEn = 0;
            hero.tempAgi = 0;
            hero.tempMagic = 0;
            hero.tempSta = 0;
        });

        //nextday
        nextdayButton.addActionListener(e -> { 
            hero.str += hero.tempStr;
            hero.en += hero.tempEn;
            hero.agi += hero.tempAgi;
            hero.magic += hero.tempMagic;
            hero.tempStr = 0;
            hero.tempEn = 0;
            hero.tempAgi = 0;
            hero.tempMagic = 0;
            hero.tempSta = 0;
            staminaBar.setValue((int)hero.sta);
            strLabel.setText(String.format("Strength : %.0f", hero.str));
            enLabel.setText(String.format("Endurance : %.0f", hero.en));
            agiLabel.setText(String.format("Agility : %.0f", hero.agi));
            maLabel.setText(String.format("Magic : %.0f", hero.magic));
            staminaText.setText(String.format("Stamina : %.0f", hero.sta));
            staminaBar.setValue((int)hero.sta);
            strButton.setEnabled(true);
            enButton.setEnabled(true);
            agiButton.setEnabled(true);
            maButton.setEnabled(true);
            days.days -= 1;
            if (days.days == 1) daysText.setText(String.format("Day remaining : %d",days.days));
            else if (days.days == 0) {
                strButton.setEnabled(false);
                enButton.setEnabled(false);
                agiButton.setEnabled(false);
                maButton.setEnabled(false);
                cancelButton.setEnabled(false);
                daysText.setText(String.format("Day remaining : %d",days.days));
                nextdayButton.setText("   Fight!  ");
            }
            else daysText.setText(String.format("Days remaining : %d",days.days));
        });

        //skills
        skillsButton.addActionListener(e -> game.switchToSkills());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //Delete bg.
        super.paintComponent(g);
        // Draw bg.
        bg.paintComponent(g);
        super.paintComponent(g);
        trainPanelBG.paintComponent(g);
    }

    class dayCounter {
        int days;
        dayCounter() {
            days = 15;
        }
    }
}