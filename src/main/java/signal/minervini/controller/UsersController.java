package signal.minervini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import signal.minervini.entity.UserEntity;
import signal.minervini.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addNewUser(@RequestParam String userName,
                                             @RequestParam String password,
                                             @RequestParam String role,
                                             @RequestParam boolean active) {
        if (!StringUtils.hasText(userName)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter username");
        }
        if (!StringUtils.hasText(password)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter password");
        }
        if (!StringUtils.hasText(role)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter role");
        }
        if (ObjectUtils.isEmpty(active)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter active");
        }
        try {
            userService.addUser(userName.toUpperCase(), password, role, active);
        } catch (Exception e) {
            return new ResponseEntity<>("Add new user failed " + e.getMessage() + "\n" + e.getCause(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Add new user success");
    }

    @GetMapping("/remove")
    @ResponseBody
    public ResponseEntity<String> removeUser(@RequestParam String userName) {
        if (!StringUtils.hasText(userName)) {
            return ResponseEntity.badRequest().body("Invalid input for parameter username");
        }
        try {
            if (userService.deleteUser(userName.toUpperCase())) {

                return ResponseEntity.ok("Remove stock successes " + userName + " success");
            } else {
                return new ResponseEntity<>("Remove user failed", HttpStatus.EXPECTATION_FAILED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Remove user " + userName + " failed " + e.getMessage() + "//\n"
                    + e.getCause(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}
