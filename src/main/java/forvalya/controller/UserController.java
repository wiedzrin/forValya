package forvalya.controller;

import forvalya.entity.User;
import forvalya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteUser(@PathVariable("name") String name) {
        userService.deleteUserByName(name);
        return ResponseEntity.ok().build();
    }
}
