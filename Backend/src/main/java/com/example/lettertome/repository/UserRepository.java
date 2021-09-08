package com.example.lettertome.repository;

import com.example.lettertome.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);
    Boolean existsById(String id);

    Optional<User> findByUserIdx(Long number);
}
