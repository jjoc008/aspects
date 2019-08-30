package co.com.jjoc.aspects.services;


import co.com.jjoc.aspects.model.Answer;
import co.com.jjoc.aspects.model.Answer2;
import co.com.jjoc.aspects.model.Person;
import co.com.jjoc.aspects.model.Response;
import co.com.jjoc.aspects.services.api.PersonService;
import co.com.jjoc.aspects.utils.ApiUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service
public class InitService {

	@Value("${my.name}")
	private String myName;

	@Value("${my.nick-name}")
	private String myNickName;

	public void createAccount() throws IOException {

		Person person = new Person();
		person.setName(myName);
		person.setNickName(myNickName);

		PersonService personService = ApiUtils.getPersonService();

		Person personSaved = personService.savePost(person)
			.execute()
			.body();

		System.out.println("person saved: "+ personSaved);

	}

	public void sendExerciseOne(Response response) throws IOException {

		PersonService personService = ApiUtils.getPersonService();

		Answer answer = new Answer();
		answer.setNickName(myNickName);
		answer.setResponse(response);

		Boolean result = personService.sendAnswer1(answer)
			.execute()
			.body();

		System.out.println("answer 1 saved: "+ result);

	}

	public void sendExerciseTwo(String time) throws IOException {

		PersonService personService = ApiUtils.getPersonService();

		Answer2 answer = new Answer2();
		answer.setNickName(myNickName);
		answer.setResponse(time);

		Boolean result = personService.sendAnswer2(answer)
			.execute()
			.body();

		System.out.println("answer 2 saved: "+ result);

	}

}
