package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserResponse.UserInfoDTO getUser(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public UserResponse.UserInsertDTO insertUser() {
        User user = new User();
        UserResponse.UserInsertDTO insertUser = userService.insertUser(user);
        return insertUser;
    }


}
