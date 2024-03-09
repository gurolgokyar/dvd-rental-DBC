package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.RentalMapper;
import model.Rental;
import org.junit.Assert;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class RentalStepsDefs {

    List<Rental> records;
    @When("the user requests for get all rental_id")
    public void theUserRequestsForGetAllRental_id() {
        String query = "select rental_id from rental";
        records = DBUtils.executeQuery(query, new RentalMapper());
    }

    @Then("the user verify that rental_ids are unique")
    public void theUserVerifyThatRental_idsAreUnique() {
        List<Rental> uniqueRental_ids = new ArrayList<>();
        records.forEach(record -> {
            Assert.assertFalse(uniqueRental_ids.contains(record));
            uniqueRental_ids.add(record);
        });
    }
}
