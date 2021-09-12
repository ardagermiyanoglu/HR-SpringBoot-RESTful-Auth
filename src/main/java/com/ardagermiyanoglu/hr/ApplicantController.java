package com.ardagermiyanoglu.hr;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path="/api/v1",
        produces="application/json")
@CrossOrigin(origins="*")
public class ApplicantController {

    private final ApplicantRepository repository;

    public ApplicantController(ApplicantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/applicants")
    @PreAuthorize("hasRole('USER')")
    public Iterable<Applicant> getApplicants() {
        return repository.findAll();
    }

    @PostMapping(value="/search")
    public List<Applicant> responseBodyApplicants(@RequestBody Applicant applicant) {

        List<Applicant> applicants = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        String firstName = applicant.getFirstName();
        String lastName = applicant.getLastName();
        Integer age = applicant.getAge();
        String gender = applicant.getGender();
        String educationStatus = applicant.getEducationStatus();
        String address = applicant.getAddress();
        String militaryStatusForMales = applicant.getMilitaryStatusForMales();
        String certificates = applicant.getCertificates();
        String foreignLanguageKnowledge = applicant.getForeignLanguageKnowledge();
        String programmingLanguages = applicant.getProgrammingLanguages();

        System.out.println("applicant: " + applicant);
        System.out.println("age: " + age);

        List<Applicant> filteredApplicants = applicants
                .stream()
                .filter(
                        c -> c.getFirstName().contains(firstName) &&
                                c.getLastName().contains(lastName) &&
                                c.getGender().contains(gender) &&
                                c.getAddress().contains(address) &&
                                c.getMilitaryStatusForMales().contains(militaryStatusForMales) &&
                                c.getForeignLanguageKnowledge().contains(foreignLanguageKnowledge) &&
                                c.getProgrammingLanguages().contains(programmingLanguages) &&
                                c.getCertificates().contains(certificates) &&
                                c.getEducationStatus().contains(educationStatus)
                )
                .collect(Collectors.toList());

        if(age != null){
            filteredApplicants = filteredApplicants.stream().filter(c -> c.getAge().equals(age)).collect(Collectors.toList());
        }

        System.out.println("filteredApplicants: " + filteredApplicants);
        return filteredApplicants;
    }

}
