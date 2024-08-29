package generators;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

    public String randomText(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}