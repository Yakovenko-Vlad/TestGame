package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Magician;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Shaman extends AbstractCharacter implements Magician {
    @Override
    public int magicDamage() {
        return -1;
    }

    @Override
    public int improveCharacter() {
        return 0;
    }

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
