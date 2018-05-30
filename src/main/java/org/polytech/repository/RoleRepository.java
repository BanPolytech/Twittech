package org.polytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.polytech.business.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);

}