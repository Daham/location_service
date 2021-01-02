package util;

import lombok.experimental.UtilityClass;

public final class ErrorConstants {

    private ErrorConstants() {

    }

    public static final String ERROR_SAVING_USER = "error.saving.user";
    public static final String ERROR_UPDATING_USER = "error.updating.user";
    public static final String ERROR_REMOVING_USER = "error.removing.user";
    public static final String USER_ALREADY_EXISTS = "user.already.exists";
    public static final String USER_NOT_FOUND = "user.not.found";

    public static final String GROUP_NOT_FOUND = "group.not.found";
    public static final String ERROR_SAVING_GROUP = "error.saving.group";
    public static final String GROUP_ALREADY_EXISTS = "group.already.exists";
    public static final String ERROR_UPDATING_GROUP = "error.updating.group";
    public static final String ERROR_REMOVING_GROUP = "error.removing.group";

    public static final String ROLE_NOT_FOUND = "role.not.found";
    public static final String ERROR_SAVING_ROLE = "error.saving.role";
    public static final String ROLE_ALREADY_EXISTS = "role.already.exists";
    public static final String ERROR_UPDATING_ROLE = "error.updating.role";
    public static final String ERROR_REMOVING_ROLE = "error.removing.role";
}
