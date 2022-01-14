package sn.isi.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	@Column(length = 50)
	private String label;
	@OneToMany(mappedBy = "categorie")
	private Set<Livre> livres = new HashSet<Livre>();
	
	public Categorie() {
		
	}
	
	public Categorie(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
