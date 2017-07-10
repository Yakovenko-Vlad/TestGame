package classes.characters.people;

import interfaces.Warrior;
import classes.characters.AbstractCharacter;
/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class ManWarrior extends AbstractCharacter implements Warrior {
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
