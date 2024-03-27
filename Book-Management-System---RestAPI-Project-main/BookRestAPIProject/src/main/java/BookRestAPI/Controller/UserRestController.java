package BookRestAPI.Controller;

import BookRestAPI.Entities.User;
import BookRestAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/user/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUserById(@PathVariable int id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public void addUser(@RequestBody User user) {
        System.out.println(user.getUid() + " " + user.getAddress() + " " + user.getContactno() + " " + user.getFname() + user.getLname());
        userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteById(id);
    }
}









