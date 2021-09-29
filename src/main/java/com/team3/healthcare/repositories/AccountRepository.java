package com.team3.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team3.healthcare.entities.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query(value = "SELECT * FROM account a WHERE a.username = ?1", nativeQuery = true)
	public Account findByUsername(String username);
}
