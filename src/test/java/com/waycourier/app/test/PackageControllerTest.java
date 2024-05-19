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

	
	@BeforeEach
	void init() {
	}
}
