package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse.UserInfoDTO findUserById(int id) {
        User target = userRepository.findById(id);
        return new UserResponse.UserInfoDTO(target);
    }

    @Transactional
    public UserResponse.UserInsertDTO insertUser(User user) {
        User inserted = userRepository.insert(user);
        return new UserResponse.UserInsertDTO(inserted);
    }
}
