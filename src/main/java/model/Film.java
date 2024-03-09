package model;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Data
public class Film {
    private Map<String, Object> records = records = new HashMap<>();;

    public Film(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            records.put(metaData.getColumnName(i), resultSet.getObject(i));
        }
    }

}
