package by.epam.training.entity;

public enum RoleEnum {
    ADMIN("admin"),
    COURIER("courier"),
    CUSTOMER("customer");

    private String value;


    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String toEnumFormat(String name) {
        return name.toUpperCase();
    }

}

