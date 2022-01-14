package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Livre;

public interface ILivreService {
	List<Livre> getAllLivre();
	Livre getOneLivre(Long id);
	Livre addLivre(Livre livre);
	Livre updateLivre(Long id, Livre livre);
	boolean removeLivre(Long id);
	List<Livre> searchLivreByTitleOrAuthor(String titleOrAuthor);
	List<Livre> searchLivreByIsbn(String isbn);
}
