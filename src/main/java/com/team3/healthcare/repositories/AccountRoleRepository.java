package com.team3.healthcare.repositories;

import com.team3.healthcare.entities.AccountRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
	@Query(value = "SELECT * FROM role r WHERE r.permission = ?1", nativeQuery = true)
	public AccountRole getAccountRoleByName(String name);
}
