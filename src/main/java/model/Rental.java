package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Rental {

    private Map<String, Object> records = new HashMap<>();

    public Rental(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            records.put(metaData.getColumnName(i), rs.getObject(i));
        }
    }
}
