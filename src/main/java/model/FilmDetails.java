package model;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Data
public class FilmDetails {

    Map<String, Object> filmDetailsRecords = new HashMap<>();

    public FilmDetails(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            filmDetailsRecords.put(metaData.getColumnName(i), rs.getObject(i));
        }
    }
}
