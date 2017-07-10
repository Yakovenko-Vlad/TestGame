package classes.races;

import classes.characters.undead.Hunter;
import classes.characters.undead.Necromancer;
import classes.characters.undead.Zombie;
import classes.races.abstractRace.AbstractRace;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Undead extends AbstractRace {
    public Undead() {
        this.add();
    }

    @Override
    protected void add() {
        squad.add(new Necromancer());
        for (int i = 0; i < 3; i++) {
            squad.add(new Hunter());
        }
        for (int i = 0; i < 4; i++) {
            squad.add(new Zombie());
        }

    }
}
