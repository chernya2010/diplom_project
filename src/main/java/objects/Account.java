package objects;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
}