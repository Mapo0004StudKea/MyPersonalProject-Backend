package stud.kea.dk.mypersonalprojectbackend.jwtsecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import stud.kea.dk.mypersonalprojectbackend.jwtsecurity.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String name);
}
