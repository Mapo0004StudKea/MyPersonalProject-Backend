package stud.kea.dk.mypersonalprojectbackend.jwtsecurity.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestModel  {
    private String username;
    private String password;
}
