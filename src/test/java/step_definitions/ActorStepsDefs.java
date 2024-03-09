package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.ActorMapper;
import model.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import utils.DBUtils;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActorStepsDefs {

    List<Actor> actorList ;

    List<Map<String, Object>> mapList ;

    Timestamp timestamp;
    public static Logger logger = LogManager.getLogger(ActorStepsDefs.class);
    @When("I request all actor records")
    public void iRequestAllActorRecords() {
        String query = "select * from actor";
        actorList = DBUtils.executeQuery(query, new ActorMapper());
    }

    @Then("I should receive a list of all actors")
    public void iShouldReceiveAListOfAllActors() {
        Assertions.assertThat(actorList.size()).isEqualTo(200);
    }

    @When("I request the actor record with ID {}")
    public void iRequestTheActorRecordWithID(String actor_id) {
        String query = "select * from actor where actor_id = " + actor_id;
        actorList = DBUtils.executeQuery(query, new ActorMapper());
    }

    @Then("I should receive the actor record with first name {string} and last name {string}")
    public void iShouldReceiveTheActorRecordWithFirstNameAndLastName(String first_name, String last_name) {
        Assertions.assertThat(first_name).isEqualTo(actorList.get(0).getFirst_name());
        Assertions.assertThat(last_name).isEqualTo(actorList.get(0).getLast_name());
    }

    @When("I check the last update timestamp for any actor record")
    public void iCheckTheLastUpdateTimestampForAnyActorRecord() {
        String query = "SELECT MAX(last_update) FROM actor";
        //mapList = DBUtils.executeQueryForMapList(query);
        timestamp = DBUtils.executeQuery(query, rs -> rs.getTimestamp("last_update")).get(0);
    }

    @Then("the last update timestamp should be more recent than {string}")
    public void theLastUpdateTimestampShouldBeMoreRecentThan(String timeStamp1) {
        Timestamp mostOldDate = Timestamp.valueOf(timeStamp1) ;
        Assertions.assertThat(timestamp).isAfter(mostOldDate);
    }
}
