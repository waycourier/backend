package com.waycourier.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.waycourier.app.service.PackageService;
import com.waycourier.app.to.Location;
import com.waycourier.app.to.PackageRequestTO;

@SpringBootApplication
public class WaycourierApplication {

	@Autowired
	PackageService packageService;

	public static void main(String[] args) {
		SpringApplication.run(WaycourierApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner() {
	// 	return args -> {
	// 		File file = new File("/workspaces/codespaces-blank/backend/package_data.txt");
	// 		try {
	// 			Scanner scanner = new Scanner(file);

	// 			while (scanner.hasNextLine()) {
	// 				String[] data = scanner.nextLine().split(" ");

	// 				Location loc = new Location(Double.valueOf(data[2]), Double.valueOf(data[3]));
	// 				String packageName = String.format("%s %s", data[0], data[1]);
					
	// 				PackageRequestTO packageRequestTO = new PackageRequestTO(
	// 					null, 
	// 					packageName, 
	// 					"", 
	// 					loc, 
	// 					null, 
	// 					"akash",
	// 					false);

	// 				packageService.createPackage(packageRequestTO);
	// 			}

	// 			scanner.close();
	// 		} catch (FileNotFoundException e) {
	// 			e.printStackTrace();
	// 		}
	// 		System.out.println("DONE");
	// 	};
	// }

}
