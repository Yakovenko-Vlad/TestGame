package classes.characters;

import java.io.*;
import java.util.Random;

/**
 * Created by Vlad Yakovenko.
 * An abstract class that implements the methods that will be common to all game characters.
 */
public abstract class AbstractCharacter {
    /**
     * Number hit points for each character
     */
    protected double hitPoints = 100;
    protected Random rand = new Random();

    /**
     * Receiving damage hit points
     *
     * @param damage number of damage points
     */
    public void gotDamage(double damage) {
        hitPoints -= damage;
        showDamage(damage);
    }

    /**
     * Damage mapping
     *
     * @param damage inflicted damage
     */
    protected void showDamage(double damage) {
        String text = " inflicted " + damage + "hp damage to " + this.getClassName();
        System.out.println(text);
        writeFile(text, 1);
    }

    /**
     * Returns the number of points of strength
     *
     * @return number of hit points
     */
    public double getHitPoints() {
        return hitPoints;
    }

    /**
     * Returns the name of the class
     *
     * @return name of the class
     */
    public String getClassName() {
        String name = this.getClass().getName();
        name = name.replaceAll(this.getClass().getPackage().getName() + ".", "");
        return name;
    }

    /**
     * Damage inflicted on the enemy
     *
     * @return hit points
     */
    public abstract double goDamage();

    /**
     * Record the progress of the battle at the end of the file
     *
     * @param text      text that needs to be written to a file
     * @param typePrint type of record in file (1 - println; 2 - print)
     */
    public void writeFile(String text, int typePrint) {
        try {
            PrintStream out = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream("BattleBetweenEnemyRaces.txt", true)));
            if (typePrint == 1)
                out.println(text);
            else
                out.print(text);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
