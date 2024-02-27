package es.codeurjc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index"; // Esto buscará un archivo llamado index.html en src/main/resources/templates
	}
}
