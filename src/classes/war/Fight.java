package classes.war;

import classes.characters.AbstractCharacter;
import classes.races.abstractRace.AbstractRace;

import java.util.Random;

/**
 * Created by Vlad Yakovenko on 09.07.2017.
 */
public class Fight {
    private Random rand = new Random();
    int size;
    int index;
    public void battle(AbstractRace firstRace,  AbstractRace secondRace) throws InterruptedException {
        size = secondRace.getSquad().size()-1;
        for(AbstractCharacter character : firstRace.getSquad()){
            int damage = character.goDamage();
            if(size==0) index = 0;
            else index = (rand.nextInt(size)+0);
            secondRace.getSquad().get(index).gotDamage(damage);
            if(secondRace.getSquad().get(index).getHitPoints()<=0) {
                System.out.println(character.getClassName() + " killed " + secondRace.getSquad().get(index).getClassName());
                secondRace.getSquad().remove(index);
                if(secondRace.getSquad().size()<=0 || index == 0) break;
                else size--;

            }
        }
        System.out.println("fsize = " + firstRace.size() + "; sSsize = " + secondRace.size());
        Thread.sleep(1000);
    }

}


