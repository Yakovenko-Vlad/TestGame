package classes.races;

import classes.characters.orcs.Goblin;
import classes.characters.orcs.OrcArcher;
import classes.characters.orcs.Shaman;
import classes.races.abstractRace.AbstractRace;

import java.util.Collections;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the rece Orcs
 */
public class Orcs extends AbstractRace {
    public Orcs() {
        this.add();
        Collections.shuffle(squad); // Mixing array
    }

    /**
     * The creation of a squad consisting of a magician, 3 archers and 4 wariors
     */
    @Override
    protected void add() {
        squad.add(new Shaman());
        for (int i = 0; i < 3; i++) {
            squad.add(new OrcArcher());
        }
        for (int i = 0; i < 4; i++) {
            squad.add(new Goblin());
        }
    }
}
