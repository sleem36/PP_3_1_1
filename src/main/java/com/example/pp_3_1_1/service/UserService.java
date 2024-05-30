package com.example.pp_3_1_1.service;

import com.example.pp_3_1_1.model.User;
import java.util.List;

public interface UserService {
    public List<User> getAll();

    public void saveUser (User user);

    public User getUser (int id);

    public User deleteUser(int id);
}
