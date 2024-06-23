package com.waycourier.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.service.PackageService;
import com.waycourier.app.service.UserService;
import com.waycourier.app.models.Location;
import com.waycourier.app.models.User;
import com.waycourier.app.repository.IUserRepository;
import com.waycourier.app.to.PackageRequestTO;

@SpringBootApplication
public class WaycourierApplication {

	@Autowired
	PackageService packageService;
	
	@Autowired
	IUserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(WaycourierApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			File file = new File("C:\\Users\\akash\\Documents\\code\\backend\\utils\\package_data.txt");
//			try {
//				Scanner scanner = new Scanner(new FileInputStream(file));
//				
//				while (scanner.hasNextLine()) {
//					String[] data = scanner.nextLine().split(" ");
//
//					String name = data[0];
//					Location src = new Location(Double.valueOf(data[1]), Double.valueOf(data[2]));
//					Location dest = new Location(Double.valueOf(data[3]), Double.valueOf(data[4]));
//					String username = data[5];
//
//					PackageRequestTO packageRequestTO = new PackageRequestTO(null, name, "NA", src, dest, username,
//							PackageStatus.CREATED, false);
//					
//					User user = userRepo.findByUsername(username);
//					if(user == null) {
//						user = new User(username, username);
//						userRepo.save(user);
//					}
//					
//					packageService.createPackage(packageRequestTO);
//				}
//
//				scanner.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			System.out.println("DONE");
//		};
//	}

}
