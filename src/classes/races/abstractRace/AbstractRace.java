package classes.races.abstractRace;

import classes.characters.AbstractCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public abstract class AbstractRace {
    protected ArrayList<AbstractCharacter> squad = new ArrayList<>(7);
    protected ArrayList<AbstractCharacter> privileged = new ArrayList<>();

    protected abstract void add();

    public ArrayList<AbstractCharacter> getSquad() {
        Collections.shuffle(squad);
        /*for(int i = 0; i < squad.size(); i++){
            if(squad.get(i).getHitPoints()<=0) {
                System.out.println(squad.get(i).getClassName() + " dead");
                squad.remove(i);
                continue;
            }
            else */return squad;
    }

    public List getPrivileged() {
        Collections.shuffle(privileged);
        return privileged;
    }

    public void removalOfImprovement(int index) {
        squad.add(privileged.get(index));
        privileged.remove(index);
    }

    public void improve(int index) {
        privileged.add(squad.get(index));
        squad.remove(index);
    }

    public int size() {
        return squad.size();
    }

    public String getClassName() {
        String name = this.getClass().getName();
        name = name.replaceAll(this.getClass().getPackage().getName() + ".", "");
        return name;
    }
}
