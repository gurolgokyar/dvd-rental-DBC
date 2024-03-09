package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.PaymentMapper;
import model.Payment;
import org.assertj.core.api.Assertions;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class PaymentStepsDefs {
    List<Payment> paymentRecords;
    @When("user requests for get each customer_id's count")
    public void userRequestsForGetEachCustomer_idSCount() {
        String query = "select customer_id, count(*) from payment group by customer_id order by customer_id";
        paymentRecords = DBUtils.executeQuery(query, new PaymentMapper());
    }


    @Then("user verify that number of customer_id equals count")
    public void userVerifyThatNumberOfEquals(Map<String, Integer> mapList) {
        int counter = 1;
        for (Payment record: paymentRecords) {
            Assertions.assertThat(record.getRows().get("customer_id")).isEqualTo(counter);
            Assertions.assertThat(Integer.parseInt(record.getRows().get("count").toString())).isEqualTo(mapList.get("" + counter++));
            if (counter == 6){
                break;
            }
        }
    }
}
