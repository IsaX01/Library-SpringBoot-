package com.badiagroup.Library.repository;

import com.badiagroup.Library.model.loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loans_repository extends JpaRepository<loans, Integer> {
}
