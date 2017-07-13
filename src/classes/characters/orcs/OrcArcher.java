package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Archer;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character orc archer
 */
public class OrcArcher extends AbstractCharacter implements Archer {
    /**
     * Shot with a Archer
     *
     * @return hit points
     */
    @Override
    public int archery() {
        return 3;
    }

    /**
     * Attack the enemy
     *
     * @return hit points
     */
    @Override
    public int attack() {
        return 2;
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
            return attack();
        else
            return archery();
    }
}
