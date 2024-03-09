package step_definitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import utils.DBUtils;

import java.sql.SQLException;

public class CommonStepsDefs {
    public static Logger logger = LogManager.getLogger(CommonStepsDefs.class);
    @Given("the database is accessible")
    public void theDatabaseIsAccessible() {
        try {
            Assertions.assertThat(DBUtils.getConnection()).isNotNull();
            logger.info("Database connectivity is success!");
        }
        catch (SQLException e) {
            logger.error("Database connectivity is not success!");
            throw new RuntimeException(e);
        }
    }
}
