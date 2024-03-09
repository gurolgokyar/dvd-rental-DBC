package mapppers;

import model.Rental;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalMapper implements RowMapper<Rental> {


    @Override
    public Rental mapRow(ResultSet rs) throws SQLException {
        return new Rental(rs);
    }
}
