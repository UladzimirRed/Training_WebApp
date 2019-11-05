package by.epam.training.dao;

import by.epam.training.entity.Entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public interface BaseDao<T extends Entity> {
    Logger logger = LogManager.getLogger(BaseDao.class);

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Couldn't close statement: " + e.getMessage());
        }
    }
}
