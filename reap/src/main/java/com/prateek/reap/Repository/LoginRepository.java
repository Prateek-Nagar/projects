package com.prateek.reap.Repository;

import com.prateek.reap.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
    Optional<User> findById(int userId);
   /* User findByToken(String resetToken);*/
}