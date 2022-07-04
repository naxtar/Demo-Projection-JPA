package com.datajpa.projections.rest.dto;

import com.datajpa.projections.rest.persistence.model.Group;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 2543825992710118788L;

    private final String name;
    private final String username;
    private final int totalGroups;

    public UserDto(String name, String username, int groups) {
        this.name = name;
        this.username = username;
        this.totalGroups = groups;
    }

    @Data
    public static class GroupDto implements Serializable {

        private static final long serialVersionUID = 2139482674271960538L;

        private final String name;
        private final String keyword;
    }
}
