package com.adamant.locationservice.service;

import com.adamant.locationservice.dto.user_management.*;
import com.adamant.locationservice.entity.user_management.Group;
import com.adamant.locationservice.entity.user_management.Role;
import com.adamant.locationservice.entity.user_management.User;


public interface UserManagementService {

    UserResponseDTO findUser(String id);

    UsersResponseDTO findAllUsers(int rowsPerPage, String param);

    UserResponseDTO saveUser(String id, User user);

    UserResponseDTO updateUser(String id, User user);

    void removeUser(String id);

    GroupResponseDTO findGroup(String id);

    GroupsResponseDTO findAllGroups(int rowsPerPage, String param);

    GroupResponseDTO saveGroup(String id, Group group);

    GroupResponseDTO updateGroup(String id, Group group);

    void removeGroup(String id);

    RoleResponseDTO findRole(String id);

    RolesResponseDTO findAllRoles(int rowsPerPage, String param);

    RoleResponseDTO saveRole(String id, Role role);

    RoleResponseDTO updateRole(String id, Role role);

    void removeRole(String id);
}
