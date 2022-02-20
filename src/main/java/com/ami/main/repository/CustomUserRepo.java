package com.ami.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ami.main.model.CustomUser;

@Repository
public interface CustomUserRepo extends JpaRepository<CustomUser, Integer> {
	//Optional<CustomUser> findByUserName(String userName);
	CustomUser findByUserName(String userName);
	
	@Query(value = "SELECT "
			+ 		"u.user_name AS userName, "
			+ 		"u.password AS password, "
			+ 		"u.is_active as isActive, "
			+ 		"r.role_name AS roleName "
			+ "FROM "
			+ 	"user u, "
			+ 	"roles r, "
			+ 	"user_roles ur "
			+ "WHERE "
			+ 	"u.id = ur.user_id AND "
			+	"r.id = ur.role_id AND "
			+ 	"u.user_name = :userName",nativeQuery = true)
	String [][] getUserDetailsByUserName(@Param("userName") String userName);

}
