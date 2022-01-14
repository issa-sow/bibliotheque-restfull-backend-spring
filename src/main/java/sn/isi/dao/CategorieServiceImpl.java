package sn.isi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.isi.entities.Categorie;

@Service("CategorieService")
public class CategorieServiceImpl implements ICategorieService {
	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getOneCategorie(String code) {
		// TODO Auto-generated method stub
		return categorieRepository.findByCode(code);
	}

	@Override
	public Categorie addCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public Categorie updateCategorie(String code, Categorie categorie) {
		// TODO Auto-generated method stub
		categorie.setCode(code);
		return categorieRepository.save(categorie);
	}

	@Override
	public boolean removeCategorieByCode(String code) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(code);
		return true;
	}

	@Override
	public List<Categorie> getCategorieByLabel(String label) {
		// TODO Auto-generated method stub
		return categorieRepository.findCategorieByLabel(label);
	}
	

}
