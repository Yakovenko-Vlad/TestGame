package classes.characters;

import java.io.*;
import java.util.Random;

/**
 * Created by Vlad Yakovenko on 08.07.2017.
 */
public abstract class AbstractCharacter {
    protected double hitPoints = 100;
    protected Random rand = new Random();

    public void gotDamage(double damage) {
        hitPoints -= damage;
        showDamage(damage);
    }

    protected void showDamage(double damage) {
        String text = " inflicted " + damage + "hp damage to " + this.getClassName();
        System.out.println(text);
        writeFile(text, 1);
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public String getClassName() {
        String name = this.getClass().getName();
        name = name.replaceAll(this.getClass().getPackage().getName() + ".", "");
        return name;
    }

    public abstract double goDamage();

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
