package com.lecoded.secureBankSystem.repository;

import com.lecoded.secureBankSystem.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    // RoleEntity findByType(Roles title);
    @Query(value = "SELECT * FROM role r where r.title= : title",nativeQuery = true)
    Optional<RoleEntity> findRoleEntityByTitle(String title);
}