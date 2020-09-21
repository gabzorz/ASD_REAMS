package uts.asd.model.user;

import lombok.*;
import uts.asd.model.IdentifiableModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends IdentifiableModel {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String dob;
    private String address;
    private String number;
    private Role role;
    private boolean enabled;

    public Role getRole() {
        return role;
    }

}

