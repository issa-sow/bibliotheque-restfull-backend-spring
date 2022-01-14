package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LIVRES")
public class Livre implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String title;
	@Column(length = 50)
	private String isbn;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private int nbreExemplaires;
	@Column(length = 50)
	private String auteur;
	@ManyToOne
	private Categorie categorie;
	/*private List<Pret> prets = new ArrayList<Pret>(); */
	
	
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livre(String title, String isbn, Date dateCreation, int nbreExemplaires, String auteur, Categorie categorie) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.dateCreation = dateCreation;
		this.nbreExemplaires = nbreExemplaires;
		this.auteur = auteur;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getNbreExemplaires() {
		return nbreExemplaires;
	}
	public void setNbreExemplaires(int nbreExemplaires) {
		this.nbreExemplaires = nbreExemplaires;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/*public List<Pret> getPrets() {
		return prets;
	}
	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	} */
	
	
}
