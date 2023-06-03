package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void removeById(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}
