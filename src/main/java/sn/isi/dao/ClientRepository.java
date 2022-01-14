package sn.isi.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.isi.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	/* chercher un client par son identifiant */
	Client findClientById(Long id);
	/* effectuer une reque jpql */
	@Query("SELECT c FROM Client c WHERE c.nom LIKE :nom")
	public Page<Client> findClientsPerNom(@Param("nom") String nom, Pageable pageable);
	/* Chercher un client par son mail */
	@Query("SELECT c FROM Client c WHERE c.email LIKE :email")
	public List<Client> findClientByEmail(@Param("email") String email);
}
