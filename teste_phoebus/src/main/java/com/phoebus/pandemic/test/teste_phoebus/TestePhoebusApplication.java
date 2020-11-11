package com.phoebus.pandemic.test.teste_phoebus;

import com.phoebus.pandemic.test.teste_phoebus.domain.Hospital;
import com.phoebus.pandemic.test.teste_phoebus.domain.Resources;
import com.phoebus.pandemic.test.teste_phoebus.domain.Score;
import com.phoebus.pandemic.test.teste_phoebus.repositories.HospitalRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.ResourcesRepository;
import com.phoebus.pandemic.test.teste_phoebus.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class TestePhoebusApplication implements CommandLineRunner {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private ResourcesRepository resourcesRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestePhoebusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hospital hospital1 = new Hospital(null, "Hospital 1", "987466313", "998", "58900000", "rua 1", "cajazeiras",
				"paraiba", -6.897299, -38.546489,90.5, sdf.parse("9/10/2020 10:32"));

		Hospital hospital2 = new Hospital(null, "Hospital 2", "987466473", "977", "58900000", "rua 2", "cajazeiras",
				"paraiba", -6.897799, -38.546489,85.0, sdf.parse("10/10/2020 17:32"));


		Hospital hospital3 = new Hospital(null, "Hospital 3", "987466473", "987", "58900000", "rua 3", "cajazeiras",
				"paraiba", -6.897729, -38.547489,85.0, sdf.parse("11/10/2020 17:32"));

		Resources res1 = new Resources(null, "Médico", 3);
		Resources res2 = new Resources(null, "Enfermeiro", 3);
		Resources res3 = new Resources(null, "Respirador", 5);
		Resources res4 = new Resources(null, "Tomógrafo", 12);
		Resources res5 = new Resources(null, "Ambulância", 10);

		Score score = new Score(null, 15);

		hospital1.getResources().addAll(Arrays.asList(res1,res1,res1,res1,res1));
		hospital2.getResources().addAll(Arrays.asList(res1,res4));
		hospital3.getResources().addAll(Arrays.asList(res3,res5));

		resourcesRepository.saveAll(Arrays.asList(res1, res2, res3, res4, res5));
		hospitalRepository.saveAll(Arrays.asList(hospital1,hospital2, hospital3));
		scoreRepository.save(score);

	}
}
