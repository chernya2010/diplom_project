package generators;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

    /**
     * Random text string.
     *
     * @return the string
     */
    public String randomText(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}