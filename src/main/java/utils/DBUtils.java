package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;

public class DBUtils {

	private static final Logger logger = LogManager.getLogger(DBUtils.class);

	private static final String URL = ConfigManager.getProperty("db_URL");

	private static final String USER_NAME = ConfigManager.getProperty("db_username");

	private static final String PASSWORD = ConfigManager.getProperty("db_password");

	static {
		try {
			Class.forName("org.postgresql.Driver");
			logger.info("PostgreSql JDBC Driver uploaded!");
		}
		catch (ClassNotFoundException e) {
			logger.error("PostgreSql JDBC Driver not uploaded!");
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch (SQLException e) {
			logger.error("Database connection error!");
			throw new SQLException();
		}
	}

	public static <T> List<T> executeQuery(String query, RowMapper<T> rowMapper) {
		List<T> result = new ArrayList<>();
		try (Connection connection = getConnection();
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet));
			}

		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}











//	public static List<Map<String, Object>> executeQueryForMapList(String query) {
//		List<Map<String, Object>> result = new ArrayList<>();
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(query);
//				ResultSet resultSet = statement.executeQuery()) {
//
//			ResultSetMetaData metaData = resultSet.getMetaData();
//			while (resultSet.next()) {
//				Map<String, Object> row = new HashMap<>();
//				for (int i = 0; i < metaData.getColumnCount(); i++) {
//					row.put(metaData.getColumnName(i), resultSet.getObject(i));
//				}
//				result.add(row);
//			}
//		}
//		catch (SQLException e) {
//			logger.error("SQLException while getting date for executeQueryForMapList method from result!");
//		}
//
//		return result;
//	}
}
