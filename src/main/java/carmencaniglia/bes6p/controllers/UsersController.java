package carmencaniglia.bes6p.controllers;

import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String orderBy){
    return usersService.getUsers(page, size, orderBy);
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId){
    return usersService.findById(userId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUserPayload){
    return usersService.save(newUserPayload);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable long userId,@RequestBody User updateUserPayload){
    return usersService.findByIdAndUpdate(userId, updateUserPayload);
    }
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAndDeleteUser(@PathVariable long userId){
    usersService.findByIdAndDelete(userId);
    }
}
