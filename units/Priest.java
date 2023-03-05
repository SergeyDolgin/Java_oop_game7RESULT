package units;

import java.util.ArrayList;

public class Priest extends BaseHero {
    protected int mana;
    protected int maxMana;

    public Priest(String name, int health, int attack, int speed, int maxDamage, int minDamage, int protection, int x, int y, int mana) {
        super(name, health, attack, speed, maxDamage, minDamage, protection, x, y);
        this.mana = mana;
    }

    /**Переопределить step так, чтобы он если он не Die, то он ищет среди своих подстреленного и лечит его  */
    @Override
    public boolean step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        // if (state.equals("Die")) return;
        for (BaseHero baseHero: team1) {
            if (baseHero.health < baseHero.maxHealth & !baseHero.state.equals("Die")) {
                baseHero.getDamage(maxDamage);
                return false;
            }
        }
        return true;
    }
    

}
