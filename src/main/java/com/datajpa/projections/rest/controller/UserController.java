package com.datajpa.projections.rest.controller;

import com.datajpa.projections.rest.dto.UserDto;
import com.datajpa.projections.rest.dto.UserLoginDto;
import com.datajpa.projections.rest.persistence.model.Group;
import com.datajpa.projections.rest.persistence.model.User;
import com.datajpa.projections.rest.persistence.repository.GroupRepository;
import com.datajpa.projections.rest.persistence.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @NonNull
    private UserRepository userRepository;

    @GetMapping("/use-login-dto")
    public ResponseEntity<UserLoginDto> authenticate() {
        UserLoginDto allowedUser = userRepository.findByUsername("admin");
        return ResponseEntity.ok(allowedUser);
    }

    @GetMapping("/use-nested-dto")
    public ResponseEntity<List<User>> authenticateNested() {
        List<User> allowedUser = userRepository.findAll();
        return ResponseEntity.ok(allowedUser);
    }

    @NonNull
    private GroupRepository groupRepository;

    @GetMapping("/getgroupbyuser")
    public ResponseEntity<Group> getGroupByUser() {
        Group group = groupRepository.findByName("Naxtar Club");
        return ResponseEntity.ok(group);
    }

    @GetMapping("/getgrouplist")
    public ResponseEntity<List<Group>> getGroupList() {
        List<Group> group = groupRepository.findByUsers_UsernameLikeIgnoreCase("denirossi");
        return ResponseEntity.ok(group);
    }

    @GetMapping
    public ResponseEntity<UserDto> getUserByUsername(@RequestParam String username) {
        UserDto user = userRepository.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<Set<Group>> getGroupListByUserId(@NonNull @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(user.getGroups());
    }
}
