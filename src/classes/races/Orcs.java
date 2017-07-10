package classes.races;

import classes.characters.orcs.Goblin;
import classes.characters.orcs.OrcArcher;
import classes.characters.orcs.Shaman;
import classes.races.abstractRace.AbstractRace;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Orcs extends AbstractRace {
    public Orcs() {
        this.add();
    }

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
