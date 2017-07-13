package classes.characters.elves;

import classes.characters.AbstractCharacter;
import interfaces.Archer;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the character elf archer
 */
public class ElfArcher extends AbstractCharacter implements Archer{
    /**
     * Shot with a Archer
     *
     * @return hit points
     */
    @Override
    public int archery() {
        return 7;
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
