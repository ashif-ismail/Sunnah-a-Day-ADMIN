package me.ashif.sunnah.backend.repository;

import me.ashif.sunnah.backend.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ashif on 17/7/17.
 * github.com/SheikhZayed
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
