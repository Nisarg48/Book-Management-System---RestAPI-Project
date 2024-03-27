package BookRestAPI.Service;

import BookRestAPI.Entities.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public void addUser(User user);

    public void deleteById(int id);
}
