package classes.war;

import classes.races.Elves;
import classes.races.Orcs;
import classes.races.People;
import classes.races.Undead;
import classes.races.abstractRace.AbstractRace;

import java.io.*;
import java.util.Random;

/**
 * Created by Vlad Yakovenko on 08.07.2017.
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        MainClass mainClass = new MainClass();
        Random rand = new Random();
        int start = rand.nextInt(11) + 10;
        Fight fight = new Fight();
        AbstractRace firstRace;
        AbstractRace secondRace;
        File file = new File("BattleBetweenEnemyRaces.txt");
        file.delete();
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
        while (firstRace.getSquad().size() > 0 && secondRace.getSquad().size() > 0) {
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
        if (firstRace.size() > 0) {
            text = firstRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size();
            System.out.println(text);
            mainClass.writeFile(text);
        } else {
            text = secondRace.getClassName() + " win " + firstRace.size() + ":" + secondRace.size();
            System.out.println(text);
            mainClass.writeFile(text);
        }
    }

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
