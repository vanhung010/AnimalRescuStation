package project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Veterinarian")
@PrimaryKeyJoinColumn(name = "staff_id")
public class Veterinarian extends Staff {
    @Column(name = "license_number")
    private String licenseNumber;
    @Column(name = "specialty")
    private String specialty;
@OneToMany(mappedBy = "veterinarian")
    private List<MedicalRecord> medicalRecordList;


    public Veterinarian() {
        this.medicalRecordList = new ArrayList<>();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", specialty='" + specialty + '\'' +
                ", medicalRecordList=" + medicalRecordList +
                '}';
    }
}
