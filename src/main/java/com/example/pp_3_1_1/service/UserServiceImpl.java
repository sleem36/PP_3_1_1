package com.example.pp_3_1_1.service;

import com.example.pp_3_1_1.dao.UserDao;
import com.example.pp_3_1_1.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.allUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser (int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User deleteUser(int id) {
        return userDao.deleteUser(id);
    }

}
