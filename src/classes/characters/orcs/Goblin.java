package classes.characters.orcs;

import classes.characters.AbstractCharacter;
import interfaces.Warrior;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Goblin extends AbstractCharacter implements Warrior {
    @Override
    public int attackWithWeapons() {
        return 20;
    }

    @Override
    public int goDamage() {
        System.out.print(getClassName());
        return attackWithWeapons();
    }
}
