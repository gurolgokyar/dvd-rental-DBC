package mapppers;

import model.Payment;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {

    public Payment mapRow(ResultSet resultSet) throws SQLException{
        return new Payment(resultSet);
    }
}
