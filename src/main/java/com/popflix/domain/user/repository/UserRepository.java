package com.popflix.domain.user.repository;

import com.popflix.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findBySocialId(String socialId);

    Optional<User> findByNickname(String nickname);
}