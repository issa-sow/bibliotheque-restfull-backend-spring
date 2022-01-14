package sn.isi.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sn.isi.entities.Client;

public interface IClientService {
	List<Client> getAllClients();
	Client getOneClient(Long id);
	Client addClient(Client client);
	Client updateClient(Long id, Client client);
	boolean removeClient(Long id);
	Page<Client> searchClientsByNom(String nom, Pageable pageable);
	List<Client> searchClientByEmail(String email);
}
