package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Warrior;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character goblin
 */
public class Goblin extends AbstractCharacter implements Warrior {
    /**
     * Attack an enemy with weapons
     *
     * @return hit points
     */
    @Override
    public int attackWithWeapons() {
        return 20;
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
