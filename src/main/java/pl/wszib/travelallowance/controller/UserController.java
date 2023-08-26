package pl.wszib.travelallowance.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wszib.travelallowance.model.UserModel;
import pl.wszib.travelallowance.services.UserService;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/users")
    public void saveUser(@RequestBody UserModel userModel) {

        userService.saveUser(userModel);
    }


}
