package BookRestAPI.Dao;

import java.util.List;

import BookRestAPI.Entities.User;

public interface UserDao 
{
	public List<User> findAll();
	
	public User findById(int id);
	
	public void addUser(User user);
	
	public void deleteById(int id);
}
