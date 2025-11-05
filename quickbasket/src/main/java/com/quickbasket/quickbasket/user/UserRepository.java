package com.quickbasket.quickbasket.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    public Page<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstName, String lastName, String email, Pageable pageable
    );

    public Page<User> findByRoles_NameAndEmailContainingIgnoreCase(String role, String email, Pageable pageable);

    @Query("SELECT u FROM User u JOIN u.roles r " +
            "WHERE (:search IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "   OR LOWER(u.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "   OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "AND (:role IS NULL OR r.name = :role)")
    public Page<User> findByFilters(@Param("search") String search,
                             @Param("role") String role,
                             Pageable pageable);

    // 🔍 Search + Filter by role + status
    @Query("SELECT u FROM User u JOIN u.roles r " +
            "WHERE r.name = :role " +
            "AND u.status = :status " +
            "AND (:search IS NULL OR LOWER(u.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "     OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "     OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%')))")
    public Page<User> findByRoleAndStatusAndSearch(String role, Integer status, String search, Pageable pageable);


    // 🔍 Search + Filter by role name
    @Query("SELECT u FROM User u JOIN u.roles r " +
            "WHERE r.name = :role " +
            "AND (:search IS NULL OR LOWER(u.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "     OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "     OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%')))")
    public Page<User> findByRoleAndSearch(String role, String search, Pageable pageable);

    // 🔍 Filter by role name
    @Query("SELECT u FROM User u JOIN u.roles r " +
            "WHERE r.name = :role ")
    public Page<User> findByRole(String role, Pageable pageable);

    public Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE u.id = :id AND r.name = 'ROLE_AGENT'")
    Optional<User> findAgentById(@Param("id") String id);
}
