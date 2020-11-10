package com.phoebus.pandemic.test.teste_phoebus;

import com.phoebus.pandemic.test.teste_phoebus.domain.Address;
import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.Occupation;
import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.repositories.AddressRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.OccupationRepository;
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

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OccupationRepository occupationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestePhoebusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Hospital hospital1 = new Hospital(null, "Hospital 1", "123456789");
		Hospital hospital2 = new Hospital(null, "Hospital 2", "987654321");

		Address address1 = new Address(null, "980", "58900000", "rua 1", "cajazeiras", "paraíba",-6.897299, -38.546489, hospital1);
		Address address2 = new Address(null, "9850", "58900000", "rua 2", "cajazeiras", "paraíba",-6.895259, -38.556789, hospital2);
		hospital1.setAddress(address1);
		hospital2.setAddress(address2);

		Occupation occupation1 = new Occupation(null,88.0, sdf.parse("10/10/2020 10:32"), hospital1);
		Occupation occupation2 = new Occupation(null,90.0, sdf.parse("10/10/2020 19:35"), hospital2);
		hospital1.setOccupation(occupation1);
		hospital2.setOccupation(occupation2);

		Resources res1 = new Resources(null, "Médico", 3);
		Resources res2 = new Resources(null, "Enfermeiro", 3);
		Resources res3 = new Resources(null, "Respirador", 5);
		Resources res4 = new Resources(null, "Tomógrafo", 12);
		Resources res5 = new Resources(null, "Ambulância", 10);

		hospital1.getResources().addAll(Arrays.asList(res1,res2,res3));
		hospital2.getResources().addAll(Arrays.asList(res1,res4,res5));

		resourcesRepository.saveAll(Arrays.asList(res1, res2, res3, res4, res5));

		occupationRepository.saveAll(Arrays.asList(occupation1,occupation2));
		addressRepository.saveAll(Arrays.asList(address1,address2));
		hospitalRepository.saveAll(Arrays.asList(hospital1,hospital2));

	}
}
