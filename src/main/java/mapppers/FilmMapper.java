package mapppers;

import model.Film;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {

    public Film mapRow(ResultSet resultSet) throws SQLException {
        return new Film(resultSet);
    }

}
