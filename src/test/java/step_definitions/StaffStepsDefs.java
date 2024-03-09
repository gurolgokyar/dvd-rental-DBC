package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.StaffMapper;
import model.Staff;
import org.assertj.core.api.Assertions;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class StaffStepsDefs {

    List<Staff> staffRecords = new ArrayList<>();
    @When("the user request for get all email address")
    public void theUserRequestForGetAllEmailAddress() {
        String query = "select email from Staff";
        staffRecords = DBUtils.executeQuery(query, new StaffMapper());
    }

    @Then("the user verify that all email address contains @ mark")
    public void theUserVerifyThatAllEmailAddressContainsMark() {
        staffRecords.forEach(record -> {
            Assertions.assertThat(record.getRecords().get("email").toString()).contains("@");
        });
    }
}
