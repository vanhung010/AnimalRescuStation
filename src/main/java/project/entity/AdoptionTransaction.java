package project.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Adoption_Transaction")
public class AdoptionTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Column(name = "official_handover_date")
    private LocalDate officialHandoverDate;
    @Column(name = "contribution_fee", nullable = false)
    private Double contributionFee;
    @ManyToOne()
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;
    @OneToOne()
    @JoinColumn(name = "animal_id")
    private Animal animal; //

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getOfficialHandoverDate() {
        return officialHandoverDate;
    }

    public void setOfficialHandoverDate(LocalDate officialHandoverDate) {
        this.officialHandoverDate = officialHandoverDate;
    }

    public Double getContributionFee() {
        return contributionFee;
    }

    public void setContributionFee(Double contributionFee) {
        this.contributionFee = contributionFee;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
