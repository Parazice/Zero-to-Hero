package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */
public class BattleScreen extends JPanel {
    private ImageComponent bg = new ImageComponent("Boss BG.png",1280, 720, 0, 0);
    private ImageComponent actionPanelBG = new ImageComponent("Training Panel.png",930,520,175,450);
    static Hero hero = new Hero(TrainingScreen.hero);
    static Demonlord demon = new Demonlord();
    private JProgressBar heroHealthBar;
    private JProgressBar heroManaBar;
    private JProgressBar demonHealthBar;
    private Font listFont = new Font("Skia",Font.PLAIN,24);
    private ImageComponent heroImg;
    private ImageComponent fireball;
    private int fireballX, fireballY;
    private boolean isFireballVisible = false;
    private ImageComponent heximg;
    private int hexX, hexY;
    private boolean isHexVisible = false;
    private ImageComponent manaImg;
    private int manaX, manaY;
    private boolean isManaVisible = false;
    private int initial;
    private Timer countDown;
    
    private JButton attack;
    private JButton defend;
    private JButton guardBreak;
    private JButton fatalBlow;
    private JButton bloodBath;
    private JButton sharpEdge;
    private JButton crossDaggers;
    private JButton assassinate;
    private JButton fireBall;
    private JButton hex;
    private JButton manaBurst;
    
    public BattleScreen(Game game) {
        //Set screen layout.
        BoxLayout screenBox = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(screenBox);
        this.setOpaque(false);
        this.add(Box.createVerticalStrut(80));
        
        //Create timer
        initial = 300;
        JLabel countDownLabel = new JLabel(String.valueOf(initial));
        countDownLabel.setFont(listFont);
        countDownLabel.setForeground(Color.white);
        countDown = new Timer(1000, e-> {
            if (initial > 0) {
                    initial--;
                    countDownLabel.setText(String.valueOf(initial));
                } else {
                    countDown.stop();
                    game.toOver();
                }
        });
        this.add(countDownLabel);
        countDown.start();

        //Create character panel.
        JPanel charaPanel = new JPanel();
        BoxLayout panelBox = new BoxLayout(charaPanel,BoxLayout.X_AXIS);
        charaPanel.setLayout(panelBox);
        charaPanel.setOpaque(false);
        this.add(charaPanel);
        
        //Create and adjust hero image.
        JPanel heroPanel = new JPanel();
        heroPanel.setOpaque(false);
        heroImg = new ImageComponent("Hero.png", 200, 250);
        BoxLayout heroBox = new BoxLayout(heroPanel,BoxLayout.Y_AXIS);
        heroPanel.setPreferredSize(new Dimension(0,600));
        heroPanel.setLayout(heroBox);
        
        // Add hero health bar
        heroHealthBar = new JProgressBar(0, hero.maxHP);
        heroHealthBar.setValue(hero.maxHP);
        heroHealthBar.setStringPainted(true);
        heroHealthBar.setForeground(new Color(28, 209, 0));
        heroHealthBar.setBackground(Color.black);
        // Add hero mana bar
        heroManaBar = new JProgressBar(0, hero.maxMana);
        heroManaBar.setValue(hero.maxMana);
        heroManaBar.setStringPainted(true);
        heroManaBar.setForeground(new Color(74, 189, 255));
        heroManaBar.setBackground(Color.black);
        
        heroPanel.add(heroHealthBar);
        heroPanel.add(Box.createVerticalStrut(10));
        heroPanel.add(heroManaBar);
        heroPanel.add(Box.createVerticalStrut(60));
        heroPanel.add(heroImg);
        
        charaPanel.add(Box.createHorizontalGlue());
        charaPanel.add(heroPanel);
        
        //Create and adjust demonlord image
        JPanel demonPanel = new JPanel();
        demonPanel.setOpaque(false);
        ImageComponent demonImg = new ImageComponent("Demonlord.png", 280, 350);
        demonPanel.setPreferredSize(new Dimension(0,600));
        BoxLayout demonBox = new BoxLayout(demonPanel,BoxLayout.Y_AXIS);
        demonPanel.setLayout(demonBox);
        
        // Add demonlord health bar
        demonHealthBar = new JProgressBar(0, demon.maxHP);
        demonHealthBar.setValue(demon.maxHP);
        demonHealthBar.setStringPainted(true);
        demonHealthBar.setForeground(new Color(255, 74, 74));
        demonHealthBar.setBackground(Color.BLACK);
        demonPanel.add(demonHealthBar);
        
        demonPanel.add(demonImg);
        charaPanel.add(Box.createHorizontalGlue());
        charaPanel.add(demonPanel);
        charaPanel.add(Box.createHorizontalGlue());
        
        //create action panel
        JPanel actionPanel = new JPanel();
        BoxLayout actionBox = new BoxLayout(actionPanel,BoxLayout.X_AXIS);
        actionPanel.setOpaque(false);
        actionPanel.setLayout(actionBox);
        //normal action
        JPanel normalAction = new JPanel();
        BoxLayout normalActionBox = new BoxLayout(normalAction,BoxLayout.Y_AXIS);
        normalAction.setOpaque(false);
        normalAction.setLayout(normalActionBox);
        JLabel normal = new JLabel("Normal");
        normal.setFont(listFont);
        normal.setForeground(Color.WHITE);
        attack = new JButton(" Attack");
        attack.setFont(listFont);
        defend = new JButton("Defend");
        defend.setFont(listFont);
        normalAction.add(normal);
        normalAction.add(Box.createVerticalStrut(10));
        normalAction.add(attack);
        normalAction.add(Box.createVerticalStrut(5));
        normalAction.add(defend);
        normalAction.add(Box.createVerticalGlue());
        //str skills
        JPanel strPanel = new JPanel();
        BoxLayout strBox = new BoxLayout(strPanel,BoxLayout.Y_AXIS);
        strPanel.setOpaque(false);
        strPanel.setLayout(strBox);
        JLabel str = new JLabel("Strength");
        str.setFont(listFont);
        str.setForeground(new Color(255, 74, 74));
        guardBreak = new JButton("Guard Break");
        guardBreak.setFont(listFont);
        fatalBlow = new JButton("Fatal Blow");
        fatalBlow.setFont(listFont);
        strPanel.add(str);
        strPanel.add(Box.createVerticalStrut(10));
        strPanel.add(guardBreak);
        strPanel.add(Box.createVerticalStrut(5));
        strPanel.add(fatalBlow);
        strPanel.add(Box.createVerticalGlue());
        //en skills
        JPanel enPanel = new JPanel();
        BoxLayout enBox = new BoxLayout(enPanel,BoxLayout.Y_AXIS);
        enPanel.setOpaque(false);
        enPanel.setLayout(enBox);
        JLabel en = new JLabel("Endurance");
        en.setFont(listFont);
        en.setForeground(new Color(255, 240, 74));
        bloodBath = new JButton("Blood Bath");
        bloodBath.setFont(listFont);
        enPanel.add(en);
        enPanel.add(Box.createVerticalStrut(10));
        enPanel.add(bloodBath);
        enPanel.add(Box.createVerticalGlue());
        //agi skills
        JPanel agiPanel = new JPanel();
        BoxLayout agiBox = new BoxLayout(agiPanel,BoxLayout.Y_AXIS);
        agiPanel.setOpaque(false);
        agiPanel.setLayout(agiBox);
        JLabel agi = new JLabel("Agility");
        agi.setFont(listFont);
        agi.setForeground(new Color(137, 255, 74));
        sharpEdge = new JButton("Sharp Edge");
        sharpEdge.setFont(listFont);
        crossDaggers = new JButton("Cross Daggers");
        crossDaggers.setFont(listFont);
        assassinate = new JButton("Assassinate");
        assassinate.setFont(listFont);
        agiPanel.add(agi);
        agiPanel.add(Box.createVerticalStrut(10));
        agiPanel.add(sharpEdge);
        agiPanel.add(Box.createVerticalStrut(5));
        agiPanel.add(crossDaggers);
        agiPanel.add(Box.createVerticalStrut(5));
        agiPanel.add(assassinate);
        agiPanel.add(Box.createVerticalGlue());
        //magic skills
        JPanel magicPanel = new JPanel();
        BoxLayout magicBox = new BoxLayout(magicPanel,BoxLayout.Y_AXIS);
        magicPanel.setOpaque(false);
        magicPanel.setLayout(magicBox);
        JLabel magic = new JLabel("Magic");
        magic.setFont(listFont);
        magic.setForeground(new Color(74, 189, 255));
        fireBall = new JButton("Fire Ball");
        fireBall.setFont(listFont);
        hex = new JButton("Hex");
        hex.setFont(listFont);
        manaBurst = new JButton("Mana Burst");
        manaBurst.setFont(listFont);
        magicPanel.add(magic);
        magicPanel.add(Box.createVerticalStrut(10));
        magicPanel.add(fireBall);
        magicPanel.add(Box.createVerticalStrut(5));
        magicPanel.add(hex);
        magicPanel.add(Box.createVerticalStrut(5));
        magicPanel.add(manaBurst);
        
        //adjust layout and add all components
        actionPanel.add(Box.createHorizontalStrut(210));
        actionPanel.add(normalAction);
        actionPanel.add(strPanel);
        actionPanel.add(enPanel);
        actionPanel.add(Box.createHorizontalStrut(15));
        actionPanel.add(agiPanel);
        actionPanel.add(magicPanel);
        actionPanel.add(Box.createHorizontalStrut(200));
        this.add(actionPanel);
        
        //initial all button's status
        buttonDisable(this);
        buttonEnable(this);
        
        //functioning all button
        //normal actions
        attack.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            heroCrit();
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        defend.addActionListener(e -> {
            buttonDisable(this);
            double temp = hero.dmgRed;
            hero.dmgRed += 0.5;
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else {demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    hero.dmgRed = temp;
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        
        //str skills
        guardBreak.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.guardBreak(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        fatalBlow.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.fatalBlow(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        
        //en skills
        bloodBath.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.bloodBath(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        
        //agi skills
        sharpEdge.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.sharpEdge(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        crossDaggers.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.crossDagger(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        assassinate.addActionListener(e -> {
            buttonDisable(this);
            heroImg.moveUpDown();
            demon.hp -= hero.skill.assassinate(hero);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                else { demon.randomAction();
                    heroHealthBar.setValue(hero.hp);
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        
        //magic skills
        fireball = new ImageComponent("Fireball.png", 50, 50, heroPanel.getX() + 100, heroPanel.getY() + 100);
        fireball.setVisible(true);
        this.add(fireball);
        
        fireBall.addActionListener(e -> {
            buttonDisable(this);
            isFireballVisible = true;
            fireballX = heroPanel.getX() + 100;
            fireballY = heroPanel.getY() + 300;

            Timer fireballTimer = new Timer(30, evt -> {
                fireballX += 10;
                repaint();

                if (fireballX >= demonPanel.getX()) {
                    ((Timer) evt.getSource()).stop();
                    isFireballVisible = false;
                    demon.hp -= hero.skill.fireBall(hero);
                    demonHealthBar.setValue(demon.hp);
                    if (demon.hp <= 0) {
                            Timer delay = new Timer(500, fade -> {
                            game.toWin();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    demon.randomAction();
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    heroHealthBar.setValue(hero.hp);
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            fireballTimer.start();
        });
        heximg = new ImageComponent("Hex.png", 50, 50, demonPanel.getX() + 100, demonPanel.getY() + 100);
        heximg.setVisible(true);
        this.add(heximg);
        hex.addActionListener(e -> {
            buttonDisable(this);
            hexX = demonPanel.getX() + 80;
            hexY = demonPanel.getY() + 100;
            isHexVisible = true;
            repaint();
            demon.hp -= hero.skill.hex(hero, demon);
            Timer timer = new Timer(1000, evt -> {
                demonHealthBar.setValue(demon.hp);
                if (demon.hp <= 0) {
                            Timer delay = new Timer(500, fade -> {
                            game.toWin();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                demon.randomAction();
                if (!demon.isCharge) {
                    demonImg.moveUpDown();
                }
                heroHealthBar.setValue(hero.hp);
                if (hero.hp <= 0) {
                    Timer delay = new Timer(500, fade -> {
                        game.toOver();
                    });
                    delay.setRepeats(false);
                    delay.start();
                }
                heroRegen();
                isHexVisible = false;
                repaint();
                buttonEnable(this);
            });
            timer.setRepeats(false);
            timer.start(); 
        });
        manaImg = new ImageComponent("Mana Burst.png", 50, 50, heroPanel.getX() + 100, heroPanel.getY() + 100);
        manaImg.setVisible(true);
        this.add(manaImg);
        
        manaBurst.addActionListener(e -> {
            buttonDisable(this);
            isManaVisible = true;
            manaX = heroPanel.getX() + 100;
            manaY = heroPanel.getY() + 300;

            Timer manaTimer = new Timer(30, evt -> {
                manaX += 10;
                repaint();

                if (manaX >= demonPanel.getX()) {
                    ((Timer) evt.getSource()).stop();
                    isManaVisible = false;
                    demon.hp -= hero.skill.manaBurst(hero);
                    demonHealthBar.setValue(demon.hp);
                    if (demon.hp <= 0) {
                            Timer delay = new Timer(500, fade -> {
                            game.toWin();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    demon.randomAction();
                    if (!demon.isCharge) {
                        demonImg.moveUpDown();
                    }
                    heroHealthBar.setValue(hero.hp);
                    if (hero.hp <= 0) {
                        Timer delay = new Timer(500, fade -> {
                            game.toOver();
                        });
                        delay.setRepeats(false);
                        delay.start();
                    }
                    heroRegen();
                    buttonEnable(this);
                }
            });
            manaTimer.start();
        });
        
    }
    
    public void heroRegen() {
        hero.hp+=(int)hero.hpRegen;
        if (hero.hp > hero.maxHP) hero.hp = hero.maxHP;
        hero.mana+=(int)hero.manaRegen;
        if (hero.mana > hero.maxMana) hero.mana = hero.maxMana;
        heroHealthBar.setValue(hero.hp);
        heroManaBar.setValue(hero.mana);
    }
    
    public void heroCrit() {
        double max = 100;
        double min = 1;
        double range = (max-min)+1;
        double num = (Math.random()*(range-1)) + min;
        if (num <= hero.critR) {
            demon.hp -= (int)(hero.atk*hero.critD);
        }
        else demon.hp -= (int)hero.atk;
    }
    
    public void buttonDisable(BattleScreen screen) {
        screen.attack.setEnabled(false);
        screen.defend.setEnabled(false);
        screen.guardBreak.setEnabled(false);
        screen.fatalBlow.setEnabled(false);
        screen.bloodBath.setEnabled(false);
        screen.sharpEdge.setEnabled(false);
        screen.crossDaggers.setEnabled(false);
        screen.assassinate.setEnabled(false);
        screen.fireBall.setEnabled(false);
        screen.hex.setEnabled(false);
        screen.manaBurst.setEnabled(false);
    }
    public void buttonEnable(BattleScreen screen) {
        screen.attack.setEnabled(true);
        screen.defend.setEnabled(true);
        //str
        if (hero.str >= 600) {
            screen.guardBreak.setEnabled(true);
            screen.fatalBlow.setEnabled(true);
        }
        else if (hero.str >= 400) {
            screen.guardBreak.setEnabled(true);
        }
        else if (hero.str >= 250) {
            screen.guardBreak.setEnabled(true);
        }

        //en
        if (hero.en >= 600) {
            screen.bloodBath.setEnabled(true);
        }

        //agi
        if (hero.agi >= 600) {
            screen.sharpEdge.setEnabled(true);
            screen.crossDaggers.setEnabled(true);
            screen.assassinate.setEnabled(true);
        }
        else if (hero.agi >= 400) {
            screen.sharpEdge.setEnabled(true);
            screen.crossDaggers.setEnabled(true);
        }
        else if (hero.agi >= 250) {
            screen.sharpEdge.setEnabled(true);
        }

        //magic
        if (hero.magic >= 600) {
            screen.fireBall.setEnabled(true);
            screen.hex.setEnabled(true);
            screen.manaBurst.setEnabled(true);
        }
        else if (hero.magic >= 250) {
            screen.fireBall.setEnabled(true);
            screen.hex.setEnabled(true);
        }
        else if (hero.magic >= 100) {
            screen.fireBall.setEnabled(true);
        }
        
        //mana skills
        if (hero.mana < (int)(0.1*hero.maxMana)) {
            screen.fireBall.setEnabled(false);
            screen.hex.setEnabled(false);
            screen.manaBurst.setEnabled(false);
        }
        else if (hero.mana < (int)(0.2*hero.maxMana)) {
            screen.manaBurst.setEnabled(false);
        }
    }
    
    //Method to draw bg.
    @Override
    protected void paintComponent(Graphics g) {
        //Delete bg.
        super.paintComponent(g);
        // Draw bg.
        bg.paintComponent(g);
        super.paintComponent(g);
        actionPanelBG.paintComponent(g);
        
        if (isFireballVisible) {
            g.drawImage(fireball.getImage(), fireballX, fireballY, 100, 100, this);
        }
        if (isHexVisible) {
            g.drawImage(heximg.getImage(), hexX, hexY, 100, 100, this);
        }
        if (isManaVisible) {
            g.drawImage(manaImg.getImage(), manaX, manaY, 100, 100, this);
        }
    }
}