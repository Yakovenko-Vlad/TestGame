package classes.characters.undead;

import classes.characters.AbstractCharacter;
import interfaces.Magician;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character necromancer
 */
public class Necromancer extends AbstractCharacter implements Magician {
    /**
     * Attack the enemy with magic
     *
     * @return hit points
     */
    @Override
    public int magicDamage() {
        return 5;
    }

    /**
     * Send ailment on the enemy
     *
     * @return -2 - to send ailment
     */
    @Override
    public int improveCharacter() {
        return -2;
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
