package model;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Data
public class Staff {

    Map<String, Object> records = new HashMap<>();

    public Staff(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            records.put(metaData.getColumnName(i), rs.getObject(i));
        }
    }
}
