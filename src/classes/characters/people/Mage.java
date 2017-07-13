package classes.characters.people;

import interfaces.Magician;
import classes.characters.AbstractCharacter;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character mage
 */
public class Mage extends AbstractCharacter implements Magician {
    /**
     * Attack the enemy with magic
     *
     * @return hit points
     */
    @Override
    public int magicDamage() {
        return 4;
    }

    /**
     * Improve the character of your own unit
     *
     * @return 0 - improve the character
     */
    @Override
    public int improveCharacter() {
        return 0;
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
        if ((rand.nextInt(2) + 1) == 1)
            return improveCharacter();
        else
            return magicDamage();
    }
}
