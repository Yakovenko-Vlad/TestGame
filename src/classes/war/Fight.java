package classes.war;

import classes.characters.AbstractCharacter;
import classes.races.abstractRace.AbstractRace;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/**
 * Created by Vlad Yakovenko.
 * The class in which the round of combat takes place
 */
public class Fight {
    private Random rand = new Random();
    private int size; // size of enemy squad
    private int index; //random index of enemy character

    /**
     * The entire squad of one of the teams inflicts damage to the opposing team.
     * Who deals damage and who is determined randomly.
     *
     * @param firstRace race which inflicts damage
     * @param secondRace race which takes damage
     */
    public void battle(AbstractRace firstRace, AbstractRace secondRace){
        double damage;
        String text;
        String flag = "";
        size = secondRace.getSquad().size();
        if (firstRace.getPrivileged() != null) { // Execution of an action by a character from a privileged group
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
        for (AbstractCharacter character : firstRace.getSquad()) { // Performing actions by characters from the main group
            if (character.toString().equals(flag)) { // If the character was in a privileged group he misses the move
                firstRace.removalOfImprovement();
                continue;
            }
            damage = character.goDamage();
            if (damage == -1) { //If the damage = -1, then the enemy is removed from the privileged group
                if (secondRace.getPrivileged() != null) {
                    secondRace.removalOfImprovement();
                    System.out.println(" lowered");
                    writeFile(" lowered");
                }
            }
            if (damage == -2) { // If the damage = -2 then the enemy's damage will be reduced by 2 times
                System.out.println(" sent ailment");
                writeFile(" sent ailment");
                secondRace.addToLessDamage(secondRace.getSquad().get(rand.nextInt(size)));
            }
            if (character.toString().equals(firstRace.getLessDamageCharacter())) { // If the character has less damage his damage /2
                damage = damage / 2;
                System.out.print(" put a curse ");
            }
            if (damage == 0) { // If the damage = 0 then the random member of the squad moves to the privileged group
                System.out.println(" improve");
                writeFile(" improve");
                firstRace.improve(character);
            }
            if (damage > 0) { // If the damage is greater than 0, it is dealt to a random opponent
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


