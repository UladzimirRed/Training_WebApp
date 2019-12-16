package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Role type.
 */
public enum RoleType {
    /**
     * Admin role type.
     */
    ADMIN(1),
    /**
     * Courier role type.
     */
    COURIER(2),
    /**
     * Customer role type.
     */
    CUSTOMER(3);

    private int code;

    private static final Map<RoleType, Integer> ROLE_INTEGER_MAP = new HashMap<>();
    private static final Map<String, RoleType> STRING_ROLE_MAP = new HashMap<>();

    static {
        for (RoleType role : values()) {
            ROLE_INTEGER_MAP.put(role, role.getCode());
            STRING_ROLE_MAP.put(role.name(), role);
        }
    }

    RoleType(int code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets code by role.
     *
     * @param role the role
     * @return the code by role
     */
    public static Integer getCodeByRole(RoleType role) {
        return ROLE_INTEGER_MAP.get(role);
    }


    /**
     * Gets role by string.
     *
     * @param name the name
     * @return the role by string
     */
    public static RoleType getRoleByString(String name) {
        return STRING_ROLE_MAP.getOrDefault(name.toUpperCase(), CUSTOMER);
    }

}
