package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Transport.
 */
public enum Transport {
    /**
     * Truck transport.
     */
    TRUCK(1),
    /**
     * Car transport.
     */
    CAR(2),
    /**
     * None transport.
     */
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

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets code by transport.
     *
     * @param transport the transport
     * @return the code by transport
     */
    public static Integer getCodeByTransport(Transport transport) {
        return TRANSPORT_INTEGER_MAP.get(transport);
    }

    /**
     * Gets transport by string.
     *
     * @param name the name
     * @return the transport by string
     */
    public static Transport getTransportByString(String name) {
        return name == null ? null : STRING_TRANSPORT_MAP.get(name.toUpperCase());
    }

}
