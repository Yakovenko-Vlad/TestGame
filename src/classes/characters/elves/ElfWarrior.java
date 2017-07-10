package classes.characters.elves;

import classes.characters.AbstractCharacter;
import interfaces.Warrior;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class ElfWarrior extends AbstractCharacter implements Warrior {
    @Override
    public int attackWithWeapons() {
        return 15;
    }

    @Override
    public double goDamage() {
        System.out.print(getClassName());
        return attackWithWeapons();
    }
}
