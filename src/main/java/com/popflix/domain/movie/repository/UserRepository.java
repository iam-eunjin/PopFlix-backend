package com.popflix.domain.movie.repository;

import com.popflix.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 회헌님 repo 만드시면 이 레포 삭제하고 옮길 예정
public interface UserRepository extends JpaRepository<User, Long> {
}
