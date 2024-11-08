package zerotohero;

/**
 *
 * @author Parazice
 */

public class Hero {
   int hp, mana, atk, str, en, agi, magic, sta, tempStr, tempEn, tempAgi, tempMagic, tempSta, maxHP, maxMana, 
           hpRegen, manaRegen;
   double critR, critD, thorns, dmgRed, critBoost;
   Skills skill = new Skills();
   Hero() {
      this.str = 10;
      this.en = 10;
      this.agi = 10;
      this.magic = 10;
      this.sta = 100;
      this.tempStr = 0;
      this.tempEn = 0;
      this.tempAgi = 0;
      this.tempMagic = 0;
      this.tempSta = 0;
      this.maxHP = (int)(50 + (0.75 * (double)this.en));
      this.maxMana = (int)(50 + (0.75 * (double)this.magic));
      this.atk = (int)(10 + (0.25 * (double)this.str));
      this.critR = 5 + (0.15 * (double)this.agi);
      this.critD = 1.5 + (0.0025 * (double)this.agi);
      this.hp = maxHP;
      this.mana = maxMana;
      this.hpRegen = 0;
      this.manaRegen = (int)(0.05*(double)maxMana);
      this.dmgRed = 1;
      this.thorns = 0;
      this.critBoost = 0;
   }
   Hero(Hero hero) {
      this.str = hero.str;
      this.en = hero.en;
      this.agi = hero.agi;
      this.magic = hero.magic;
      this.sta = hero.sta;
      this.tempStr = hero.tempStr;
      this.tempEn = hero.tempEn;
      this.tempAgi = hero.tempAgi;
      this.tempMagic = hero.tempMagic;
      this.tempSta = hero.tempSta;
      this.maxHP = hero.maxHP;
      this.maxMana = hero.maxMana;
      this.atk = hero.atk;
      this.critR = hero.critR;
      this.critD = hero.critD;
      this.hp = maxHP;
      this.mana = maxMana;
      this.hpRegen = hero.hpRegen;
      this.manaRegen = hero.manaRegen;
      this.dmgRed = hero.dmgRed;
      this.thorns = hero.thorns;
      this.critBoost = hero.critBoost;
   }
   
   void hpScaling() {
       this.maxHP = (int)(50 + (0.75 * (double)this.en));
       hp = maxHP;
       if (en >= 400) {
           skill.thorns(this);
           skill.preserv(this);
           skill.regen(this);
       }
       else if (en >= 250) {
           skill.preserv(this);
           skill.regen(this);
       }
       else if (en >= 100) {
           skill.regen(this);
       }
   }
   void manaScaling() {
       this.maxMana = (int)(20 + (0.75 * (double)this.magic));
       mana = maxMana;
       manaRegen = (int)(0.05*(double)maxMana);
       if (magic >= 400) {
           skill.manaShield(this);
       }
   }
   void atkScaling() {
       this.atk = (int)(10 + (0.25 * (double)this.str));
       if (str >= 400) {
           atk += skill.atkBoostI(this) + skill.atkBoostII(this);
       }
       else if (str>= 100) atk += skill.atkBoostI(this);
   }
   void crScailing() {
       this.critR = 5 + (0.15 * (double)this.agi);
       if (this.critR > 100) this.critR = 100.0;
   }
   void cdScailing() {
       this.critD = (1.5 + (0.002 * (double)this.agi))+critBoost;
       if (agi >= 100) skill.cdBoost(this);
   }
}