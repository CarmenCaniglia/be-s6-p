package carmencaniglia.bes6p.controllers;

import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping
    public List<User> getUsers(){
    return usersService.getUsers();
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId){
    return usersService.findById(userId);
    }
    @PostMapping
    public User createUser(@RequestBody User newUserPayload){
    return usersService.save(newUserPayload);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable long userId,@RequestBody User updateUserPayload){
    return usersService.findByIdAndUpdate(userId, updateUserPayload);
    }
    @DeleteMapping("/{userId}")
    public void getAndDeleteUser(@PathVariable long userId){
    usersService.findByIdAndDelete(userId);
    }
}
