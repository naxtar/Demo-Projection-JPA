package com.datajpa.projections.rest.persistence.repository;

import com.datajpa.projections.rest.dto.UserDto;
import com.datajpa.projections.rest.dto.UserLoginDto;
import com.datajpa.projections.rest.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Class based projection
    UserLoginDto findByUsername(String username);

    @Query("select new com.datajpa.projections.rest.dto.UserDto" +
            "(u.name, u.username, u.groups.size) " +
            "from User u " +
            "where upper(u.username) like upper(?1)")
    UserDto findUserByUsername(String username);
}
