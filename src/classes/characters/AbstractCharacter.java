package classes.characters;

import java.util.Random;

/**
 * Created by Vlad Yakovenko on 08.07.2017.
 */
public abstract class AbstractCharacter {
    protected int hitPoints = 100;
    protected Random rand = new Random();

    public void gotDamage(int damage) {
        hitPoints -= damage;
        showDamage(damage);
    }

    protected void showDamage(int damage) {
        System.out.println(" inflicted " + damage + "hp damage to " + this.getClassName());
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getClassName() {
        String name = this.getClass().getName();
        name = name.replaceAll(this.getClass().getPackage().getName() + ".", "");
        return name;
    }

    public abstract int goDamage();
}
