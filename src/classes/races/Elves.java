package classes.races;

import classes.characters.elves.ElfArcher;
import classes.characters.elves.ElfMagician;
import classes.characters.elves.ElfWarrior;
import classes.races.abstractRace.AbstractRace;

import java.util.Collections;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the rece Elves
 */
public class Elves extends AbstractRace {
    public Elves() {
        this.add();
        Collections.shuffle(squad); // Mixing array
    }

    /**
     * The creation of a squad consisting of a magician, 3 archers and 4 wariors
     */
    @Override
    protected void add() {
        squad.add(new ElfMagician());
        for (int i = 0; i < 3; i++) {
            squad.add(new ElfArcher());
        }
        for (int i = 0; i < 4; i++) {
            squad.add(new ElfWarrior());
        }

    }
}
