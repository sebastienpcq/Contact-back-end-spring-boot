package fr.sebdev;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.sebdev.dao.ContactRepository;
import fr.sebdev.entities.Contact;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository
				.save(new Contact("Picque", "Sebastien", df.parse("21/06/1995"), "seb.pcq@gmail.com", 06760441, "lol"));
		contactRepository
				.save(new Contact("Jon", "Sebastien", df.parse("21/06/1995"), "seb.pcq@gmail.com", 06760441, "lol"));
		contactRepository
				.save(new Contact("Jack", "Sebastien", df.parse("21/06/1995"), "seb.pcq@gmail.com", 06760441, "lol"));
		contactRepository.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});

	}

}
