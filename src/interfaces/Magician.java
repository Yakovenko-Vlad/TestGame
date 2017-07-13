package interfaces;

/**
 * Created by Vlad Yakovenko.
 * Declared methods for magician
 */
public interface Magician {
    /**
     * Attack the enemy with magic
     *
     * @return hit points
     */
    int magicDamage();

    /**
     * Improve the character of your own unit
     *
     * @return 0 - improve the character
     */
    int improveCharacter();
}
