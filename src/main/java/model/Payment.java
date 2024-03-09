package model;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@Data
public class Payment {

    Map<String, Object> rows = new HashMap<>();

    public Payment(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            rows.put(metaData.getColumnName(i), rs.getObject(i));
        }
    }
}
