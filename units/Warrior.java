package units;

import java.util.ArrayList;

public class Warrior extends BaseHero {
    int delivery;

    public Warrior(String name, int health, int attack, int speed, int maxDamage, int minDamage,int protection, int x, int y, int delivery) {
        super(name, health, attack, speed, maxDamage, minDamage, protection, x, y);
        this.delivery = delivery;
    }

    @Override
    public boolean step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {
        if (state.equals("Die"))
            return true;
        BaseHero victim = team2.get(findNearest(team2));
        if (victim.pointXY.getDistance(pointXY) < 2) {
            float damage = (victim.protection - attack) > 0 ? minDamage
                    : (victim.protection - attack) < 0 ? maxDamage : (minDamage + maxDamage) / 2;
            victim.getDamage(damage);
        } else {
            Point2D tempvc = pointXY.chooseWay(victim.pointXY);
            if (Math.abs(tempvc.posX) < Math.abs(tempvc.posY)) {
                if (pointXY.chooseWay(victim.pointXY).posY > 0) {
                    pointXY.posY--;
                } else {
                    pointXY.posY++;
                }
            } else {
                if (pointXY.chooseWay(victim.pointXY).posX > 0) {
                    pointXY.posX--;
                } else {
                    pointXY.posX++;
                }
            }
        }
        return false;
    }
}
