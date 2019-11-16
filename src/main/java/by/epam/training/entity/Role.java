package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

public enum Role {
    ADMIN(1),
    COURIER(2),
    CUSTOMER(3);

    private int code;

    private static final Map<Role, Integer> ROLE_INTEGER_MAP = new HashMap<>();
    private static final Map<String, Role> STRING_ROLE_MAP = new HashMap<>();

    static {
        for (Role role : values()) {
            ROLE_INTEGER_MAP.put(role, role.getCode());
            STRING_ROLE_MAP.put(role.name(), role);
        }
    }

    Role(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Integer getCodeByRole(Role role) {
        return ROLE_INTEGER_MAP.get(role);
    }


    public static Role getRoleByString(String name) {
        return STRING_ROLE_MAP.getOrDefault(name.toUpperCase(), CUSTOMER);
    }

}
