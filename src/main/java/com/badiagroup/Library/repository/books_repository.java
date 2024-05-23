package com.badiagroup.Library.repository;

import com.badiagroup.Library.model.books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface books_repository extends JpaRepository<books, Integer> {
}
