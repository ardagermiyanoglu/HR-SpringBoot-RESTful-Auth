package com.ardagermiyanoglu.hr;

import javax.persistence.*;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String educationStatus;
    private String address;
    private String militaryStatusForMales;
    private String certificates;
    private String foreignLanguageKnowledge;
    private String programmingLanguages;

    public Applicant() {

    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", educationStatus='" + educationStatus + '\'' +
                ", address='" + address + '\'' +
                ", militaryStatusForMales='" + militaryStatusForMales + '\'' +
                ", certificates='" + certificates + '\'' +
                ", foreignLanguageKnowledge='" + foreignLanguageKnowledge + '\'' +
                ", programmingLanguages='" + programmingLanguages + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMilitaryStatusForMales() {
        return militaryStatusForMales;
    }

    public void setMilitaryStatusForMales(String militaryStatusForMales) {
        this.militaryStatusForMales = militaryStatusForMales;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public String getForeignLanguageKnowledge() {
        return foreignLanguageKnowledge;
    }

    public void setForeignLanguageKnowledge(String foreignLanguageKnowledge) {
        this.foreignLanguageKnowledge = foreignLanguageKnowledge;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public Applicant(String firstName, String lastName, Integer age, String gender, String educationStatus, String address, String militaryStatusForMales, String certificates, String foreignLanguageKnowledge, String programmingLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.educationStatus = educationStatus;
        this.address = address;
        this.militaryStatusForMales = militaryStatusForMales;
        this.certificates = certificates;
        this.foreignLanguageKnowledge = foreignLanguageKnowledge;
        this.programmingLanguages = programmingLanguages;
    }
}
