package project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Integer vaccineId;
    @Column(name = "vaccine_name")
    private String vaccineName;
    @Column(name = "description")
    private String description;
    @Column(name = "vaccine_price")
    private Double vaccinePrice;
    @ManyToMany(mappedBy = "vaccines")
    private List<MedicalRecord> medicalRecords;

    public Vaccine() {
        this.medicalRecords = new ArrayList<>();
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(Double vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
