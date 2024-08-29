package generators;

import java.util.Random;

public class NumberGenerator {
    private Random random = new Random();

    public int generateRandomInt(int range){
        return random.nextInt(range);
    }
}