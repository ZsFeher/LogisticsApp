package hu.cubix.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.logistics.service.AddressService;
import hu.cubix.logistics.service.InitDbService;

@SpringBootApplication
public class LogisticsApplication implements CommandLineRunner {

	@Autowired
	AddressService addressService;

	@Autowired
	InitDbService initDbService;

	public static void main(String[] args) {
		SpringApplication.run(LogisticsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting logistics app");
		initDbService.clearDB();
		initDbService.insertTestData();
		System.out.println(addressService.getAll());
	}

}
