package es.codeurjc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CommentController {

	private List<Comment> comments = new ArrayList<>();

	public CommentController() {
		comments.add(new Comment("Pepe", "Vendo moto", "Barata, barata"));
		comments.add(new Comment("Juan", "Compro coche", "Pago bien"));
	}

	@GetMapping("/comment")
	public String showComments(Model model) {
		// Se calcula la cantidad de puntos de navegación
		int navigationDots = 4; // Por ejemplo, si hay 4 puntos de navegación
		List<Comment> limitedPosts = new ArrayList<>();

		// Se limitan los posts a la cantidad de puntos de navegación
		for (int i = 0; i < navigationDots && i < comments.size(); i++) {
			limitedPosts.add(comments.get(i));
		}

		// Se añade la lista limitada de posts al modelo
		model.addAttribute("comments", limitedPosts);
		return "index";
	}

	@PostMapping("/comments/new")
	public String addComment(@ModelAttribute Comment comment) {
		comments.add(comment);
		return "redirect:/";
	}

	@GetMapping("/comments/{numCom}")
	public String showComment(Model model, @PathVariable int numCom) {
		if (numCom > 0 && numCom <= comments.size()) {
			Comment comment = comments.get(numCom - 1);
			model.addAttribute("comment", comment);
			model.addAttribute("numCom", numCom);
			return "showCom";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/comments/{numCom}/delete")
	public String deleteComment(@PathVariable int numCom) {
		if (numCom > 0 && numCom <= comments.size()) {
			comments.remove(numCom - 1);
			return "redirect:/comments/deleted";
		} else {
			return "redirect:/error";
		}
	}
}