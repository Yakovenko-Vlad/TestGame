package classes.characters.elves;

import classes.characters.AbstractCharacter;
import interfaces.Archer;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class ElfArcher extends AbstractCharacter implements Archer{
    @Override
    public int archery() {
        return 7;
    }

    @Override
    public int attack() {
        return 3;
    }

    @Override
    public int goDamage() {
        System.out.print(getClassName());
        if((rand.nextInt(2)+1)==1)
            return attack();
        else
            return archery();
    }
}
