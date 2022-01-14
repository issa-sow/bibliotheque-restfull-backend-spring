package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Categorie;

public interface ICategorieService {
	List<Categorie> getAllCategories();
	Categorie getOneCategorie(String code);
	Categorie addCategorie(Categorie categorie);
	Categorie updateCategorie(String code, Categorie categorie);
	boolean removeCategorieByCode(String code);
	List<Categorie> getCategorieByLabel(String label);
}
