package classes.characters.people;

import interfaces.Archer;
import classes.characters.AbstractCharacter;
/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Crossbowman extends AbstractCharacter implements Archer{
    @Override
    public int archery() {
        return 5;
    }

    @Override
    public int attack() {
        return 3;
    }

    @Override
    public double goDamage() {
        System.out.print(getClassName());
        if((rand.nextInt(2)+1)==1)
            return attack();
        else
            return archery();
    }
}
