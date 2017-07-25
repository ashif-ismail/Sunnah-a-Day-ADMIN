package me.ashif.sunnah.backend.repository;

import me.ashif.sunnah.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ashif on 17/7/17.
 * github.com/SheikhZayed
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);

    Page<User> findBy(Pageable pageable);

    Page<User> findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String nameLike,
                                                                                 String roleLike, Pageable pageable);
}
