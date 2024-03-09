package mapppers;

import model.Staff;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper<Staff> {

    public Staff mapRow(ResultSet rs) throws SQLException {
        return new Staff(rs);
    }
}
