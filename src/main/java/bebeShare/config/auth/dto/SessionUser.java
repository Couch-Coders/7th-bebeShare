package bebeShare.config.auth.dto;

import bebeShare.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@RequiredArgsConstructor
public class SessionUser extends User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
