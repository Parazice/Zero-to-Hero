package zerotohero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Parazice
 */

public class Hero {
   double hp, mana, str, en, agi, magic, sta, tempStr, tempEn, tempAgi, tempMagic, tempSta;
   Hero() {
      str = 10;
      en = 10;
      agi = 10;
      magic = 10;
      sta = 100;
      tempStr = 0;
      tempEn = 0;
      tempAgi = 0;
      tempMagic = 0;
      tempSta = 0;
      hp = 50 + (1/2 * en);
      mana = 20 + (3/4 * magic);
   }
   Hero(Hero hero) {

   }
}