package testfinproj.service;

import testfinproj.entities.forLoging.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getOneUser (String username);
    List<User> allUsers();
    boolean addUser(User user);
    User editUser(User user);
    public void saveUser(User user, String username, Map<String, String> form);
}
