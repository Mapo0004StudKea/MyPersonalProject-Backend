package stud.kea.dk.mypersonalprojectbackend.jwtsecurity.service;

import stud.kea.dk.mypersonalprojectbackend.jwtsecurity.entity.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
