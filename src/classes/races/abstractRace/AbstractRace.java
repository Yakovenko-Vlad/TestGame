package classes.races.abstractRace;

import classes.characters.AbstractCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public abstract class AbstractRace {
    protected ArrayList<AbstractCharacter> squad = new ArrayList<>(8);
    private Random rand = new Random();
    private String lessDamage;
    private String privilegChar;

    protected abstract void add();

    public ArrayList<AbstractCharacter> getSquad() {
        Collections.shuffle(squad);
        return squad;
    }

    public void addToLessDamage(AbstractCharacter character) {
        lessDamage = character.toString();
    }

    public String getLessDamageCharacter() {
        return lessDamage;
    }

    public void removLessDamageCharacter() {
        lessDamage = null;
    }

    public String getPrivileged() {
        return privilegChar;
    }

    public void removalOfImprovement() {
        privilegChar = null;
    }

    public void improve(AbstractCharacter character) {
        while (true) {
            int i = rand.nextInt(squad.size()) + 0;
            if (squad.get(i).equals(character) == false) {
                privilegChar = squad.get(i).toString();
                return;
            } else continue;
        }
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
