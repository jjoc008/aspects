package co.com.jjoc.aspects.utils;

import co.com.jjoc.aspects.config.RetrofitClient;
import co.com.jjoc.aspects.services.api.PersonService;

public class ApiUtils {

	private ApiUtils() {
		super();
	}

	public static final String BASE_URL = "http://localhost:8091/";

	public static PersonService getPersonService() {

		return RetrofitClient.getClient(BASE_URL).create(PersonService.class);
	}
}
