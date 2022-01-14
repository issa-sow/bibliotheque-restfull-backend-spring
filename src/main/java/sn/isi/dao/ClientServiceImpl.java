package sn.isi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sn.isi.entities.Client;

@Service("clientService")
public class ClientServiceImpl implements IClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getOneClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findClientById(id);
	}

	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Long id, Client client) {
		// TODO Auto-generated method stub
		client.setId(id);
		return clientRepository.save(client);
	}

	@Override
	public boolean removeClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
		return true;
	}

	@Override
	public Page<Client> searchClientsByNom(String nom, Pageable pageable) {
		// TODO Auto-generated method stub
		return clientRepository.findClientsPerNom(nom, pageable);
	}

	@Override
	public List<Client> searchClientByEmail(String email) {
		// TODO Auto-generated method stub
		return clientRepository.findClientByEmail(email);
	}

}
