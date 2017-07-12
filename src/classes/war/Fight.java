package classes.war;

import classes.characters.AbstractCharacter;
import classes.races.abstractRace.AbstractRace;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Fight {
    private Random rand = new Random();
    private int size;
    private int index;

    public void battle(AbstractRace firstRace, AbstractRace secondRace) throws InterruptedException {
        double damage;
        String text;
        String flag = "";
        size = secondRace.getSquad().size();
        if (firstRace.getPrivileged() != null) {
            for (AbstractCharacter prChar : firstRace.getSquad()) {
                if (prChar.toString().equals(firstRace.getPrivileged())) {
                    damage = prChar.goDamage() * 1.5;
                    if (prChar.toString().equals(firstRace.getLessDamageCharacter()))
                        damage = damage / 2;
                    secondRace.getSquad().get(rand.nextInt(secondRace.getSquad().size())).gotDamage(damage);
                    flag = firstRace.getPrivileged();
                }
            }
        }
        for (AbstractCharacter character : firstRace.getSquad()) {
            if (character.toString().equals(flag)) {
                firstRace.removalOfImprovement();
                continue;
            }
            damage = character.goDamage();
            if (damage == -1) {
                if (secondRace.getPrivileged() != null){
                    secondRace.removalOfImprovement();
                    System.out.println(" lowered");
                    writeFile(" lowered");
                }
            }
            if (damage == -2) {
                System.out.println(" sent ailment");
                writeFile(" sent ailment");
                secondRace.addToLessDamage(secondRace.getSquad().get(rand.nextInt(size)));
            }
            if (character.toString().equals(firstRace.getLessDamageCharacter())) {
                damage = damage / 2;
                System.out.print(" put a curse ");
            }
            if (damage == 0) {
                System.out.println(" improve");
                writeFile(" improve");
                firstRace.improve(character);
            }
            if (damage > 0) {
                index = (rand.nextInt(size));
                secondRace.getSquad().get(index).gotDamage(damage);
                if (secondRace.getSquad().get(index).getHitPoints() <= 0) {
                    text = character.getClassName() + " killed " + secondRace.getSquad().get(index).getClassName();
                    System.out.println(text);
                    writeFile(text);
                    secondRace.getSquad().remove(index);
                    size = secondRace.getSquad().size();
                    if (size == 0) break;
                }
            }
        }
        firstRace.removLessDamageCharacter();
        text = firstRace.getClassName() + " = " + firstRace.size() + "; " + secondRace.getClassName() + " = " + secondRace.size() + "\n";
        System.out.println(text);
        writeFile(text);
        writeFile("");
        Thread.sleep(1000);
    }

    public void writeFile(String text) {
        try {
            PrintStream out = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream("text.txt", true)));
            out.println(text);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


