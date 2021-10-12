package com.team3.healthcare.repositories;

import com.team3.healthcare.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query(value = "SELECT * FROM account a WHERE a.username = ?1", nativeQuery = true)
	public Account findByUsername(String username);

	@Modifying
	@Query(value = "UPDATE account a SET a.password = ?1 where a.username = ?2", nativeQuery = true)
	public void resetAccountPassword(String password, String username);
}
