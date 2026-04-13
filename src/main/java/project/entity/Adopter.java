package project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Adopter")
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adopter_id")
    private Integer adopterId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "residential_address")
    private String residentialAddress;
    @Column(name = "application_approval_status")
    private String applicationApprovalStatus;
    @OneToMany(mappedBy = "adopter")
    private List<AdoptionTransaction> transactions; // @OneToMany

    public Adopter() {
        this.transactions = new ArrayList<>();
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer adopterId) {
        this.adopterId = adopterId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getApplicationApprovalStatus() {
        return applicationApprovalStatus;
    }

    public void setApplicationApprovalStatus(String applicationApprovalStatus) {
        this.applicationApprovalStatus = applicationApprovalStatus;
    }

    public List<AdoptionTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<AdoptionTransaction> transactions) {
        this.transactions = transactions;
    }
}
