package com.springbootrestapi.repository;

import com.springbootrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("Select u from User u where u.email = ?1")
    User findByEmail(String email);
}
