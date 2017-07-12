package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Archer;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class OrcArcher extends AbstractCharacter implements Archer{
    @Override
    public int archery() {
        return 3;
    }

    @Override
    public int attack() {
        return 2;
    }

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
