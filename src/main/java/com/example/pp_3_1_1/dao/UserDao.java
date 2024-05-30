package com.example.pp_3_1_1.dao;


import com.example.pp_3_1_1.model.User;
import java.util.List;

public interface UserDao {
    public List<User> allUser ();

    public void saveUser(User user);

    public User getUser(int id);

    public User deleteUser(int id);
}
