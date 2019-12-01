package by.epam.training.connection;

public class DataBaseInfo {
    // FIXME: 01.12.2019 REPLACE TO PROPERTIES
    public static final String USER = "root";
    public static final String PASSWORD = "1256";
    public static final String URL = "jdbc:mysql://localhost:3306/my_courier_schema?" +
            "autoReconnect=true&" +
            "useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "allowPublicKeyRetrieval=true&" +
            "serverTimezone=UTC&" +
            "characterEncoding=utf8";
}