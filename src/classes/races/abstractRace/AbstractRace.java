package classes.races.abstractRace;

import classes.characters.AbstractCharacter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Vlad Yakovenko.
 * An abstract class that implements the methods that will be common to all races
 */
public abstract class AbstractRace {
    /**
     * Squad of each race
     */
    protected ArrayList<AbstractCharacter> squad = new ArrayList<>(8);
    private Random rand = new Random();
    /**
     * The name of the object on which the curse is imposed (damage / 2)
     */
    private String lessDamage = null;
    /**
     * The name of the object from the privileged group
     */
    private String privilegChar = null;

    /**
     * Creation of a squad of race
     */
    protected abstract void add();

    /**
     * Returns the squad of race
     *
     * @return squad of race
     */
    public ArrayList<AbstractCharacter> getSquad() {
        return squad;
    }

    /**
     * Curse on the enemy
     *
     * @param character object on which a curse is imposed
     */
    public void addToLessDamage(AbstractCharacter character) {
        lessDamage = character.toString();
    }

    /**
     * Returns the name of the object with reduced damage
     *
     * @return name of the object
     */
    public String getLessDamageCharacter() {
        return lessDamage;
    }

    /**
     * Deleting an object name with reduced damage
     */
    public void removLessDamageCharacter() {
        lessDamage = null;
    }

    /**
     * Returns the name of the object from the privileged group
     *
     * @return name of the object
     */
    public String getPrivileged() {
        return privilegChar;
    }

    /**
     * Delete from a privileged group
     */
    public void removalOfImprovement() {
        privilegChar = null;
    }

    /**
     * Improvement of a member of the squad
     *
     * @param character an object that improved a member of the squad
     */
    public void improve(AbstractCharacter character) {
        while (true) {
            int i = rand.nextInt(squad.size()) + 0;
            if (squad.get(i).equals(character) == false) {
                privilegChar = squad.get(i).toString();
                return;
            } else continue;
        }
    }

    /**
     * Number of living members of the squad
     *
     * @return number of members
     */
    public int size() {
        return squad.size();
    }

    /**
     * Returns the name of the class
     *
     * @return name of the class
     */
    public String getClassName() {
        String name = this.getClass().getName();
        name = name.replaceAll(this.getClass().getPackage().getName() + ".", "");
        return name;
    }
}
