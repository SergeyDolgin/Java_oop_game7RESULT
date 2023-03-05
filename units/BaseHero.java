package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements Interface {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected int maxDamage, minDamage;
    protected int attack;
    protected int protection;
    protected static Random r;
    protected Point2D pointXY;
    protected String state;
    protected static int heroCnt;

    /** Конструктор который отвечает за инициализацию */
    public BaseHero(String name, int health, int attack, int speed, int maxDamage, int minDamage, int protection, int posX, int posY) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.attack = attack;
        this.protection = protection;
        pointXY = new Point2D(posX, posY);
        state = "Stand";
        heroCnt++;
    }

    /** Методы получения информации */



    public int getSpeed() {
        return speed;
    }
    
    public int getHP(){
        return health;
    }

    protected void getDamage(float damage) {
        this.health -= damage;
        if (health <= 0) {
            health = 0;
            state = "Die";
        }
        if (health > maxHealth) health = maxHealth;
    }

    
    @Override
    public boolean step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {return true;}
    
    @Override
    public String toString() {
        return name +
                " H:" + Math.round(health) +
                " D:" + protection +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((minDamage+maxDamage)/2)) +
                " " + state;
    }

    public int[] getCoords() {return new int[]{pointXY.posX, pointXY.posY};}

    public int findNearest(ArrayList<BaseHero> listResult){
        int index = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < listResult.size(); i++) {
            if(min > pointXY.getDistance(listResult.get(i).pointXY) && !listResult.get(i).state.equals("Die")) {
                index = i;
                min = pointXY.getDistance(listResult.get(i).pointXY);
            }
        }
        return index;
    }

    @Override
    public StringBuilder getInfo() {
        return new StringBuilder("");
    }
}


