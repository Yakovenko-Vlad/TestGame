package classes.characters.people;

import interfaces.Magician;
import classes.characters.AbstractCharacter;
/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Mage extends AbstractCharacter implements Magician {
    @Override
    public int magicDamage() {
        return 4;
    }

    @Override
    public int improveCharacter() {
        return 0;
    }

    @Override
    public int goDamage() {
        System.out.print(getClassName());
        if((rand.nextInt(2)+1)==1)
            return improveCharacter();
        else
            return magicDamage();
    }
}
