package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

public enum Transport {
    TRUCK(1),
    CAR(2),
    NONE(3);
    Transport(Integer code) {
        this.code = code;
    }

    private static final Map<Transport, Integer> TRANSPORT_INTEGER_MAP = new HashMap<>();
    private static final Map<String, Transport> STRING_TRANSPORT_MAP = new HashMap<>();

    private Integer code;

    static {
        for (Transport transport : values()) {
            TRANSPORT_INTEGER_MAP.put(transport, transport.getCode());
            STRING_TRANSPORT_MAP.put(transport.name(), transport);
        }
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCodeByTransport(Transport transport) {
        return TRANSPORT_INTEGER_MAP.get(transport);
    }

    public static Transport getTransportByString(String name) {
        return name == null ? null: STRING_TRANSPORT_MAP.get(name.toUpperCase());
    }

}
