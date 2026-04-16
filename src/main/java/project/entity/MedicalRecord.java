package project.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name ="Medical_Record")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;
    @Column(name = "examination_date", nullable = false)
    private LocalDate examinationDate;
    @Column(name = "diagnosis_result")
    private String diagnosisResult;
    @Column(name = "treatment_method")
    private String treatmentMethod;
    @Column(name = "incurred_cost")
    private Double incurredCost;
    @ManyToOne()
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Veterinarian veterinarian;
    @ManyToMany
    @JoinTable(
            name = "Record_Vaccine",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private List<Vaccine> vaccines; // @ManyToMany

    public MedicalRecord() {
        this.vaccines = new ArrayList<>();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public LocalDate getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(LocalDate examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public void setDiagnosisResult(String diagnosisResult) {
        this.diagnosisResult = diagnosisResult;
    }

    public String getTreatmentMethod() {
        return treatmentMethod;
    }

    public void setTreatmentMethod(String treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    public Double getIncurredCost() {
        return incurredCost;
    }

    public void setIncurredCost(Double incurredCost) {
        this.incurredCost = incurredCost;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public void add(Vaccine vaccine){
        this.vaccines.add(vaccine);
    }
}
