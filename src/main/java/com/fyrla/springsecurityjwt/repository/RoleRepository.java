package com.fyrla.springsecurityjwt.repository;

import com.fyrla.springsecurityjwt.model.ERole;
import com.fyrla.springsecurityjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Krzysztof
 * @project spring-security-jwt
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
