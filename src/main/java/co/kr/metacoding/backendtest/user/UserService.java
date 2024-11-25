package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse.UserInfoDTO findUserById(int id) {
        User target = userRepository.findById(id);
        return new UserResponse.UserInfoDTO(target);
    }
}
