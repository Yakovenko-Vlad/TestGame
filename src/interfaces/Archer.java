package interfaces;

/**
 * Created by Vlad Yakovenko
 * Declared methods for archer
 */
public interface Archer {
    /**
     * Shot with a Archer
     *
     * @return hit points
     */
    int archery();

    /**
     * Attack the enemy
     *
     * @return hit points
     */
    int attack();
}
