package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public User findById(int id) {
        return em.find(User.class, id);
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }
}
