package classes.races;

import classes.characters.AbstractCharacter;

import java.util.Collections;
import java.util.List;

import classes.characters.people.Crossbowman;
import classes.characters.people.Mage;
import classes.characters.people.ManWarrior;
import classes.races.abstractRace.AbstractRace;

/**
 * Created by Vlad Yakovenko.
 * Description of the properties of the rece People
 */
public class People extends AbstractRace {

    public People() {
        this.add();
        Collections.shuffle(squad); // Mixing array
    }

    /**
     * The creation of a squad consisting of a magician, 3 archers and 4 wariors
     */
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
