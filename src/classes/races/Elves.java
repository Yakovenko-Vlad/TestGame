package classes.races;

import classes.characters.elves.ElfArcher;
import classes.characters.elves.ElfMagician;
import classes.characters.elves.ElfWarrior;
import classes.races.abstractRace.AbstractRace;

import java.util.Collections;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Elves extends AbstractRace {
    public Elves() {
        this.add();
        Collections.shuffle(squad);
    }

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
