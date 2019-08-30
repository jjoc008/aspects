package co.com.jjoc.aspects.services.api;

import co.com.jjoc.aspects.model.Answer;
import co.com.jjoc.aspects.model.Answer2;
import co.com.jjoc.aspects.model.Person;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PersonService {

	@GET("/person")
	Call<List<Person>> getPersons();

	@POST("/person")
	Call<Person> savePost(@Body Person person);

	@POST("/exercise1")
	Call<Boolean> sendAnswer1(@Body Answer answer);

	@POST("/exercise2")
	Call<Boolean> sendAnswer2(@Body Answer2 answer);

}
