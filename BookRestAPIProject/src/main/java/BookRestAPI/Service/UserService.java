package BookRestAPI.Service;

import java.util.List;

import BookRestAPI.Entities.User;

public interface UserService 
{	
	public List<User> findAll();
	
	public User findById(int id);

	public void addUser(User user);
	
	public void deleteById(int id);
}
