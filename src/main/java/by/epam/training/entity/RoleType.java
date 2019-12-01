package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    ADMIN(1),
    COURIER(2),
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

    public int getCode() {
        return code;
    }

    public static Integer getCodeByRole(RoleType role) {
        return ROLE_INTEGER_MAP.get(role);
    }


    public static RoleType getRoleByString(String name) {
        return STRING_ROLE_MAP.getOrDefault(name.toUpperCase(), CUSTOMER);
    }

}
