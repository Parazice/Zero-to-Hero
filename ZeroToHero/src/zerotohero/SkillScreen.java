package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */

public class SkillScreen extends JPanel {
    private ImageComponent bg = new ImageComponent("Menu BG.png",1280, 720, 0, 0);
    private ImageComponent trainPanelBG = new ImageComponent("Training Panel.png",735,520,425,65);
    Hero hero = new Hero(TrainingScreen.hero);
    SkillScreen(Game game) {
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

        //Create skill menu panel.
        JPanel skillsPanel = new JPanel();
        skillsPanel.setOpaque(false);
        skillsPanel.setPreferredSize(new Dimension(250,600));
        skillsPanel.setLayout(new GridLayout(1,4));
        
        //Create fonts.
        Font headFont = new Font("Skia",Font.PLAIN,36);
        Font listFont = new Font("Skia",Font.PLAIN,24);
        
        //Create str skills panel.
        JPanel strSkills = new JPanel();
        BoxLayout strBox = new BoxLayout(strSkills,BoxLayout.Y_AXIS);
        strSkills.setLayout(strBox);
        strSkills.setOpaque(false);
        JLabel strLabel = new JLabel("Strength");
        strLabel.setFont(headFont);
        strLabel.setForeground(Color.white);
        JLabel atkBoost1 = new JLabel("<html> Req : Str 100 <br> Attack Boost I </html>");
        atkBoost1.setFont(listFont);
        atkBoost1.setForeground(Color.gray);
        JLabel guardBreak = new JLabel("<html> Req : Str 250 <br> Guard Break </html>");
        guardBreak.setFont(listFont);
        guardBreak.setForeground(Color.gray);
        JLabel atkBoost2 = new JLabel("<html> Req : Str 400 <br> Attack Boost II </html>");
        atkBoost2.setFont(listFont);
        atkBoost2.setForeground(Color.gray);
        JLabel fatalBlow = new JLabel("<html> Req : Str 600 <br> Fatal Blow </html>");
        fatalBlow.setFont(listFont);
        fatalBlow.setForeground(Color.gray);
        JButton back = new JButton("Back");
        back.setFont(headFont);
        back.addActionListener(e -> game.skillsToTraining());
        strSkills.add(strLabel);
        JLabel combat = new JLabel("Combat Stats");
        combat.setFont(listFont);
        combat.setForeground(Color.white);
        JLabel atk = new JLabel(String.format("Attack : %d",hero.atk));
        atk.setFont(listFont);
        atk.setForeground(Color.white);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(atkBoost1);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(guardBreak);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(atkBoost2);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(fatalBlow);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(combat);
        strSkills.add(Box.createVerticalStrut(15));
        strSkills.add(atk);
        strSkills.add(Box.createVerticalStrut(30));
        strSkills.add(back);
        skillsPanel.add(strSkills);
        
        //Create en skills panel.
        JPanel enSkills = new JPanel();
        BoxLayout enBox = new BoxLayout(enSkills,BoxLayout.Y_AXIS);
        enSkills.setLayout(enBox);
        enSkills.setOpaque(false);
        JLabel enLabel = new JLabel("Endur.");
        enLabel.setFont(headFont);
        enLabel.setForeground(Color.white);
        JLabel regen = new JLabel("<html> Req : En 100 <br> Regeneration </html>");
        regen.setFont(listFont);
        regen.setForeground(Color.gray);
        JLabel preservation = new JLabel("<html> Req : En 250 <br> Preservation </html>");
        preservation.setFont(listFont);
        preservation.setForeground(Color.gray);
        JLabel thorn = new JLabel("<html> Req : En 400 <br> Thorns </html>");
        thorn.setFont(listFont);
        thorn.setForeground(Color.gray);
        JLabel bloodBath = new JLabel("<html> Req : En 600 <br> Blood Bath </html>");
        bloodBath.setFont(listFont);
        bloodBath.setForeground(Color.gray);
        JLabel hp = new JLabel(String.format("HP : %d", hero.maxHP));
        hp.setFont(listFont);
        hp.setForeground(Color.white);
        enSkills.add(enLabel);
        enSkills.add(Box.createVerticalStrut(15));
        enSkills.add(regen);
        enSkills.add(Box.createVerticalStrut(15));
        enSkills.add(preservation);
        enSkills.add(Box.createVerticalStrut(15));
        enSkills.add(thorn);
        enSkills.add(Box.createVerticalStrut(15));
        enSkills.add(bloodBath);
        enSkills.add(Box.createVerticalStrut(55));
        enSkills.add(hp);
        skillsPanel.add(enSkills);
        
        //Create agi skills panel.
        JPanel agiSkills = new JPanel();
        BoxLayout agiBox = new BoxLayout(agiSkills,BoxLayout.Y_AXIS);
        agiSkills.setLayout(agiBox);
        agiSkills.setOpaque(false);
        JLabel agiLabel = new JLabel("Agility");
        agiLabel.setFont(headFont);
        agiLabel.setForeground(Color.white);
        JLabel cdBoost = new JLabel("<html> Req : Agi 100 <br> CD Boost </html>");
        cdBoost.setFont(listFont);
        cdBoost.setForeground(Color.gray);
        JLabel sharpEdge = new JLabel("<html> Req : Agi 250 <br> Sharp Edge </html>");
        sharpEdge.setFont(listFont);
        sharpEdge.setForeground(Color.gray);
        JLabel crossDagger = new JLabel("<html> Req : Agi 400 <br> Cross Daggers </html>");
        crossDagger.setFont(listFont);
        crossDagger.setForeground(Color.gray);
        JLabel assassinate = new JLabel("<html> Req : Agi 600 <br> Assassinate </html>");
        assassinate.setFont(listFont);
        assassinate.setForeground(Color.gray);
        JLabel cr = new JLabel(String.format("CR : %.2f%%", hero.critR));
        cr.setFont(listFont);
        cr.setForeground(Color.white);
        JLabel cd = new JLabel(String.format("CD : x%.2f", hero.critD));
        cd.setFont(listFont);
        cd.setForeground(Color.white);
        agiSkills.add(agiLabel);
        agiSkills.add(Box.createVerticalStrut(15));
        agiSkills.add(cdBoost);
        agiSkills.add(Box.createVerticalStrut(15));
        agiSkills.add(sharpEdge);
        agiSkills.add(Box.createVerticalStrut(15));
        agiSkills.add(crossDagger);
        agiSkills.add(Box.createVerticalStrut(15));
        agiSkills.add(assassinate);
        agiSkills.add(Box.createVerticalStrut(55));
        agiSkills.add(cr);
        agiSkills.add(cd);
        skillsPanel.add(agiSkills);
        
        //Create magic skills panel.
        JPanel magicSkills = new JPanel();
        BoxLayout magicBox = new BoxLayout(magicSkills,BoxLayout.Y_AXIS);
        magicSkills.setLayout(magicBox);
        magicSkills.setOpaque(false);
        JLabel magicLabel = new JLabel("Magic");
        magicLabel.setFont(headFont);
        magicLabel.setForeground(Color.white);
        JLabel fireBall = new JLabel("<html> Req : Ma 100 <br> Fire Ball </html>");
        fireBall.setFont(listFont);
        fireBall.setForeground(Color.gray);
        JLabel hex = new JLabel("<html> Req : Ma 250 <br> Hex </html>");
        hex.setFont(listFont);
        hex.setForeground(Color.gray);
        JLabel manaShield = new JLabel("<html> Req : Ma 400 <br> Mana Shield </html>");
        manaShield.setFont(listFont);
        manaShield.setForeground(Color.gray);
        JLabel manaBurst = new JLabel("<html> Req : Ma 600 <br> Mana Burst </html>");
        manaBurst.setFont(listFont);
        manaBurst.setForeground(Color.gray);
        JLabel mana = new JLabel(String.format("Mana : %d", hero.maxMana));
        mana.setFont(listFont);
        mana.setForeground(Color.white);
        magicSkills.add(magicLabel);
        magicSkills.add(Box.createVerticalStrut(15));
        magicSkills.add(fireBall);
        magicSkills.add(Box.createVerticalStrut(15));
        magicSkills.add(hex);
        magicSkills.add(Box.createVerticalStrut(15));
        magicSkills.add(manaShield);
        magicSkills.add(Box.createVerticalStrut(15));
        magicSkills.add(manaBurst);
        magicSkills.add(Box.createVerticalStrut(55));
        magicSkills.add(mana);
        skillsPanel.add(magicSkills);
        
        //set enable skills
        //str
        if (hero.str >= 600) {
            atkBoost1.setForeground(Color.white);
            guardBreak.setForeground(Color.white);
            atkBoost2.setForeground(Color.white);
            fatalBlow.setForeground(Color.white);
        }
        else if (hero.str >= 400) {
            atkBoost1.setForeground(Color.white);
            guardBreak.setForeground(Color.white);
            atkBoost2.setForeground(Color.white);
        }
        else if (hero.str >= 250) {
            atkBoost1.setForeground(Color.white);
            guardBreak.setForeground(Color.white);
        }
        else if (hero.str >= 100) {
            atkBoost1.setForeground(Color.white);
        }
        
        //en
        if (hero.en >= 600) {
            regen.setForeground(Color.white);
            preservation.setForeground(Color.white);
            thorn.setForeground(Color.white);
            bloodBath.setForeground(Color.white);
        }
        else if (hero.en >= 400) {
            regen.setForeground(Color.white);
            preservation.setForeground(Color.white);
            thorn.setForeground(Color.white);
        }
        else if (hero.en >= 250) {
            regen.setForeground(Color.white);
            preservation.setForeground(Color.white);
        }
        else if (hero.en >= 100) {
            regen.setForeground(Color.white);
        }
        
        //agi
        if (hero.agi >= 600) {
            cdBoost.setForeground(Color.white);
            sharpEdge.setForeground(Color.white);
            crossDagger.setForeground(Color.white);
            assassinate.setForeground(Color.white);
        }
        else if (hero.agi >= 400) {
            cdBoost.setForeground(Color.white);
            sharpEdge.setForeground(Color.white);
            crossDagger.setForeground(Color.white);
        }
        else if (hero.agi >= 250) {
            cdBoost.setForeground(Color.white);
            sharpEdge.setForeground(Color.white);
        }
        else if (hero.agi >= 100) {
            cdBoost.setForeground(Color.white);
        }
        
        //magic
        if (hero.magic >= 600) {
            fireBall.setForeground(Color.white);
            hex.setForeground(Color.white);
            manaShield.setForeground(Color.white);
            manaBurst.setForeground(Color.white);
        }
        else if (hero.magic >= 400) {
            fireBall.setForeground(Color.white);
            hex.setForeground(Color.white);
            manaShield.setForeground(Color.white);
        }
        else if (hero.magic >= 250) {
            fireBall.setForeground(Color.white);
            hex.setForeground(Color.white);
        }
        else if (hero.magic >= 100) {
            fireBall.setForeground(Color.white);
        }
        
        mainPanel.add(skillsPanel);
        //for Windows.
        //mainPanel.add(Box.createHorizontalStrut(125));
        //for MacOS.
        mainPanel.add(Box.createHorizontalStrut(140));
        this.add(mainPanel);
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
}