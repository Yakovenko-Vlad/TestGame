package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Magician;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character shaman
 */
public class Shaman extends AbstractCharacter implements Magician {
    /**
     * Curse on the enemy
     *
     * @return -1 - curse
     */
    @Override
    public int magicDamage() {
        return -1;
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
        if((rand.nextInt(2)+1)==1)
            return improveCharacter();
        else
            return magicDamage();
    }
}
