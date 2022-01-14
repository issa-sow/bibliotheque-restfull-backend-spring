package sn.isi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.isi.dao.IClientService;
import sn.isi.entities.Client;

@RestController
@RequestMapping("/rest/client/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {
	@Autowired
	IClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping("/clients/{id}")
	public Client searchClientById(@PathVariable Long id) {
		return clientService.getOneClient(id);
	}

	@PostMapping("/clients")
	public Client createNewClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}
	
	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
		return clientService.updateClient(id, client);
	}
	
	@DeleteMapping("/clients/{id}")
	public boolean removeClient(@PathVariable Long id) {
		clientService.removeClient(id);
		return true;
	}
	
	@GetMapping("/searchClientNom")
	public Page<Client> searchClientsByNom(
			@RequestParam(name = "nom") String nom,
			@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		
		return clientService.searchClientsByNom(
				(new StringBuilder()).append("%").append(nom).append("%").toString(),
				PageRequest.of(page, size));
	}
	
	@GetMapping("/searchClientEmail")
	public List<Client> searchClientsByEmail(@RequestParam(name = "email") String email) {
		return clientService.searchClientByEmail(
				(new StringBuilder()).append("%").append(email).append("%").toString());
	}
	
}
