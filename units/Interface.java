package units;

import java.util.ArrayList;

public interface Interface {

    boolean step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2);
    
    StringBuilder getInfo();
    
}
