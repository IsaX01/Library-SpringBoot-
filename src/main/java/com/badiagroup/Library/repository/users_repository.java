package com.badiagroup.Library.repository;

import com.badiagroup.Library.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface users_repository extends JpaRepository<users, Long> {
    users findByEmail(String email);
}
