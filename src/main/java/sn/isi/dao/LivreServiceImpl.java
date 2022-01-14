package sn.isi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.isi.entities.Livre;

@Service("livreService")
public class LivreServiceImpl implements ILivreService {
	@Autowired
	LivreRepository livreRepository;
	
	@Override
	public List<Livre> getAllLivre() {
		// TODO Auto-generated method stub
		return livreRepository.findAll();
	}

	@Override
	public Livre getOneLivre(Long id) {
		// TODO Auto-generated method stub
		return livreRepository.findLivreById(id);
	}

	@Override
	public Livre addLivre(Livre livre) {
		return livreRepository.save(livre);
	}

	@Override
	public Livre updateLivre(Long id, Livre livre) {
		// TODO Auto-generated method stub
		livre.setId(id);
		return livreRepository.save(livre);
	}

	@Override
	public boolean removeLivre(Long id) {
		// TODO Auto-generated method stub
		livreRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Livre> searchLivreByTitleOrAuthor(String titleOrAuthor) {
		// TODO Auto-generated method stub
		return livreRepository.findLivreByTittleOrAuthor(titleOrAuthor);
	}

	@Override
	public List<Livre> searchLivreByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return livreRepository.findLivreByIsbn(isbn);
	}

}
