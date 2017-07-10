package classes.characters.undead;

import classes.characters.AbstractCharacter;
import interfaces.Warrior;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Zombie extends AbstractCharacter implements Warrior {
    @Override
    public int attackWithWeapons() {
        return 18;
    }

    @Override
    public double goDamage() {
        System.out.print(getClassName());
        return attackWithWeapons();
    }
}
