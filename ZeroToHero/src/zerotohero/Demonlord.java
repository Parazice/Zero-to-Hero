package zerotohero;

/**
 *
 * @author Parazice
 */
public class Demonlord {
    int hp, maxHP, minAtk, maxAtk, cmd;
    boolean isCharge;
    private Hero hero;
    Skills skill = new Skills();
    public Demonlord() {
        this.maxHP = 5000;
        this.hp = maxHP;
        minAtk = 25;
        maxAtk = 100;
        isCharge = false;
    }
    public Demonlord(int maxHP, int minAtk, int maxAtk) {
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        isCharge = false;
    }
    public void randomAction() {
        int min = 1;
        int max = 3;
        int range = (max-min)+1;
        int cmd;
        if (isCharge == false) {
            cmd = (int)(Math.random()*range) + min;
        }
        else {
            cmd = (int)(Math.random()*(range-1)) + (min+1);
        }
        switch(cmd) {
            case 1:
                skill.charge(this);
                break;
            case 2:
                BattleScreen.hero.hp -= (int)(skill.attack(this)-BattleScreen.hero.dmgRed);
                hp -= (int)(BattleScreen.hero.thorns*(skill.attack(this)*BattleScreen.hero.dmgRed));
                break;
            case 3:
                BattleScreen.hero.hp -= (int)(skill.manaDrain(this, BattleScreen.hero)-BattleScreen.hero.dmgRed);
                hp -= (int)(BattleScreen.hero.thorns*(skill.attack(this)*BattleScreen.hero.dmgRed));
                break;
            default :
                break;
        }
    }
    
}
