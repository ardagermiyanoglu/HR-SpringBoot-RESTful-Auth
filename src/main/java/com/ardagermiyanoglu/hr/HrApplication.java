package com.ardagermiyanoglu.hr;

import com.ardagermiyanoglu.hr.auth.User;
import com.ardagermiyanoglu.hr.auth.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrApplication {

    @Bean
    public CommandLineRunner run(ApplicantRepository repository, UserRepository userRepository) {
        return (args) -> {
            updateTableContent(repository, userRepository );
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

    private void updateTableContent(ApplicantRepository repository, UserRepository userRepository) {
        repository.deleteAll();
        repository.save(new Applicant("Ali", "Sayar", 21, "Male", "G University", "Ankara, Çankaya", "Completed", "Spring Certificate", "English", "C, C++"));
        repository.save(new Applicant("Ahmet", "Erdoğan", 34, "Male", "A University", "Ankara, Gölbaşı", "Completed", "Spring Certificate", "English", "Java"));
        repository.save(new Applicant("Mehmet", "Konyalı", 38, "Male", "V University", "Ankara, Batıkent", "Completed", "Spring Certificate", "English, German", "Python"));
        repository.save(new Applicant("Ozan", "Doğan", 43, "Male", "Z University", "Ankara, Gölbaşı", "Completed", "Spring Certificate", "English", "Java"));

        userRepository.deleteAll();
        userRepository.save(new User(1L, "arda", "$2a$08$.suL5XqpeUpyukmN/y/eLe/pRs2tiYlm4N99vUihTfGyQN3.fvw5S"));
        userRepository.save(new User(2L, "user", "$2a$08$.suL5XqpeUpyukmN/y/eLe/pRs2tiYlm4N99vUihTfGyQN3.fvw5S")); //password is -> 1234
    }

}
