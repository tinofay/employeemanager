package com.RepoTest.RepoTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee,Long> {
    Optional<FullTimeEmployee> findByEmail(String email);
}
