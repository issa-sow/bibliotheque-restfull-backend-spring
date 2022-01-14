package sn.isi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.isi.dao.ILivreService;
import sn.isi.entities.Livre;

@RestController
@RequestMapping("/rest/livre/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LivreRestController {
	@Autowired
	ILivreService livreService;
	
	@GetMapping("/livres")
	public List<Livre> getAllLivres() {
		return livreService.getAllLivre();
	}
	
	@GetMapping("/livres/{id}")
	public Livre searchLivreById(@PathVariable Long id) {
		return livreService.getOneLivre(id);
	}
	
	@PostMapping("/livres")
	public Livre createNewLivre(@RequestBody Livre livre) {
		return livreService.addLivre(livre);
	}
	
	@PutMapping("/livres/{id}")
	public Livre updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
		livre.setId(id);
		return  livreService.updateLivre(id, livre);
	}
	
	@DeleteMapping("/livres/{id}")
	public boolean removeLivre(@PathVariable long id) {
		livreService.removeLivre(id);
		return true;
	}
	
	@GetMapping("/searchLivreByTitleOrAuthor")
	public List<Livre> searchLivreByTitleOrAuthor(@RequestParam(name = "titleOrAuthor") String titleOrAuthor) {
		return livreService.searchLivreByTitleOrAuthor(
				(new StringBuilder()).append("%").append(titleOrAuthor).append("%").toString());
	}
	
	@GetMapping("/searchLivreByIsbn")
	public List<Livre> searchLivreByIsbn(@RequestParam(name = "isbn") String isbn) {
		return livreService.searchLivreByIsbn(
				(new StringBuilder().append("%").append(isbn).append("%").toString()));
	}
}
