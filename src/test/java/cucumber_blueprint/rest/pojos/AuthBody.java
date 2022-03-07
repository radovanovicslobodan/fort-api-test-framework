package cucumber_blueprint.rest.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthBody {

    private String username;
    private String password;

    public AuthBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
