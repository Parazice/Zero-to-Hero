package zerotohero;

/**
 *
 * @author Parazice
 */

public class Skills {
    private double damage;
    //str skills
    public int atkBoostI(Hero hero) {
        double boost = 0.15 * hero.atk;
        return (int)boost;
    }
    public int guardBreak(Hero hero) {
        damage = hero.atk + (0.2 * hero.str);
        return (int)damage;
    }
    public int atkBoostII(Hero hero) {
        double boost = 0.3 * hero.atk;
        return (int)boost;
    }
    public int fatalBlow(Hero hero) {
        damage = hero.atk + (0.6 * hero.str);
        return (int)damage;
    }
    
    //en skills.
    public void regen(Hero hero) {
        hero.hpRegen = (int)(0.1 * hero.maxHP);
    }
    public void preserv(Hero hero) {
        if (hero.magic >= 400) {
            hero.dmgRed = 0.7;
        }
        else hero.dmgRed = 0.85;
    }
    public void thorns(Hero hero) {
        hero.thorns = 0.8;
    }
    public int bloodBath(Hero hero) {
        damage = (0.25 * hero.hp);
        hero.hp -= (int)(0.6*damage);
        hero.hp += (int)(0.4*damage);
        return (int)damage;
    }
    
    //agi skills.
    public void cdBoost(Hero hero) {
        hero.critBoost = 0.3;
    }
    public int sharpEdge(Hero hero) {
        damage = hero.critD*(hero.atk + (0.2 * hero.agi));
        return (int)damage;
    }
    public int crossDagger(Hero hero) {
        damage = 2*((0.15 * hero.agi) * hero.critD);
        return (int)damage;
    }
    public int assassinate(Hero hero) {
        damage = hero.critD*(hero.atk + (0.4 * hero.agi));
        return (int)damage;
    }
    
    //magic skills.
    public int fireBall(Hero hero) {
        damage = (0.35 * hero.magic);
        hero.mana -= (int)(0.1*hero.maxMana);
        return (int)damage;
    }
    public int hex(Hero hero, Demonlord demon) {
        damage = (0.2*hero.magic) + (0.15*(demon.maxHP-demon.hp));
        hero.mana -= (int)(0.1*hero.maxMana);
        return (int)damage;
    }
    public void manaShield(Hero hero) {
        if (hero.str >= 400) {
            hero.dmgRed = 0.7;
        }
        else hero.dmgRed = 0.85;
    }
    public int manaBurst(Hero hero) {
        damage = (0.3 * hero.maxMana) + (0.8 * hero.magic);
        hero.mana -= (int)(0.2*hero.maxMana);
        return (int)damage;
    }
    
    //demonlord's skills
    public void charge(Demonlord demon) {
        demon.isCharge = true;
    }
    public int attack(Demonlord demon) {
        damage = Math.random()*((demon.maxAtk-demon.minAtk)+1)+demon.minAtk;
        if (demon.isCharge == true) {
            damage = (int)damage*2.5;
            demon.isCharge = false;
        }
        return (int)damage;
    }
    public int manaDrain(Demonlord demon, Hero hero) {
        hero.mana = (int)((double)hero.mana - (0.1*(double)hero.mana));
        damage = Math.random()*((demon.maxAtk-demon.minAtk)+1)+demon.minAtk+(0.1*(double)hero.mana);
        return (int)damage;
    }
}
