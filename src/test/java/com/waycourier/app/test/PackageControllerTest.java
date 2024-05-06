package com.waycourier.app.test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.models.Package;
import com.waycourier.app.service.PackageService;

@SpringBootTest
public class PackageControllerTest {
	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	PackageService packageService;
	
	private List<Package> packages;
	
	@BeforeEach
	void init() {
		Package package1 = new Package();
		
		package1.setPackageId("PK001");
		package1.setPkgAddress("Mommy address, Desrt sdfdsf - 12478");
		package1.setRecptMobNo("1254785");
		package1.setPkgLatitude(162.3654);
		package1.setPkgLongitude(142.3654);
		package1.setPkgStatus(PackageStatus.CANCELLED);
		package1.setCreatedAt(new Date(253402300799000L));
		package1.setRecEndDate(new Date());
		package1.setFragile(true);

		Package package2 = new Package();
		package2.setPackageId("PK002");
		package2.setPkgAddress("Another address");
		package2.setRecptMobNo("987654321");
		package2.setPkgLatitude(100.1234);
		package2.setPkgLongitude(200.5678);
		package2.setPkgStatus(PackageStatus.DELIVERED);
		package2.setCreatedAt(new Date(253402300799000L));
		package2.setRecEndDate(new Date());
		package2.setFragile(false);
     
         packages.add(package1);
         packages.add(package2);
	}
}
