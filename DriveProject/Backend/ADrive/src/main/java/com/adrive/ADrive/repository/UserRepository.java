package com.adrive.ADrive.repository;

import com.adrive.ADrive.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
   public Users findByUsername(String name);
}
