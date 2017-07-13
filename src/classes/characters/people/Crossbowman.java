package classes.characters.people;

import interfaces.Archer;
import classes.characters.AbstractCharacter;
/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character crossbowman
 */
public class Crossbowman extends AbstractCharacter implements Archer{
    /**
     * Shot with a Archer
     *
     * @return hit points
     */
    @Override
    public int archery() {
        return 5;
    }

    /**
     * Attack the enemy
     *
     * @return hit points
     */
    @Override
    public int attack() {
        return 3;
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
            return attack();
        else
            return archery();
    }
}
