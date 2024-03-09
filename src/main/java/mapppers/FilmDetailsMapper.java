package mapppers;

import model.Film;
import model.FilmDetails;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDetailsMapper implements RowMapper<FilmDetails> {

    public FilmDetails mapRow(ResultSet rs) throws SQLException {
        return new FilmDetails(rs);
    }
}
