package classes.war;

import classes.characters.AbstractCharacter;
import classes.races.abstractRace.AbstractRace;

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
        size = secondRace.getSquad().size() - 1;
        if (firstRace.getPrivileged() != null)
            for (AbstractCharacter prChar : firstRace.getSquad()) {
                if (prChar.toString().equals(firstRace.getPrivileged())) {
                    damage = prChar.goDamage()*1.5;
                    if (prChar.toString().equals(firstRace.getLessDamageCharacter()))
                        damage = damage / 2;
                    secondRace.getSquad().get(rand.nextInt(secondRace.getSquad().size())).gotDamage(damage);
                }
            }
        for (AbstractCharacter character : firstRace.getSquad()) {
            if(character.toString().equals(firstRace.getPrivileged())){
                System.out.println("privileg");
                continue;
            }
            damage = character.goDamage();
            if (damage == -1) {
                if (firstRace.getPrivileged() != null) secondRace.removalOfImprovement();
                System.out.println(" lowered");
            }
            if (damage == -2) {
                System.out.println(" sent ailment");
                secondRace.addToLessDamage(secondRace.getSquad().get(rand.nextInt(size)));
            }
            if (character.toString().equals(firstRace.getLessDamageCharacter())) {
                damage = damage / 2;
                System.out.print(" put a curse ");
            }
            if (damage == 0) {
                System.out.println(" improve");
                firstRace.improve(character);
            }
            if (damage > 0) {
                if (size == 0) index = 0;
                else index = (rand.nextInt(size) + 0);
                secondRace.getSquad().get(index).gotDamage(damage);
                if (secondRace.getSquad().get(index).getHitPoints() <= 0) {
                    System.out.println(character.getClassName() + " killed " + secondRace.getSquad().get(index).getClassName());
                    secondRace.getSquad().remove(index);
                    if (secondRace.getSquad().size() <= 0 || index == 0) break;
                    else size--;
                }
            }
        }
        firstRace.removLessDamageCharacter();
        System.out.println(firstRace.getClassName() + " = " + firstRace.size() + "; " + secondRace.getClassName() + " = " + secondRace.size()+"\n");
        Thread.sleep(1000);
    }

}


