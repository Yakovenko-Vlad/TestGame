package classes.races;

import classes.characters.undead.Hunter;
import classes.characters.undead.Necromancer;
import classes.characters.undead.Zombie;
import classes.races.abstractRace.AbstractRace;

import java.util.Collections;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the rece Undead
 */
public class Undead extends AbstractRace {
    public Undead() {
        this.add();
        Collections.shuffle(squad); // Mixing array
    }

    /**
     * The creation of a squad consisting of a magician, 3 archers and 4 wariors
     */
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
