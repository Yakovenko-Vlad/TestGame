package classes.races;

import classes.characters.AbstractCharacter;
import java.util.List;

import classes.characters.people.Crossbowman;
import classes.characters.people.Mage;
import classes.characters.people.ManWarrior;
import classes.races.abstractRace.AbstractRace;

/**
 * Created by Vlad Yakovenko on 08.07.2017.
 */
public class People extends AbstractRace {

    public People() {
        this.add();
    }

    protected void add() {
        squad.add(new Mage());
        for (int i = 0; i < 3; i++) {
            squad.add(new Crossbowman());
        }
        for (int i = 0; i < 4; i++) {
            squad.add(new ManWarrior());
        }

    }
}
