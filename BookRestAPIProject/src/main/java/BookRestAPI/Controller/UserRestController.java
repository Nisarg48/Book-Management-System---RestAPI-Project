package BookRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BookRestAPI.Entities.User;
import BookRestAPI.Service.UserService;

@RestController
public class UserRestController 
{
	private UserService userService;
	
	@Autowired
	UserRestController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.findAll();
	}
	
	@GetMapping("/user/id/{id}")
	public User getUserById(@PathVariable int id)
	{
		User user = userService.findById(id);
		return user; 
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user)
	{
		System.out.println(user.getUid() + " " + user.getAddress() + " " + user.getContactno() + " " + user.getFname()+user.getLname());
		userService.addUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable int id)
	{
		userService.deleteById(id);
	}
}









