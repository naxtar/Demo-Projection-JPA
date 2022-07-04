package com.datajpa.projections.rest.persistence.repository;

import com.datajpa.projections.rest.persistence.model.Group;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

//    @EntityGraph(attributePaths = "users")
    Group findByName(String name);

//    @EntityGraph(attributePaths = "users")
    List<Group> findByUsers_UsernameLikeIgnoreCase(String username);
}
