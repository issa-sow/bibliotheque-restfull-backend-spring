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

import sn.isi.dao.ICategorieService;
import sn.isi.entities.Categorie;

@RestController
@RequestMapping("/rest/categorie/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategorieRestController {
	@Autowired
	ICategorieService categorieService;
	
	@GetMapping("/categories")
	public List<Categorie> getAllLivres() {
		return categorieService.getAllCategories();
	}
	
	@GetMapping("/categories/{code}")
	public Categorie searchCategorieById(@PathVariable String code) {
		return categorieService.getOneCategorie(code);
	}
	
	@PostMapping("/categories")
	public Categorie createNewCategorie(@RequestBody Categorie categorie) {
		return categorieService.addCategorie(categorie);
	}
	
	@PutMapping("/categories/{code}")
	public Categorie updateCategorie(@PathVariable String code, @RequestBody Categorie categorie) {
		categorie.setCode(code);
		return  categorieService.updateCategorie(code, categorie);
	}
	
	@DeleteMapping("/categories/{code}")
	public boolean removeCategorie(@PathVariable String code) {
		categorieService.removeCategorieByCode(code);
		return true;
	}
	
	@GetMapping("/searchCategorieByLabel")
	public List<Categorie> searchLivreByTitleOrAuthor(@RequestParam(name = "label") String label) {
		return categorieService.getCategorieByLabel(
				(new StringBuilder()).append("%").append(label).append("%").toString());
	}
}
