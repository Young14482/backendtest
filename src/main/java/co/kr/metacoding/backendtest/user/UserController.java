package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserResponse.UserInfoDTO getUser(@PathVariable Integer id) {
        return userService.findUserById(id);

    }

    @PostMapping("/users")
    public UserResponse.UserInsertDTO insertUser() {
        User user = new User();
        UserResponse.UserInsertDTO insertUser = userService.insertUser(user);
        return insertUser;
    }

    @PutMapping("/users/{id}")
    public UserResponse.UserUpdatedDTO updateUser(@PathVariable int id , @RequestBody UserRequest.UserUpdateDTO userUpdateDTO) {
        UserResponse.UserUpdatedDTO userUpdatedDTO = userService.updateUser(id, userUpdateDTO);
        return userUpdatedDTO;
    }
}
