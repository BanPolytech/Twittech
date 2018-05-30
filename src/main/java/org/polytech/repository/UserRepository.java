package org.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.polytech.business.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
}