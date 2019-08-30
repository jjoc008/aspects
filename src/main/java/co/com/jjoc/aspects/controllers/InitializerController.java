package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.services.InitService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitializerController {

	@GetMapping("/iniciar")
	public String iniciar() throws IOException {

		return "Iniciaste";

	}


}
