import generators.NumberGenerator;
import generators.StringGenerator;
import objects.Account;

public class TestPreconditions extends BaseTest {
   protected NumberGenerator numberGenerator = new NumberGenerator();
   protected StringGenerator stringGenerator = new StringGenerator();

   protected final Account NEW_ACCOUNT = Account.builder()
                .email("email" + numberGenerator.generateRandomInt(50000) + "@mail.com")
                .firstName("Firstname" + stringGenerator.randomText())
                .lastName("Lastname" + stringGenerator.randomText())
                .password("Password" + numberGenerator.generateRandomInt(50000))
                .dayOfBirth("5")
                .monthOfBirth("July")
                .yearOfBirth("1989")
                .build();
}