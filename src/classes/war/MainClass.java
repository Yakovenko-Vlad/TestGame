package classes.war;

import classes.races.Elves;
import classes.races.Orcs;
import classes.races.People;
import classes.races.Undead;
import classes.races.abstractRace.AbstractRace;

import java.io.*;
import java.util.Random;

/**
 * Created by Vlad Yakovenko.
 * Main class. Random creation of two warring races and random
 * determination of the beginning of the battle
 */
public class MainClass {
    /**
     * Main function - start point of the program
     */
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Random rand = new Random();
        int start = rand.nextInt(11) + 10;
        Fight fight = new Fight();
        AbstractRace firstRace;
        AbstractRace secondRace;
        File file = new File("BattleBetweenEnemyRaces.txt");
        file.delete();
        // Random creation of two warring races
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
        String text = firstRace.getClassName() + " against " + secondRace.getClassName();
        System.out.println(text);
        mainClass.writeFile(text);
        while (firstRace.getSquad().size() > 0 && secondRace.getSquad().size() > 0) { //The cycle in which the battle takes place
            if (start % 2 == 0) {
                fight.battle(firstRace, secondRace);
                if (secondRace.getSquad().size() == 0) break;
                fight.battle(secondRace, firstRace);
                if (firstRace.getSquad().size() == 0) break;
            } else {
                fight.battle(secondRace, firstRace);
                if (secondRace.getSquad().size() == 0) break;
                fight.battle(firstRace, secondRace);
                if (secondRace.getSquad().size() == 0) break;
            }
        }
        if (firstRace.size() > 0) { // Determination of the winner
            text = firstRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size();
            System.out.println(text);
            mainClass.writeFile(text);
        } else {
            text = secondRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size();
            System.out.println(text);
            mainClass.writeFile(text);
        }
    }

    /**
     * Record the progress of the battle at the end of the file
     *
     * @param text text that needs to be written to a file
     */
    public void writeFile(String text) {
        try {
            PrintStream out = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream("BattleBetweenEnemyRaces.txt", true)));
            out.println(text);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
