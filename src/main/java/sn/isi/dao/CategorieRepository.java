package sn.isi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.isi.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, String> {

	/* chercher une categorie par son code */
	Categorie findByCode(String code);
	/*Chercher une catégorie par label */
	@Query("SELECT c FROM Categorie c WHERE c.label LIKE :label")
	List<Categorie> findCategorieByLabel(@Param("label") String label);
}
