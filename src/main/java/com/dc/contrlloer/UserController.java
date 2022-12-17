package com.dc.contrlloer;



import com.dc.dal.UserRepository;
import com.dc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getByUserId(@PathVariable String userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    @PostMapping("")
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        User user = new User();
        user.setUserId(userId);
        userRepository.deleteById(userId);
        return "deleted: " + userId;
    }

    @PutMapping("")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }
}
