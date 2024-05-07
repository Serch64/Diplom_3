package site.nomoreparties.stellarburgers.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreds {
    private String email;
    private String password;
    public static UserCreds from(User user) {
        return new UserCreds(user.getEmail(), user.getPassword());
    }
}

