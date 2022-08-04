package canovate.codechallenge;

import canovate.codechallenge.mobiledevice.Entity.MobileDevice;
import canovate.codechallenge.mobiledevice.Repository.MobileDeviceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CodechallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MobileDeviceRepository mobileDeviceRepository){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference <List<MobileDevice>> typeReference =new TypeReference<List<MobileDevice>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/devices.json");
			try {
				List<MobileDevice> dataDevices = mapper.readValue(inputStream,typeReference);
				mobileDeviceRepository.deleteAll();
				mobileDeviceRepository.saveAll(dataDevices);


			}
			catch(IOException e){
				System.out.println("Unable to save users: "+ e.getMessage());
			}

		};
	}


}
