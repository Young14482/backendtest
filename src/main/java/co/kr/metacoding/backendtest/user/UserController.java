package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest._core.error.ex.Exception400;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
