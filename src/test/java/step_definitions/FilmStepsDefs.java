package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.FilmMapper;
import model.Film;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;

public class FilmStepsDefs {

    List<Film> filmsRecords ;

    @When("user requests all film records")
    public void userRequestsAllFilmRecords() {
        String query = "select * from film";
        filmsRecords = DBUtils.executeQuery(query, new FilmMapper());
    }

    @Then("user verify that there are {int} film records")
    public void userVerifyThatThereAreFilmRecords(int numberOfFilms) {
        Assertions.assertThat(filmsRecords.size()).isEqualTo(numberOfFilms);
    }

    @When("user requests replacement_cost in desc from film")
    public void userRequestsReplacement_costInDescFromFilm() {
        String query = "select replacement_cost  from film order by replacement_cost desc";
        filmsRecords = DBUtils.executeQuery(query, new FilmMapper());
    }

    @Then("user verify that all records displayed in order")
    public void userVerifyThatAllRecordsDisplayedInOrder() {
        for (int i = 0; i < filmsRecords.size()- 1; i++) {
           String record1 = filmsRecords.get(i).getRecords().get("replacement_cost").toString();
           String record2 = filmsRecords.get(i + 1).getRecords().get("replacement_cost").toString();
            Assert.assertTrue(Double.parseDouble(record1) >= Double.parseDouble(record2));
        }
    }

    @When("user request length between {int} and {int}")
    public void userRequestLengthBetweenAnd(int minValue, int maxValue) {
        String query = "select length from film where length >= " + minValue + " AND length <= " + maxValue;
        filmsRecords = DBUtils.executeQuery(query, new FilmMapper());
    }

    @Then("user verify that all of records as expected")
    public void userVerifyTahtAllOfRecordsAsExpected() {
        filmsRecords.forEach( record -> {
            int length = Integer.parseInt(record.getRecords().get("length").toString());
            Assert.assertTrue(70 <= length && length <= 130);
        });
    }
}
