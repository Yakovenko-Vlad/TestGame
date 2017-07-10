package classes.characters.undead;

import classes.characters.AbstractCharacter;
import interfaces.Magician;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Necromancer extends AbstractCharacter implements Magician {
    @Override
    public int magicDamage() {
        return 5;
    }

    @Override
    public int improveCharacter() {
        return -2;
    }

    @Override
    public double goDamage() {
        System.out.print(getClassName());
        if((rand.nextInt(2)+1)==1)
            return improveCharacter();
        else
            return magicDamage();
    }
}
