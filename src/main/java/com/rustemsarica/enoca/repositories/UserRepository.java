package com.rustemsarica.enoca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rustemsarica.enoca.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	@Query( value="select * from users where id in :ids", nativeQuery = true )
	List<User> findByUserIdIsIn(@Param("ids") List<Long> ids);

	List<User> findAllByUsernameContaining(String keyword);

	@Query( value="select * from users where id not in :excepts limit :limit", nativeQuery = true )
	List<User> getRandomUsersWithExceptsByLimit(int limit, List<Long> excepts);
	
	@Query( value="select * from users limit :limit", nativeQuery = true )
	List<User> getRandomUsersByLimit(int limit);
}
