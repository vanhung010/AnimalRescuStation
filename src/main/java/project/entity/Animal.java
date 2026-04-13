package project.entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer animalId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "estimated_age", nullable = false)
    private Integer estimatedAge;
    @Column(name = "intake_date", nullable = false)
    private LocalDate intakeDate; //ngày vào
    @Column(name = "current_health_status", nullable = false)
    private String currentHealthStatus;
    @Column(name = "adoption_status", nullable = false)
    private String adoptionStatus;    //tình trạng nhận nuôi
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;
    @ManyToOne
    @JoinColumn(name = "mission_id")
    private RescueMission mission;
    @OneToOne(mappedBy = "animal")
    private AdoptionTransaction adoptionTransaction;
    @OneToMany(mappedBy = "animal")
    private List<MedicalRecord> medicalRecordList;

    public Animal() {
        this.medicalRecordList = new ArrayList<>();
    }
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(Integer estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public LocalDate getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(LocalDate intakeDate) {
        this.intakeDate = intakeDate;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public RescueMission getMission() {
        return mission;
    }

    public void setMission(RescueMission mission) {
        this.mission = mission;
    }


}
