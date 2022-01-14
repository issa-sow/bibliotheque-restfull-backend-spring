package sn.isi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.isi.dao.ICategorieService;
import sn.isi.dao.IClientService;
import sn.isi.entities.Categorie;
import sn.isi.entities.Client;

@SpringBootApplication
public class BibliothequeRestFullApplication implements CommandLineRunner {
	@Autowired
	IClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeRestFullApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		///System.out.println(clientService.removeCategorieByCode("CAT-1"));
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		clientService.addClient(new Client("SOW", "Issa", "Etudiant", "Escale/Thies", "issasow@gmail.com", df.parse("15/11/2021")));
		clientService.addClient(new Client("SOW", "Souleymane", "Bébé", "Escale/Thies", "souleymane@gmail.com", df.parse("15/11/2021")));
		clientService.addClient(new Client("NDIAYE", "Fatou", "Eleve", "Ouakam/Dakar", "fatou@gmail.com", df.parse("15/11/2021")));
		clientService.getAllClients().forEach(c -> {
			System.out.println("CODE: " + c.getNom() + " ---- " + c.getPrenom());
		}); */
	}

}
