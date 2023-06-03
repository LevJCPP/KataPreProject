package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceProvider implements UserService {

    private UserDao dao;

    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        dao.removeById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
