package classes.war;

import classes.races.Elves;
import classes.races.Orcs;
import classes.races.People;
import classes.races.Undead;
import classes.races.abstractRace.AbstractRace;

import java.util.Random;

/**
 * Created by Vlad Yakovenko on 08.07.2017.
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int start = rand.nextInt(11) + 10;
        Fight fight = new Fight();
        AbstractRace firstRace;
        AbstractRace secondRace;
        if ((rand.nextInt(11) + 10) % 2 == 0) {
            firstRace = new People();
        } else {
            firstRace = new Elves();
        }
        if ((rand.nextInt(11) + 10) % 2 == 0) {
            secondRace = new Orcs();
        } else {
            secondRace = new Undead();
        }
        System.out.println(firstRace.getClassName() + " against " + secondRace.getClassName());
        while (firstRace.getSquad().size() > 0 || secondRace.getSquad().size() > 0) {
            if (start % 2 == 0) {
                fight.battle(firstRace, secondRace);
                if (secondRace.getSquad().size() <= 0) break;
                fight.battle(secondRace, firstRace);
                if (firstRace.getSquad().size() <= 0) break;
            } else {
                fight.battle(secondRace, firstRace);
                if (secondRace.getSquad().size() <= 0) break;
                fight.battle(firstRace, secondRace);
                if (secondRace.getSquad().size() <= 0) break;
            }
        }
        if (firstRace.size() > 0)
            System.out.println(firstRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size());
        else System.out.println(secondRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size());
    }
}
