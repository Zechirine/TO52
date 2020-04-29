package com.to52;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.to52.dao.ClientRepository;
import com.to52.dao.CompteRepository;
import com.to52.dao.OperationRepository;
import com.to52.entities.Client;
import com.to52.entities.Compte;
import com.to52.entities.CompteCourant;
import com.to52.entities.CompteEpargne;
import com.to52.entities.Retrait;
import com.to52.entities.Versement;
import com.to52.metier.IBanqueMetier;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		//ApplicationContext ctx = 
		SpringApplication.run(MaBanqueApplication.class, args);
		//ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("NOUASSI", "znouassi@gmail.com"));
		Client c2 = clientRepository.save(new Client("MURIEL", "jmuriel@gmail.com"));
		
		Compte cp1 = compteRepository.save(
				new CompteCourant("c1", new Date(), 90000, c1, 6000));
		Compte cp2 = compteRepository.save(
				new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		operationRepository.save(new Versement(new Date(), 9000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp1));
		operationRepository.save(new Versement(new Date(), 2300, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));
		
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Versement(new Date(), 400, cp2));
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
		
		banqueMetier.verser("c1", 11111);
	}

}
