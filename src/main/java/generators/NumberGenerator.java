package generators;

import java.util.Random;

public class NumberGenerator {

    private final Random random = new Random();

    /**
     * Generate random int int.
     *
     * @param range the range
     * @return the int
     */
    public int generateRandomInt(int range){
        return random.nextInt(range);
    }
}