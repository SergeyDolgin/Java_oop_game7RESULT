/*
Степ пехоты и доработать весь проект.
 */

import units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> listResult = new ArrayList<>();
    public static ArrayList<BaseHero> team1 = new ArrayList<>();
    public static ArrayList<BaseHero> team2 = new ArrayList<>();
    static final int UNITS = 10;
    
    public static void main(String[] args) {

        Random rand = new Random();
 /** Создать в основной программе два списка. Команды GREEN и BLUE расставлены по левую и правую стороны поля 10х10*/
        for (int i = 0; i < UNITS; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0:
                    team1.add(new Sniper(getName(),  new Point2D(i+1, 1)));
                    break;
                case 1:
                    team1.add(new Villager(getName(), new Point2D(i+1, 1)));
                    break;
                case 2:
                    team1.add(new Magician(getName(), new Point2D(i+1, 1)));
                    break;
                case 3:
                    team1.add(new Raider(getName(), new Point2D(i+1, 1)));
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < UNITS; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0:
                    team2.add(new Arbalester(getName(), new Point2D(i+1, 10)));
                    break;
                case 1:
                    team2.add(new Villager(getName(), new Point2D(i+1, 10)));
                    break;
                case 2:
                    team2.add(new Monk(getName(), new Point2D(i+1, 10)));
                    break;
                case 3:
                    team2.add(new Spearman(getName(), new Point2D(i+1, 10)));
                    break;
                default:
                    break;
            }
        }

        listResult.addAll(team1);
        listResult.addAll(team2);

        // /** Сортировка всех персонажей по скорости */
        listResult.sort(new Comparator<BaseHero>() {

            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o2.getSpeed() == o1.getSpeed())
                    return o2.getHP() - o1.getHP();
                return o2.getSpeed() - o1.getSpeed();
            }
        });


        /** Пошаговая борьба всех персонажей */
        
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Нажмите ENTER, чтобы начать игру");
            userInput.nextLine();
            boolean a = true;
            int cntBlue = 0;
            int cntGreen = 0;
            while (a) {
                View.view();
                userInput.nextLine();
                cntBlue = 0;
                cntGreen = 0;
                for (BaseHero baseHero : listResult) {
                    if (team1.contains(baseHero)) {
                        if (baseHero.step(team1, team2))
                            cntGreen++;}
                    else {
                        if ((baseHero.step(team2, team1)))
                            cntBlue++;
                    };
                }
                if (cntBlue == UNITS || cntGreen == UNITS)
                    a = false;
            }
            if (cntBlue == UNITS) System.out.println("Победила команда GREEN");
            else {System.out.println("Победила команда BLUE");}
        }
    }
  
    static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

}
