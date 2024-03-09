package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mapppers.FilmDetailsMapper;
import model.FilmDetails;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import utils.DBUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmDetalsStepsDefs {

    List<FilmDetails> records ;
    @When("the user request film details")
    public void theUserRequestFilmDetails() {
        String query = "select title, description, release_year,category.name as category, String_agg(concat" +
                "(first_name, ' ', last_name), ', ') as actor_list " +
                "from film " +
                "inner join film_actor " +
                "on film.film_id = film_actor.film_id " +
                "inner join actor " +
                "on film_actor.actor_id = actor.actor_id " +
                "inner join film_category " +
                "on film.film_id = film_category.film_id " +
                "inner join category " +
                "on film_category.category_id = category.category_id " +
                "group by title, description,release_year, category.name";

        records = DBUtils.executeQuery(query, new FilmDetailsMapper());
    }

    @Then("the user verify that titles are not dublicated")
    public void theUserVerifyThatTitlesAreNotDublicated() {
        Set<FilmDetails> uniqueTitles = new HashSet<>();
        records.forEach(record -> {
            Assert.assertFalse(uniqueTitles.contains(record));
            uniqueTitles.add(record);
        });
    }

    @And("the user verify that all release years are equal to {int}")
    public void theUserVerifyThatAllReleaseYearsAreEqualTo(int releaseYear) {
        records.forEach(record -> {
         Assertions.assertThat(Integer.parseInt( record.getFilmDetailsRecords().get("release_year").toString())).isEqualTo(releaseYear);
        });
    }

    @And("the user verify that all categories are in the array below:")
    public void theUserVerifyThatAllCategoriesAreInTheArrayBelow(List<String> categories) {
        records.forEach(record -> {
           categories.contains( record.getFilmDetailsRecords().get("category").toString());
        });
    }
}
