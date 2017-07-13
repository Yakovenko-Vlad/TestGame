package classes.characters.elves;

import classes.characters.AbstractCharacter;
import interfaces.Warrior;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character elf warrior
 */
public class ElfWarrior extends AbstractCharacter implements Warrior {
    /**
     * Attack an enemy with weapons
     *
     * @return hit points
     */@Override
    public int attackWithWeapons() {
        return 15;
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
