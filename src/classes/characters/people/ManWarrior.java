package classes.characters.people;

import interfaces.Warrior;
import classes.characters.AbstractCharacter;
/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character warrior
 */
public class ManWarrior extends AbstractCharacter implements Warrior {
    /**
     * Attack an enemy with weapons
     *
     * @return hit points
     */
    @Override
    public int attackWithWeapons() {
        return 18;
    }

    /**
     * Damage inflicted on the enemy
     *
     * @return hit points
     */
    @Override
    public double goDamage() {
        System.out.print(getClassName());
        writeFile(getClassName(), 2);
        return attackWithWeapons();
    }
}
