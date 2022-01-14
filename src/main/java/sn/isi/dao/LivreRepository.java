package sn.isi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.isi.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
	
	/* chercher un livre par son id */
	Livre findLivreById(Long id);
	/*Chercher un livre par son isbn */
	@Query("SELECT l FROM Livre l WHERE l.isbn LIKE :isbn")
	List<Livre> findLivreByIsbn(@Param("isbn") String isbn);
	/*Chercher un livre par son titre ou par son auteur */
	@Query("SELECT l FROM Livre l WHERE l.title LIKE :titleOrAuthor OR l.auteur LIKE :titleOrAuthor")
	List<Livre> findLivreByTittleOrAuthor(@Param("titleOrAuthor") String titleOrAuthor); 

}
