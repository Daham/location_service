package com.adamant.locationservice.controller;

import com.adamant.locationservice.dto.user_management.*;
import com.adamant.locationservice.entity.error_data.ErrorData;
import com.adamant.locationservice.entity.user_management.Group;
import com.adamant.locationservice.entity.user_management.Role;
import com.adamant.locationservice.entity.user_management.User;
import com.adamant.locationservice.service.UserManagementService;
import com.adamant.locationservice.service.impl.UserManagementServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.adamant.locationservice.util.ApiSpecConstants;
import com.adamant.locationservice.util.ModelUtility;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
public class UserManagementController {

    private final UserManagementService userManagementService;

    @Operation(
            summary = "List all users",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully listing all users",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for listing all users",
                                                    value = ApiSpecConstants.LIST_ALL_USERS_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/users")
    public ResponseEntity<UsersResponseDTO> listAllUsers(
            @Parameter(description = "Rows per page", example = "10")
            @RequestParam(name = "rowsPerPage") int rowsPerPage,

            @Parameter(description = "Search param")
            @RequestParam(name = "param", required = false) String param) {

        UsersResponseDTO usersResponseDTO = userManagementService.findAllUsers(rowsPerPage, param);

        return new ResponseEntity<>(usersResponseDTO, HttpStatus.OK);
    }


    @Operation(
            summary = "Create a user",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully creating a user",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserResponseDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for creating a user",
                                                    value = ApiSpecConstants.CREATE_USER_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PostMapping(value = "/users")
    public ResponseEntity<UserResponseDTO> createUser(
            @Parameter(
                    description = "User to add. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = UserCreateRequestDTO.class
                    ))
            @Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO) {

        User user = ModelUtility.mapDtoToEntity(userCreateRequestDTO, User.class);

        UserResponseDTO userResponseDTO = userManagementService.saveUser(user.getEmail(), user);

        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve a user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieving a user",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for retrieving a user",
                                                    value = ApiSpecConstants.RETRIEVE_USER_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDTO> retrieveUser(

            @Parameter(description = "User ID", example = "john@gmail.com")
            @PathVariable(name = "id") String id) {

        UserResponseDTO userResponseDTO = userManagementService.findUser(id);

        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Update a user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updating a user",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for updating a user",
                                                    value = ApiSpecConstants.UPDATE_USER_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @Parameter(description = "User ID", example = "1232134")
            @PathVariable(name = "id") String id,
            @Parameter(
                    description = "User details to update. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = UserUpdateRequestDTO.class
                    ))
            @Valid
            @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {

        User user = ModelUtility.mapDtoToEntity(userUpdateRequestDTO, User.class);

        UserResponseDTO userResponseDTO = userManagementService.updateUser(id, user);

        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a user",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Successfully deleting a user"
                    )
            }
    )
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "User ID", example = "1232134")
            @PathVariable(name = "id") String id
    ) {

        userManagementService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "List all groups",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully listing all groups",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for listing all groups",
                                                    value = ApiSpecConstants.LIST_ALL_GROUPS_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/groups")
    public ResponseEntity<GroupsResponseDTO> listAllGroups(
            @Parameter(description = "Rows per page", example = "10")
            @RequestParam(name = "rowsPerPage") int rowsPerPage,

            @Parameter(description = "Search param")
            @RequestParam(name = "param", required = false) String param) {

        GroupsResponseDTO groupsResponseDTO = userManagementService.findAllGroups(rowsPerPage, param);

        return new ResponseEntity<>(groupsResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Create a group",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully creating a group",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for creating a group",
                                                    value = ApiSpecConstants.CREATE_GROUP_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PostMapping(value = "/group")
    public ResponseEntity<GroupResponseDTO> createGroup(
            @Parameter(
                    description = "Group to add. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = GroupCreateRequestDTO.class
                    ))
            @Valid @RequestBody GroupCreateRequestDTO groupCreateRequestDTO) {

        Group group = ModelUtility.mapDtoToEntity(groupCreateRequestDTO, Group.class);

        GroupResponseDTO groupResponseDTO = userManagementService.saveGroup(group.getName(), group);

        return new ResponseEntity<>(groupResponseDTO, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve a group",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieving a group",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for retrieving a group",
                                                    value = ApiSpecConstants.RETRIEVE_GROUP_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/groups/{id}")
    public ResponseEntity<GroupResponseDTO> retrieveGroup(

            @Parameter(description = "Group ID", example = "12")
            @PathVariable(name = "id") String id) {

        GroupResponseDTO groupResponseDTO = userManagementService.findGroup(id);

        return new ResponseEntity<>(groupResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Update a group",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updating a group",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for updating a group",
                                                    value = ApiSpecConstants.UPDATE_GROUP_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PutMapping(value = "/groups/{id}")
    public ResponseEntity<GroupResponseDTO> updateGroup(
            @Parameter(description = "Group ID", example = "12")
            @PathVariable(name = "id") String id,
            @Parameter(
                    description = "Group details to update. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = GroupUpdateRequestDTO.class
                    ))
            @Valid
            @RequestBody GroupUpdateRequestDTO groupUpdateRequestDTO) {

        Group group = ModelUtility.mapDtoToEntity(groupUpdateRequestDTO, Group.class);

        GroupResponseDTO groupResponseDTO = userManagementService.updateGroup(id, group);

        return new ResponseEntity<>(groupResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a group",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleting a group"
                    )
            }
    )
    @DeleteMapping(value = "/groups/{id}")
    public ResponseEntity<Void> deleteGroup(
            @Parameter(description = "Group ID", example = "12")
            @PathVariable(name = "id") String id
    ) {

        userManagementService.removeGroup(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "List all roles",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully listing all roles",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for listing all roles",
                                                    value = ApiSpecConstants.LIST_ALL_ROLES_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/roles")
    public ResponseEntity<RolesResponseDTO> listAllRoles(
            @Parameter(description = "Rows per page", example = "10")
            @RequestParam(name = "rowsPerPage") int rowsPerPage,

            @Parameter(description = "Search param")
            @RequestParam(name = "param", required = false) String param) {

        RolesResponseDTO rolesResponseDTO = userManagementService.findAllRoles(rowsPerPage, param);

        return new ResponseEntity<>(rolesResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Create a role",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully creating a role",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for creating a role",
                                                    value = ApiSpecConstants.CREATE_ROLE_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PostMapping(value = "/roles")
    public ResponseEntity<RoleResponseDTO> createRole(
            @Parameter(
                    description = "Role to add. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = RoleCreateRequestDTO.class
                    ))
            @Valid @RequestBody RoleCreateRequestDTO roleCreateRequestDTO) {

        Role role = ModelUtility.mapDtoToEntity(roleCreateRequestDTO, Role.class);

        RoleResponseDTO rolesResponseDTO = userManagementService.saveRole(role.getName(), role);

        return new ResponseEntity<>(rolesResponseDTO, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve a role",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieving a role",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for retrieving a user",
                                                    value = ApiSpecConstants.RETRIEVE_ROLE_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @GetMapping(value = "/roles/{id}")
    public ResponseEntity<RoleResponseDTO> retrieveRole(

            @Parameter(description = "Role ID", example = "2")
            @PathVariable(name = "id") String id) {

        RoleResponseDTO roleResponseDTO = userManagementService.findRole(id);

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Update a role",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updating a role",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorData.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example success response for updating a role",
                                                    value = ApiSpecConstants.UPDATE_ROLE_SUCCESS_RESPONSE
                                            )}
                            ))
            }
    )
    @PutMapping(value = "/roles/{id}")
    public ResponseEntity<RoleResponseDTO> updateRole(
            @Parameter(description = "Role ID", example = "2")
            @PathVariable(name = "id") String id,
            @Parameter(
                    description = "Role details to update. Cannot null or empty.",
                    required = true,
                    schema = @Schema(
                            implementation = RoleUpdateRequestDTO.class
                    ))
            @Valid
            @RequestBody RoleUpdateRequestDTO roleUpdateRequestDTO) {

        Role role = ModelUtility.mapDtoToEntity(roleUpdateRequestDTO, Role.class);

        RoleResponseDTO roleResponseDTO = userManagementService.updateRole(id, role);

        return new ResponseEntity<>(roleResponseDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a role",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleting a role"
                    )
            }
    )
    @DeleteMapping(value = "/roles/{id}")
    public ResponseEntity<Void> deleteRole(
            @Parameter(description = "Role ID", example = "2")
            @PathVariable(name = "id") String id) {

        userManagementService.removeRole(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
