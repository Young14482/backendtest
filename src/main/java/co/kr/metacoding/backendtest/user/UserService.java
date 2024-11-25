package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse.UserInfoDTO findUserById(int id) {
        User target = userRepository.findById(id).orElseThrow(() -> new Exception404("해당 유저id는 존재하지 않음"));
        return new UserResponse.UserInfoDTO(target);
    }

    @Transactional
    public UserResponse.UserInsertDTO insertUser(User user) {
        User inserted = userRepository.save(user);
        return new UserResponse.UserInsertDTO(inserted);
    }

    @Transactional
    public UserResponse.UserUpdatedDTO updateUser(int id, UserRequest.UserUpdateDTO userUpdateDTO) {
        User target = userRepository.findById(id).orElseThrow(() -> new Exception404("해당 유저id는 존재하지 않음"));
        target.update(userUpdateDTO.getName());
        return new UserResponse.UserUpdatedDTO(target);
    }
}
