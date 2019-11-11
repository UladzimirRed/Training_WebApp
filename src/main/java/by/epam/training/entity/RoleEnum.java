package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
    ADMIN(0),
    COURIER(1),
    CUSTOMER(2);

    private int code;

    private static final Map<RoleEnum, Integer> roleCodeEnum = new HashMap<>();
    private static final Map<Integer, RoleEnum> codeRoleEnum = new HashMap<>();
    private static final Map<String, RoleEnum> roleStringEnumMap = new HashMap<>();

    static {
        for (RoleEnum roleEnum: values()) {
            roleCodeEnum.put(roleEnum, roleEnum.getCode());
            codeRoleEnum.put(roleEnum.getCode(), roleEnum);
            roleStringEnumMap.put(roleEnum.name(), roleEnum);
        }
    }

    RoleEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RoleEnum getRoleByCode(Integer code) {
        return codeRoleEnum.get(code);
    }

    public static Integer getCodeByRole(RoleEnum roleEnum) {
        return roleCodeEnum.get(roleEnum);
    }


    public static RoleEnum getRoleByString(String name) {
        return roleStringEnumMap.getOrDefault(name.toUpperCase(), CUSTOMER);
    }

}
