package com.phoebus.pandemic.test.teste_phoebus;

import com.phoebus.pandemic.test.teste_phoebus.domain.Address;
import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.Occupation;
import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class TestePhoebusApplication implements CommandLineRunner {

	@Autowired
	private ResourcesRepository resourcesRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestePhoebusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Resources res1 = new Resources(null, "Médico", 3);
		Resources res2 = new Resources(null, "Enfermeiro", 3);
		Resources res3 = new Resources(null, "Respirador", 5);
		Resources res4 = new Resources(null, "Tomógrafo", 12);
		Resources res5 = new Resources(null, "Ambulância", 10);

		resourcesRepository.saveAll(Arrays.asList(res1, res2, res3, res4, res5));

		Hospital hospital1 = new Hospital(null, "Hospital 1", "123456789");
		Hospital hospital2 = new Hospital(null, "Hospital 2", "987654321");

		hospital1.getResources().addAll(Arrays.asList(res1,res2,res3));
		hospital2.getResources().addAll(Arrays.asList(res1,res4,res5));

		hospitalRepository.saveAll(Arrays.asList(hospital1,hospital2));

	}
}
