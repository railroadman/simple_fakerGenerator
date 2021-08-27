package ru.hereiam.faker.dao;

import ru.hereiam.faker.generators.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
     Optional<User> getUserInfo(Integer id);
     void setUsers(List<User> users);
     void connect();

}
